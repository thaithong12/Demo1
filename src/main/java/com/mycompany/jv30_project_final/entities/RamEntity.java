package com.mycompany.jv30_project_final.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ram")
public class RamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ram_type")
	private String ramType;

	@Column(name = "bus_ram_Speed")
	private String busRamSpeed;

	private String description;

	@OneToMany(mappedBy = "ramEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductEntity> productEntities;

	public RamEntity() {
		super();
	}

	public RamEntity(int id, String ramType, String busRamSpeed, String description,
			List<ProductEntity> productEntities) {
		super();
		this.id = id;
		this.ramType = ramType;
		this.busRamSpeed = busRamSpeed;
		this.description = description;
		this.productEntities = productEntities;
	}

	public RamEntity(String ramType, String busRamSpeed, String description, List<ProductEntity> productEntities) {
		super();
		this.ramType = ramType;
		this.busRamSpeed = busRamSpeed;
		this.description = description;
		this.productEntities = productEntities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public String getBusRamSpeed() {
		return busRamSpeed;
	}

	public void setBusRamSpeed(String busRamSpeed) {
		this.busRamSpeed = busRamSpeed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}

}
