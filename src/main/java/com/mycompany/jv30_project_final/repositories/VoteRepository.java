package com.mycompany.jv30_project_final.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.entities.VoteEntity;

@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, Integer> {
	public List<VoteEntity> findByProductEntity(ProductEntity p);
}
