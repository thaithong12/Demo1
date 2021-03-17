package com.mycompany.jv30_project_final.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class ColorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "colorEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductColorEntity> productColorEntities;

	public ColorEntity() {
		super();
	}

	public ColorEntity(String name, List<ProductColorEntity> productColorEntities) {
		super();
		this.name = name;
		this.productColorEntities = productColorEntities;
	}

	public ColorEntity(int id, String name, List<ProductColorEntity> productColorEntities) {
		super();
		this.id = id;
		this.name = name;
		this.productColorEntities = productColorEntities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductColorEntity> getProductColorEntities() {
		return productColorEntities;
	}

	public void setProductColorEntities(List<ProductColorEntity> productColorEntities) {
		this.productColorEntities = productColorEntities;
	}

}
