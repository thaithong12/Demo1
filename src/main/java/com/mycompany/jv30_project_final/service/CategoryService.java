package com.mycompany.jv30_project_final.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mycompany.jv30_project_final.entities.CategoryEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;
import com.mycompany.jv30_project_final.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductService productService;
	
	public List<CategoryEntity> getAllCategories() {
		return (List<CategoryEntity>) categoryRepository.findAll();
	}
	
	public CategoryEntity findOne(int id) {
		return categoryRepository.findOne(id);
	}
	
	public List<ProductEntity> getListProductByCategoryName(String name ){
		List<CategoryEntity> categoryEntities = categoryRepository.findByNameLike("%"+name+"%");
		if (!CollectionUtils.isEmpty(categoryEntities)) {
			List<ProductEntity> entitieReturn = new ArrayList<ProductEntity>();
			List<ProductEntity> entities;
			for(CategoryEntity categoryEntity : categoryEntities) {
				entities = productService.findByCategoryEntity(categoryEntity);
				entitieReturn.addAll(entities);
			}
			return entitieReturn;
		} else {
			return null;
		}
	}
}
