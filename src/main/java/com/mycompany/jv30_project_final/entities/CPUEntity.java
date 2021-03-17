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
@Table(name = "cpu")
public class CPUEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cpu_technology")
	private String cpuTechology;
	
	@Column(name = "cpu_speed")
	private String cpuSpeed;
	
	@OneToMany(mappedBy = "cpuEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductEntity> productEntities;

	public CPUEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpuTechology() {
		return cpuTechology;
	}

	public void setCpuTechology(String cpuTechology) {
		this.cpuTechology = cpuTechology;
	}

	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}
	
	
	
}
