package com.mycompany.jv30_project_final.model;

public class ProductColorModel {
	private int productId;
	
	private int colorId;
	
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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

	
	public ProductColorModel(int productId, int colorId, double price) {
		super();
		this.productId = productId;
		this.colorId = colorId;
		this.price = price;
	}

	public ProductColorModel() {
		// TODO Auto-generated constructor stub
	}
}
