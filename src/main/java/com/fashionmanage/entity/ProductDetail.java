package com.fashionmanage.entity;

import java.util.List;

public class ProductDetail {
	private int productId;
	private int size;
	private String color;
	private int quantity;

	public ProductDetail() {
		// TODO Auto-generated constructor stub
	}

	public ProductDetail(int productId, List<Integer> sizes, List<String> colors, List<Integer> quantities) {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDetail(int productId, int size, String color, int quantity) {
		super();
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}
}