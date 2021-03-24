package com.mycompany.jv30_project_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.CreditCardEntity;
import com.mycompany.jv30_project_final.repositories.CreditCardRepository;

@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository cardRepository;
	
	public CreditCardEntity findById(int id) {
		return cardRepository.findOne(id);
	}
	
	public CreditCardEntity findByCardNumber(String  cardNumber) {
		return cardRepository.findBycardNumber(cardNumber);
	}
	
	public void saveCreditCard(CreditCardEntity cardEntity) {
		cardRepository.save(cardEntity);
	}
	
}
