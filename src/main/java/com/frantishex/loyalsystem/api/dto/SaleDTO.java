package com.frantishex.loyalsystem.api.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.frantishex.loyalsystem.api.entities.Sale;

public class SaleDTO {
	
	private BigDecimal price;
	
	private BigDecimal discount;
	
	private BigDecimal discounted_price;
	
	private BigDecimal salePoints;
	
	private String customerName;
	
	private BigDecimal merchantDiscount;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(BigDecimal discounted_price) {
		this.discounted_price = discounted_price;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getMerchantDiscount() {
		return merchantDiscount;
	}

	public void setMerchantDiscount(BigDecimal merchantDiscount) {
		this.merchantDiscount = merchantDiscount;
	}
	
	public BigDecimal getSalePoints() {
		return salePoints;
	}

	public void setSalePoints(BigDecimal salePoints) {
		this.salePoints = salePoints;
	}

	public static SaleDTO entityToDTO(Sale sale) {
		ModelMapper mp = new ModelMapper();
		mp.addMappings(new PropertyMap<Sale,SaleDTO>(){
			@Override
			protected void configure() {
				map().setCustomerName(source.getCustomer().getName());
				map().setMerchantDiscount(source.getCustomer().getMerchant().getDiscount());
			}
		});
		SaleDTO dto = mp.map(sale, SaleDTO.class);
		return dto;
	}
}
