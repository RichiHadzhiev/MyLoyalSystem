package com.frantishex.loyalsystem.api.services;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frantishex.loyalsystem.api.entities.Customer;
import com.frantishex.loyalsystem.api.entities.Merchant;
import com.frantishex.loyalsystem.api.entities.Sale;

@Service
@Transactional
public class ServiceFacade {
	
	@Autowired
	private MerchantService ms;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private SaleService ss;
	
	public List<Sale> getAllSales(Long customerId){
		return ss.getAllSales(customerId);
	}
	
	public Sale getSale(Long id) {
		return ss.getSale(id);
	}
	
	public void addSale(Sale sale, Long customerId) throws Exception {
		Customer customer = cs.getCustomer(customerId);
		sale.setDiscount(customer.getDiscount());
		sale.setDiscounted_price(sale.getPrice().subtract(sale.getPrice().multiply(sale.getDiscount().divide(new BigDecimal(100)))));
		sale.setSalePoints(customer.getMerchant().getScale().multiply(sale.getDiscounted_price()));
		customer.setTurnOver(customer.getTurnOver().add(sale.getDiscounted_price()));
		customer.setPoints(customer.getPoints().add(sale.getSalePoints()));
		sale.setCustomer(customer);
		ss.addSale(sale);
	}
	
	public List<Customer> getAllCustomers(Long merchantId){
		return cs.getAllCustomers(merchantId);
	}
	
	public Customer getCustomer(Long id) throws Exception {
		return cs.getCustomer(id);
	}
	
	public void addCustomer(Customer customer, Long merchantId) throws Exception {
		Merchant merchant = ms.getMerchant(merchantId);
		customer.setMerchant(merchant);
		if(customer.getDiscount() == null) {
			customer.setDiscount(merchant.getDiscount());
		}
		customer.setTurnOver(new BigDecimal(0));
		customer.setPoints(new BigDecimal(0));
		cs.addCustomer(customer);
	}
	
	public List<Merchant> getAllMerchants(){
		return ms.getAllMerchants();
	}
	
	public Merchant getMerchant(Long id) throws Exception {
		return ms.getMerchant(id);
	}
	
	public void addMerchant(Merchant merchant) {
		ms.addMerchant(merchant);
	}
}
