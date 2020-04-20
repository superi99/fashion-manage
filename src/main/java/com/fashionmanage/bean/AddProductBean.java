package com.fashionmanage.bean;

import java.util.List;

import com.fashionmanage.dao.BrandDao;
import com.fashionmanage.dao.CategoryDao;
import com.fashionmanage.entity.Brand;
import com.fashionmanage.entity.Category;

public class AddProductBean {
	
	public List<Category> getAllCategories(){
		 return new CategoryDao().getAllCategories();
	}
	
	public List<Brand> getAllBrands(){
		return new BrandDao().getAllBrands();
	}
}
