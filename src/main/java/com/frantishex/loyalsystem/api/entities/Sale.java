package com.frantishex.loyalsystem.api.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal price;
	
	private BigDecimal discount;
	
	private BigDecimal discounted_price;
	
	private BigDecimal salePoints;
	
	@ManyToOne
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getSalePoints() {
		return salePoints;
	}

	public void setSalePoints(BigDecimal salePoints) {
		this.salePoints = salePoints;
	}
	
	
	
}
