package com.fashionmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionmanage.entity.Category;

public class CategoryDao {
	private QueryExecutor executor = QueryExecutor.getInstance();

//	public int createCategory(Category category) {
//		int entityId = 0;
//		Object[] args = { category.getCategoryName() };
//		entityId = executor.executeStatement("insert into category name values(?)", args);
//		return entityId;
//	}
//
//	public void deleteCategory(Category entity) {
//		executor.executeStatement("remove from category where id=?", entity.getCategoryId());
//	}
//
//	public int editCategory(Category category) {
//		int entityId = 0;
//		Object[] args = { category.getCategoryName() };
//		entityId = executor.executeStatement("update category set name=?", args);
//		return entityId;
//	}

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		Category category = null;
		try {
			ResultSet rs = executor.getResultSet("select * from public.\"CategoryTBL\"");
			while (rs.next()) {
				category = createEntity(rs);
				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	/**
	 * Creates entity from result set
	 * 
	 * @param rs
	 * @return entity
	 */
	private Category createEntity(ResultSet rs) {
		Category category = new Category();
		try {
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
		} catch (SQLException e) {
			// LOGGER.error("SQL exception1 " + e.getMessage());
			e.printStackTrace();
		}
		return category;
	}

}
