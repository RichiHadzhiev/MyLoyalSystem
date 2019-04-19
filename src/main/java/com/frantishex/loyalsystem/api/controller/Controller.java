package com.frantishex.loyalsystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frantishex.loyalsystem.api.entities.Customer;
import com.frantishex.loyalsystem.api.entities.Merchant;
import com.frantishex.loyalsystem.api.services.ServiceFacade;


@RestController
public class Controller {
	
	@Autowired
	private ServiceFacade facade;
	
	//Customers requests
	
	@RequestMapping("/merchants/{merchantId}/customers")
	public List<Customer> getAllCustomers(@PathVariable Long merchantId) {
		return facade.getAllCustomers(merchantId);
	}
	
	@RequestMapping("/merchants/{merchantId}/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) throws Exception {
		return facade.getCustomer(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/merchants/{merchantId}/customers")
	public void addCustomer(@RequestBody Customer customer, @PathVariable Long merchantId) throws Exception {
		facade.addCustomer(customer, merchantId);
	}
	
	//Merchants requests
	
	@RequestMapping("/merchants")
	public List<Merchant> getAllMerchants() {
		return facade.getAllMerchants();
	}
	
	@RequestMapping("/merchants/{id}")
	public Merchant getMerchant(@PathVariable Long id) throws Exception {
		return facade.getMerchant(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/merchants")
	public void addMerchant(@RequestBody Merchant merchant) {
		facade.addMerchant(merchant);
	}
}
