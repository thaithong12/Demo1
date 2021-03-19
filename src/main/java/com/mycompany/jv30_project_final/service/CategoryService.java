package com.mycompany.jv30_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.CategoryEntity;
import com.mycompany.jv30_project_final.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryEntity> getAllCategories() {
		return (List<CategoryEntity>) categoryRepository.findAll();
	}
	
	public CategoryEntity findOne(int id) {
		return categoryRepository.findOne(id);
	}
}
