package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.CategoryEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> getNewProducts() {
		return productRepository.getNewProducts();
	}
	
	public List<ProductEntity> getTopSellingProducts(){
		return productRepository.getTopSellingProduct();
	}
	
	public List<ProductEntity> getRandomProductLimit(int s, int e){
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
		entities = entities.subList(s, e);
		return entities;
	}
	
	public ProductEntity getProductById(int id) {
		return productRepository.findOne(id);
	}
	
	public List<ProductEntity> getAllProducts() {
		return (List<ProductEntity>) productRepository.findAll();
	}
	
	public List<ProductEntity> findByCategoryEntity(CategoryEntity categoryEntity) {
		return productRepository.findByCategoryEntity(categoryEntity);
	}
}
