package com.fashionmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionmanage.entity.Product;
import com.fashionmanage.entity.ProductDetail;

public class ProductDao {

	private QueryExecutor executor = QueryExecutor.getInstance();

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement pr = conn.prepareStatement("select * from public.\"ProductTBL\"");

			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setUnitPrice(rs.getInt(3));
				p.setDescription(rs.getString(4));
				products.add(p);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public int insert(Product p) {
		int entityId = -1;
		Object[] args = { p.getProductName(), p.getUnitPrice(), p.getDescription(), p.getBrand().getBrandId(),
				p.getCategory().getCategoryId(), p.getSale() };
		entityId = executor.executeStatement(
				"INSERT INTO public.\"ProductTBL\"(\"ProductName\", \"UnitPrice\", \"Description\", \"BrandID\", \"CategoryID\", \"LastUpdate\", \"Sale\")\r\n"
						+ "VALUES ( ?, ?, ?, ?, ?, now(), ?);",
				args);
		// insert image
		String sql = "INSERT INTO public.\"ImageTBL\"(\r\n" + "	\"ProductID\", image)\r\n" + "	VALUES (?, ?);";
		for (String img : p.getImgs()) {
			executor.executeStatement(sql, entityId, img);
		}
		
		// insert product detail
		ProductDetailDao detailDao = new ProductDetailDao();
		
		for(ProductDetail detail : p.getProductDetails()) {
			detail.setProductId(entityId);
			detailDao.insert(detail);
		}
		
		return entityId;
	}
	
	
}
