package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.CommentEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<CommentEntity> findByProductEntity(ProductEntity p){
		return commentRepository.findByProductEntity(p);
	}

}
