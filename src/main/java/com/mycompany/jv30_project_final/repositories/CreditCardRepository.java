package com.mycompany.jv30_project_final.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.CreditCardEntity;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer>{
	
	CreditCardEntity findBycardNumber(String cardNumber);
}
