package com.sopra.cloud.purchaseorder.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.cloud.purchaseorder.model.PurchaseOrder;
import com.sopra.cloud.purchaseorder.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService pPurchaseOrderReceived) {
        purchaseOrderService = pPurchaseOrderReceived;
    }

    @PatchMapping(value = "/{purchaseOrderId}")
    public PurchaseOrder purchaseOrderReceived(@PathVariable("purchaseOrderId") long pPurchaseOrderId) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(pPurchaseOrderId);
        purchaseOrder.setStatus("CLOSED");

        // TODO check order exist.

        return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
    }

    @PostMapping(value = "/")
    public PurchaseOrder createPurchaseOrder(PurchaseOrder pPurchaseOrder) {
        /* 1. Check product exists. */

        /* 2. Create purchase order. */
        PurchaseOrder createdPurchaseOrder = purchaseOrderService.createPurchaseOrder(pPurchaseOrder);

        /* 3. Inform reception purchase order created. */

        return createdPurchaseOrder;
    }

}
