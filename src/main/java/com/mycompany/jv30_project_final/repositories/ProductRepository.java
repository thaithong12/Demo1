package com.mycompany.jv30_project_final.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
	
}
