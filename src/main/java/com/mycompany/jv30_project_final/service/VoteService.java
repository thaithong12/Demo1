package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.entities.VoteEntity;
import com.mycompany.jv30_project_final.repositories.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository voteRepository;
	
	public List<VoteEntity> findByProductEntity(ProductEntity p){
		return voteRepository.findByProductEntity(p);
	}
}
