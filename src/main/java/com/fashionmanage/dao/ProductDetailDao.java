package com.fashionmanage.dao;

import com.fashionmanage.entity.ProductDetail;

public class ProductDetailDao {
	
	private QueryExecutor executor = QueryExecutor.getInstance();
	
	
	
	public int insert(ProductDetail pd) {
		int entityId = -1;
		String sql = "INSERT INTO public.\"ProductDetailTBL\"(\r\n" + 
				" \"ProductID\", \"Size\", \"Color\", \"Quantity\")\r\n" + 
				"	VALUES (?, ?, ?, ?);";
		Object[] args = {pd.getProductId(), pd.getSize(), pd.getColor(), pd.getQuantity()};
		entityId = executor.executeStatement(sql, args);
		return entityId;
	}
}
