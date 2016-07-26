package com.shoppree.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppree.rest.bean.BusinessDetailsBean;

public class BusinessMapper implements RowMapper<BusinessDetailsBean> {
	
	public BusinessDetailsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusinessDetailsBean businessDetailsBean = new BusinessDetailsBean();

		businessDetailsBean.setBusiness_id(rs.getInt("business_id"));
		businessDetailsBean.setBusinessName(rs.getString("businessName"));
		businessDetailsBean.setDetails(rs.getString("details"));
		businessDetailsBean.setPhoneNumber(rs.getString("phoneNumber"));
		businessDetailsBean.setWebsite(rs.getString("website"));
		businessDetailsBean.setBusinessLogo(rs.getString("businessLogo"));
		businessDetailsBean.setDateTimeStamp(rs.getString("dateTimeStamp"));
		businessDetailsBean.setUserId(rs.getInt("userId"));

		return businessDetailsBean;
	}

}
