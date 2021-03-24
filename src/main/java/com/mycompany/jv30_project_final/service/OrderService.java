package com.mycompany.jv30_project_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.OrderEntity;
import com.mycompany.jv30_project_final.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public int saveOrder(OrderEntity o ) {
		return orderRepository.save(o).getId();
	}

}
