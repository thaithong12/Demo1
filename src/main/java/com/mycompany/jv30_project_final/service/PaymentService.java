package com.mycompany.jv30_project_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.PaymentEntity;
import com.mycompany.jv30_project_final.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public int savePayment(PaymentEntity p) {
		return paymentRepository.save(p).getId();
	}
}
