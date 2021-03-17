package com.mycompany.jv30_project_final.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.CommentEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
	public List<CommentEntity> findByProductEntity(ProductEntity p);

}
