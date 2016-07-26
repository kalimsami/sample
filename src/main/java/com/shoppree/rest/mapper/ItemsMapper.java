package com.shoppree.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppree.rest.bean.ItemsBean;

public class ItemsMapper implements RowMapper<ItemsBean> {
	
	public ItemsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemsBean itemsBean = new ItemsBean();

		itemsBean.setNo_of_purchases(rs.getString("no_of_purchases"));
		itemsBean.setProduct_id(rs.getString("product_id"));
		itemsBean.setRed_product_id(rs.getString("red_product_id"));
		
		return itemsBean;
	}
}
