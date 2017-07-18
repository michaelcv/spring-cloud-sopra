package com.sopra.boot.atelier1.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.boot.atelier1.Atelier1Application;
import com.sopra.boot.atelier1.model.Invoice;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Atelier1Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class InvoiceRepositoryImplTest {
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Test
	public void testRepository() {
		invoiceRepository.save(new Invoice(0, new Date()));

		Assert.assertFalse(invoiceRepository.findAll().isEmpty());
	}
}
