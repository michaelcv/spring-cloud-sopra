package com.invivoo.coolerp.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.invivoo.coolerp.test.model.Inventory;
import com.invivoo.coolerp.test.model.Page;
import com.invivoo.coolerp.test.model.Product;
import com.invivoo.coolerp.test.model.PurchaseOrder;
import com.invivoo.coolerp.test.model.Reception;
import com.invivoo.coolerp.test.model.Sale;
import com.invivoo.coolerp.test.model.Shipping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoolErpTestApplication.class)
public class RunFullIntegrationTests {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${coolerp.url}")
	private String url;

	@Test
	public void testNewOrder() {
		// Load a product.
		Product product = restTemplate.exchange(url + "/product-service/product", HttpMethod.GET, null,
				new ParameterizedTypeReference<Page<Product>>() {
				}).getBody().getContent().stream().findFirst().get();

		// Generate a new purchase order
		PurchaseOrder purchaseOrder = restTemplate
				.exchange(url + "/purchase-order-service/purchase-order?new&productId=" + product.getId(),
						HttpMethod.POST, null, PurchaseOrder.class)
				.getBody();

		// Checks that the purchase order as the proper status
		Assert.assertEquals("CONFIRMED", purchaseOrder.getStatus());

		// Checks that an incoming reception has been opened.
		Reception reception = restTemplate
				.exchange(url + "/reception-service/reception?purchaseOrderId=" + purchaseOrder.getId(), HttpMethod.GET,
						null, Reception.class)
				.getBody();

		// Checks that the reception has the proper status.
		Assert.assertEquals("OPEN", reception.getStatus());

		// Load the current inventory for the prody.
		double inventoryOnHandBeforeReception = getProducInventory(product.getId()).getOnHand();
		double inventoryOnHoldBeforeReception = getProducInventory(product.getId()).getOnHold();

		// Confirm the reception of the product.
		Reception confirmedReception = restTemplate
				.exchange(url + "/reception-service/reception/" + reception.getId() + "?receive", HttpMethod.POST, null,
						Reception.class)
				.getBody();

		Assert.assertEquals("RECEIVED", confirmedReception.getStatus());

		// Checks that the purchase order status has been updated.
		PurchaseOrder closedPurchaseOrder = restTemplate
				.exchange(url + "/purchase-order-service/purchase-order/" + purchaseOrder.getId(), HttpMethod.GET, null,
						PurchaseOrder.class)
				.getBody();

		Assert.assertEquals("CLOSED", closedPurchaseOrder);

		// Checks that the inventory has been properly updated.
		Assert.assertEquals(inventoryOnHandBeforeReception + 1, getProducInventory(product.getId()).getOnHand(),
				0.001d);
		Assert.assertEquals(inventoryOnHoldBeforeReception, getProducInventory(product.getId()).getOnHold(), 0.001d);

		// Create a new sale for the product.
		Sale paidSale = restTemplate.exchange(url + "/sale-service/sale?new&productId=" + product.getId(),
				HttpMethod.POST, null, Sale.class).getBody();

		Assert.assertEquals("PAID", paidSale.getStatus());

		// Checks that the inventory has been decreased.
		double inventoryOnHandAfterSale = getProducInventory(product.getId()).getOnHand();
		double inventoryOnHoldAfterSale = getProducInventory(product.getId()).getOnHand();

		Assert.assertEquals(inventoryOnHandBeforeReception, inventoryOnHandAfterSale, 0.001d);
		Assert.assertEquals(inventoryOnHoldBeforeReception + 1, inventoryOnHoldAfterSale, 0.001d);

		// Asserts that a shipping as been created.
		Shipping createdShipping = restTemplate.exchange(url + "/shipping-service/shipping?saleId=" + paidSale.getId(),
				HttpMethod.GET, null, Shipping.class).getBody();

		Assert.assertEquals("OPEN", createdShipping.getStatus());

		// Confirms that the shipping has been processed.
		Shipping processedShipping = restTemplate
				.exchange(url + "/shipping-service/shipping/" + createdShipping.getId() + "?ship", HttpMethod.POST,
						null, Shipping.class)
				.getBody();

		Assert.assertEquals("PROCESSED", processedShipping.getStatus());

		// Checks that the inventory has been updated properly.
		Assert.assertEquals(inventoryOnHandAfterSale, getProducInventory(product.getId()).getOnHand(), 0.001d);
		Assert.assertEquals(inventoryOnHoldBeforeReception, getProducInventory(product.getId()).getOnHand(), 0.001d);
	}

	private Inventory getProducInventory(long productId) {
		return restTemplate.exchange(url + "/inventory-service/inventory", HttpMethod.POST,
				new HttpEntity<List<Long>>(Arrays.asList(productId)),
				new ParameterizedTypeReference<Map<Long, Inventory>>() {
				})

				.getBody().entrySet().stream()

				.filter(entry -> entry.getKey().longValue() == productId).map(Entry::getValue)

				.findAny().get();
	}

}
