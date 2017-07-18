package com.sopra.boot.atelier1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sopra.boot.atelier1.model.Invoice;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {
	private JdbcTemplate jdbcTemplate;

	public InvoiceRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private Invoice findById(int id) {
		return jdbcTemplate.queryForObject("SELECT id, date FROM invoice", Invoice.class);
	}

	@Override
	public List<Invoice> findAll() {
		return jdbcTemplate.query("SELECT id, date FROM invoice", (rs, rowNum) -> {
			return new Invoice(rs.getInt("id"), new Date(rs.getTimestamp("date").getTime()));
		});
	}

	@Override
	public void save(Invoice invoice) {
		try{
			int id = findById(invoice.getId()).getId();
			
			jdbcTemplate.update("UPDATE invoice set date = ? WHERE id = ?", invoice.getDatetime(), id);
		}catch(EmptyResultDataAccessException ex){
			jdbcTemplate.update("INSERT into invoice (date) VALUES (?)", invoice.getDatetime());	
		}
	}
}
