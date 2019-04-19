package com.frantishex.loyalsystem.api.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.loyalsystem.api.entities.Merchant;

@Service
@Transactional
public class MerchantService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Merchant> getAllMerchants(){
		return em.createQuery("select m from Merchant m", Merchant.class).getResultList();
	}
	
	public Merchant getMerchant(Long id) throws Exception {
		Merchant merchant = em.find(Merchant.class, id);
		if (merchant == null) {
			throw new Exception("There is no merchant with id " + id);
		}
		return merchant;
	}

	public void addMerchant(Merchant merchant) {
		em.persist(merchant);
	}
}
