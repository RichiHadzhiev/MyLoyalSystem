package com.frantishex.loyalsystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frantishex.loyalsystem.api.dto.CustomerDTO;
import com.frantishex.loyalsystem.api.dto.SaleDTO;
import com.frantishex.loyalsystem.api.entities.Customer;
import com.frantishex.loyalsystem.api.entities.Merchant;
import com.frantishex.loyalsystem.api.entities.Sale;
import com.frantishex.loyalsystem.api.services.ServiceFacade;


@RestController
public class Controller {
	
	@Autowired
	private ServiceFacade facade;
	
	//Sales requests
	
	@RequestMapping("/customers/{customerId}/sales")
	public List<SaleDTO> getAllSales(@PathVariable Long customerId){
		List<SaleDTO> dtos = new ArrayList<SaleDTO>();
		List<Sale> sales = facade.getAllSales(customerId);
		for(Sale sale : sales) {
			dtos.add(SaleDTO.entityToDTO(sale));
		}
		return dtos;
	}
	
	@RequestMapping("/customers/{customerId}/sales/{id}")
	public SaleDTO getSale(@PathVariable Long id) {
		return SaleDTO.entityToDTO(facade.getSale(id));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/{customerId}/sales")
	public void addSale(@RequestBody Sale sale, @PathVariable Long customerId) throws Exception {
		facade.addSale(sale, customerId);
	}
	
	//Customers requests
	
	@RequestMapping("/merchants/{merchantId}/customers")
	public List<CustomerDTO> getAllCustomers(@PathVariable Long merchantId) {
		List<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		List<Customer> customers = facade.getAllCustomers(merchantId);
		for(Customer customer : customers) {
			dtos.add(CustomerDTO.entityToDTO(customer));
		}
		return dtos;
	}
	
	@RequestMapping("/merchants/{merchantId}/customers/{id}")
	public CustomerDTO getCustomer(@PathVariable Long id) throws Exception {
		return CustomerDTO.entityToDTO(facade.getCustomer(id));
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
