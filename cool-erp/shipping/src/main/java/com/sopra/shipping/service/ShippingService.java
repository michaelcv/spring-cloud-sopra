package com.sopra.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.shipping.model.Shipping;
import com.sopra.shipping.repository.ShippingRepository;

@Service
public class ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;
	
	public void test() {
		Shipping shipping = new Shipping();
		shippingRepository.save(shipping);
		
	}
	
	public Shipping getShipping(int saleId) {
	    Shipping shipping = shippingRepository.findBySaleId( saleId); // TODO
	    return shipping;
	}

	public void confirmShipping(int shippingId) {
		// TODO Auto-generated method stub
		
	}

	public void createShipping(int productId, int saleId) {
		// TODO Auto-generated method stub
		
	}

	
	
}
