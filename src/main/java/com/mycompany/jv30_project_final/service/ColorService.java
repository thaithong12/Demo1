package com.mycompany.jv30_project_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jv30_project_final.entities.ColorEntity;
import com.mycompany.jv30_project_final.repositories.ColorRepository;

@Service
public class ColorService {
	@Autowired
	private ColorRepository colorRepository;
	
	public ColorEntity findById(int id) {
		return colorRepository.findOne(id);
	}
}
