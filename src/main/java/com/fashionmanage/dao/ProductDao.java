package com.fashionmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fashionmanage.entity.Product;
import com.fashionmanage.entity.ProductDetail;

public class ProductDao {

	private QueryExecutor executor = QueryExecutor.getInstance();
	
	private Product createEntity(ResultSet rs) {
		Product p = new Product();
		try {
			p.setProductId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setUnitPrice(rs.getInt(3));
			p.setDescription(rs.getString(4));
			p.setFeatureImage(rs.getString("FeatureImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Product product = null;
		try {
			ResultSet rs = executor.getResultSet("select * from public.\"ProductTBL\"");
			while (rs.next()) {
				product = createEntity(rs);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	

	public int insert(Product p, String []genders) {
		int entityId = -1;

		try {
			Context ct = (Context) new InitialContext().lookup("java:/comp/env");
			String url = (String) ct.lookup("productImg");
			p.setFeatureImage(p.getImgs().size() > 0 ? url + p.getImgs().get(0): "");
			Object[] args = { p.getProductName(), p.getUnitPrice(), p.getDescription(), p.getBrand().getBrandId(),
					p.getCategory().getCategoryId(), p.getSale(), p.getFeatureImage() };
			entityId = executor.executeStatement(
					"INSERT INTO public.\"ProductTBL\"(\"ProductName\", \"UnitPrice\", \"Description\", \"BrandID\", \"CategoryID\", \"LastUpdate\", \"Sale\",\"FeatureImage\")\r\n"
							+ "VALUES ( ?, ?, ?, ?, ?, now(), ?, ?);",
					args);
			//insert gender
			for(String gender : genders) {
				executor.executeStatement("INSERT INTO public.\"GenderForProduct\"(\"ProductID\", \"GenderID\") VALUES (?, ?);", entityId, Integer.parseInt(gender));
			}
			
			// insert image
			String sql = "INSERT INTO public.\"ImageTBL\"(\r\n" + "	\"ProductID\", image)\r\n" + "	VALUES (?, ?);";

			for (String img : p.getImgs()) {
				executor.executeStatement(sql, entityId, url + img);
			}

			// insert product detail
			ProductDetailDao detailDao = new ProductDetailDao();

			for (ProductDetail detail : p.getProductDetails()) {
				detail.setProductId(entityId);
				detailDao.insert(detail);
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}

		return entityId;
	}
	
	
	public void stopSelling(int id) {
		
		
	}

}
