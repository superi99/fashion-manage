package com.fashionmanage.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private int productId;
	private String productName;
	private int unitPrice;
	private String description;
	private Brand brand;
	private Category category;
	private Date lastUpdate;
	private int sale;
	private List<String> imgs = new ArrayList<>();;
	private List<ProductDetail> productDetails = new ArrayList<>();

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, int unitPrice, String description, Brand brand, Category category,
			Date lastUpdate, int sale) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.lastUpdate = lastUpdate;
		this.sale = sale;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

}
