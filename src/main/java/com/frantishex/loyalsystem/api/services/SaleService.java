package com.frantishex.loyalsystem.api.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.loyalsystem.api.entities.Sale;

@Service
@Transactional
public class SaleService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Sale> getAllSales(Long customerId){
		TypedQuery<Sale> query = em.createQuery("select s from Sale s where s.customer.id=?1", Sale.class);
		return query.setParameter(1, customerId).getResultList();
	}
	
	public Sale getSale(Long id) {
		return em.find(Sale.class, id);
	}
	
	public void addSale(Sale sale) {
		em.persist(sale);
	}
}
