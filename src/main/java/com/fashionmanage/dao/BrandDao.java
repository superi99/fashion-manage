package com.fashionmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionmanage.entity.Brand;

public class BrandDao {
	
	private QueryExecutor executor = QueryExecutor.getInstance();
	
	public List<Brand> getAllBrands() {
		List<Brand> categories = new ArrayList<Brand>();
		Brand brand = null;
		try {
			ResultSet rs = executor.getResultSet("select * from public.\"BrandTBL\"");
			while(rs.next()){
				brand = createEntity(rs);
				categories.add(brand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	private Brand createEntity(ResultSet rs) {
		Brand brand = new Brand();
		try {
			brand.setBrandId(rs.getInt(1));
			brand.setBrandName(rs.getString(2));
		} catch (SQLException e) {
		//	LOGGER.error("SQL exception1 " + e.getMessage());
			e.printStackTrace();
		}
		return brand;
	}
}
