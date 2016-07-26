package com.shoppree.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppree.rest.bean.CategoryBean;

public class CategoryMapper implements RowMapper<CategoryBean> {
	
	public CategoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryBean categoryBean = new CategoryBean();

		categoryBean.setCategory_type(rs.getString("category_type"));
		categoryBean.setCategory_name(rs.getString("category_name"));

		return categoryBean;
	}

}
