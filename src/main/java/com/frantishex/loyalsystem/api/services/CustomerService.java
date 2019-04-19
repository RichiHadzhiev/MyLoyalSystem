package com.frantishex.loyalsystem.api.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.loyalsystem.api.entities.Customer;

@Service
@Transactional
public class CustomerService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Customer> getAllCustomers(Long merchantId){
		TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.merchant.id=?1", Customer.class);
		return query.setParameter(1, merchantId).getResultList();
	}
	
	public Customer getCustomer(Long id) throws Exception {
		Customer customer = em.find(Customer.class, id);
		if (customer == null) {
			throw new Exception("There is no customer with id " + id);
		}
		return customer;
	}

	public void addCustomer(Customer customer) {
		em.persist(customer);
	}
	
}
