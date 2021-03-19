package com.mycompany.jv30_project_final.model;

public class ProductModel {
	private int productId;
	
	private int colorId;
	
	private double price;
	
	private String image;
	
	private int quantity;
	
	private String name;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductModel(int productId, int colorId, double price, String image, int quantity, String name) {
		super();
		this.productId = productId;
		this.colorId = colorId;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.name = name;
	}
	
	public ProductModel() {
		
	}
}
