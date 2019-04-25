package com.frantishex.loyalsystem.api.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private BigDecimal discount;
	
	private BigDecimal turnOver;
	
	private BigDecimal points;

	@ManyToOne
	private Merchant merchant;

	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getDiscount() {
		return this.discount;
	}
	
	public BigDecimal getTurnOver() {
		return turnOver;
	}
	
	public Merchant getMerchant() {
		return merchant;
	}
	
	public BigDecimal getPoints() {
		return points;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public void setTurnOver(BigDecimal turnOver) {
		this.turnOver = turnOver;
	}
	
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	
	
}