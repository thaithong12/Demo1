package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> getNewProducts() {
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
		entities = entities.size() >=4 ? entities.subList(0, 4) : entities.subList(0, entities.size());
		return entities;
	}
	
	public List<ProductEntity> getRandomProductLimit(int s, int e){
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
		entities = entities.subList(s, e);
		return entities;
	}
}
