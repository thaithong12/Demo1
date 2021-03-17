package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.entities.ProductColorEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.repositories.ProductColorRepository;

@Service
public class ProductColorService {
	@Autowired
	ProductColorRepository productColorRepository;
	
	public List<ProductColorEntity> findByProductEntity(ProductEntity p) {
		return productColorRepository.findByProductEntity(p);
	}
	
	public ProductColorEntity findByProductEntityAndColorEntity(ProductEntity p, ColorEntity c) {
		return productColorRepository.findByProductEntityAndColorEntity(p, c);
	}

}
