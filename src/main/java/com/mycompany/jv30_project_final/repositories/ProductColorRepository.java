package com.mycompany.jv30_project_final.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.entities.ProductColorEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;

@Repository
public interface ProductColorRepository extends CrudRepository<ProductColorEntity, Integer> {
	public List<ProductColorEntity> findByProductEntity(ProductEntity p);
	
	public ProductColorEntity findByProductEntityAndColorEntity(ProductEntity p, ColorEntity c);
}
