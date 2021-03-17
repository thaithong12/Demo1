package com.mycompany.jv30_project_final.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_color")
public class ProductColorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double price;

	private double qantity;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private ColorEntity colorEntity;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;

	public ProductColorEntity(int id, double price, double qantity, ColorEntity colorEntity,
			ProductEntity productEntity) {
		super();
		this.id = id;
		this.price = price;
		this.qantity = qantity;
		this.colorEntity = colorEntity;
		this.productEntity = productEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public ProductColorEntity() {
		super();
	}

	public ProductColorEntity(double price, double qantity, ColorEntity colorEntity) {
		super();
		this.price = price;
		this.qantity = qantity;
		this.colorEntity = colorEntity;
	}

	public ProductColorEntity(int id, double price, double qantity, ColorEntity colorEntity) {
		super();
		this.id = id;
		this.price = price;
		this.qantity = qantity;
		this.colorEntity = colorEntity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQantity() {
		return qantity;
	}

	public void setQantity(double qantity) {
		this.qantity = qantity;
	}

	public ColorEntity getColorEntity() {
		return colorEntity;
	}

	public void setColorEntity(ColorEntity colorEntity) {
		this.colorEntity = colorEntity;
	}

}
