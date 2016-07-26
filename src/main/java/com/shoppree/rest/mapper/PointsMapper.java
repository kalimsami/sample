package com.shoppree.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppree.rest.bean.PointsBean;

public class PointsMapper implements RowMapper<PointsBean> {
	
	public PointsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		PointsBean pointsBean = new PointsBean();

		pointsBean.setCurrency(rs.getString("currency"));
		pointsBean.setPoints_count(rs.getString("points_count"));
		pointsBean.setCurrency_count(rs.getString("currency_count"));
		pointsBean.setRed_currency(rs.getString("red_currency"));
		pointsBean.setRed_money_value(rs.getString("red_money_value"));
		pointsBean.setRed_points(rs.getString("red_points"));
		
		return pointsBean;
	}

}
