package com.frantishex.loyalsystem.api.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.frantishex.loyalsystem.api.entities.Customer;

public class CustomerDTO {

	private String name;
	
	private BigDecimal discount;
	
	private BigDecimal turnOver;
	
	private BigDecimal merchantDiscount;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(BigDecimal turnOver) {
		this.turnOver = turnOver;
	}

	public BigDecimal getMerchantDiscount() {
		return merchantDiscount;
	}

	public void setMerchantDiscount(BigDecimal merchantDiscount) {
		this.merchantDiscount = merchantDiscount;
	}
	
	public static CustomerDTO entityToDTO(Customer customer) {
		ModelMapper mp = new ModelMapper();
		mp.addMappings(new PropertyMap<Customer,CustomerDTO>(){
			@Override
			protected void configure() {
				map().setMerchantDiscount(source.getMerchant().getDiscount());
			}
		});
		CustomerDTO dto = mp.map(customer, CustomerDTO.class);
		return dto;
	}
}
