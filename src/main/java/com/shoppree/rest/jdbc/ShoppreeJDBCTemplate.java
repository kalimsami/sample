package com.shoppree.rest.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shoppree.rest.bean.BenefitsDetailsBean;
import com.shoppree.rest.bean.BenefitsLocationBean;
import com.shoppree.rest.bean.BusinessDetailsBean;
import com.shoppree.rest.bean.CategoryBean;
import com.shoppree.rest.bean.ItemsBean;
import com.shoppree.rest.bean.PointsBean;
import com.shoppree.rest.mapper.BusinessMapper;
import com.shoppree.rest.mapper.CategoryMapper;
import com.shoppree.rest.mapper.ItemsMapper;
import com.shoppree.rest.mapper.PointsMapper;

public class ShoppreeJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	//Using Feature of RowMapper by creating Bean dynamically
	public List<BusinessDetailsBean> getAllCompanies() {

		String SQL = "SELECT * FROM business_details";
		List<BusinessDetailsBean> companyList = jdbcTemplateObject.query(SQL, new BusinessMapper());
		return companyList;
		
	}

	//Using Feature of RowMapper by creating Bean dynamically
	public List<BusinessDetailsBean> getCompanyListByUserId(int userid) {

		String SQL = "SELECT * FROM business_details WHERE userId = ?";
		List<BusinessDetailsBean> companyList = jdbcTemplateObject.query(SQL, new Object[] { userid }, new BusinessMapper());
		return companyList;

	}

	
	//Using Feature of RowMapper by creating Bean manually
	public List<BenefitsDetailsBean> getAllBenefits() {

		String SQL = "SELECT c.business_id AS cbusiness_id, c.businessName AS businessName, " +
				     "b.business_id AS bbusiness_id, b.benefit_id, b.benefit_desc AS benefitDesc, b.category AS category " +
				     "FROM " +
				     "business_details c, benefits_desc b " + 
				     "WHERE " +
				     "c.business_id = b.business_id " +			   
				     "ORDER BY c.business_id;";
		
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(SQL);
		
		List<BenefitsDetailsBean> benefitsDetailsBeanList = new ArrayList<BenefitsDetailsBean>();		
		
		for (Map row : rows) {
			BenefitsDetailsBean benefitsDetailsBean = new BenefitsDetailsBean();
			
			benefitsDetailsBean.setBenefit_id(Integer.parseInt(row.get("benefit_id").toString()));
			benefitsDetailsBean.setBusinessName((String)row.get("businessName"));
			benefitsDetailsBean.setBenefitDesc((String)row.get("benefitDesc"));
			benefitsDetailsBean.setCategory((String)row.get("category"));
			benefitsDetailsBean.setBbusiness_id(Integer.parseInt(row.get("bbusiness_id").toString()));
			benefitsDetailsBean.setCbusiness_id(Integer.parseInt(row.get("cbusiness_id").toString()));
			
			
			SQL = "SELECT benefits_loc_id, address_line, latitude, longitude, benefit_id, business_id, dateTimeStamp "+
				  "FROM benefits_loc WHERE benefit_id = ?;"; 
			List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { benefitsDetailsBean.getBenefit_id() });
			
			List<BenefitsLocationBean> benefitsLocationBeanList = new ArrayList<BenefitsLocationBean>();
			for (Map l_row : loc_rows) {
				BenefitsLocationBean benefitsLocationBean = new BenefitsLocationBean();
				
				benefitsLocationBean.setBenefits_loc_id(Integer.parseInt(l_row.get("benefits_loc_id").toString()));
				benefitsLocationBean.setAddress_line((String)l_row.get("address_line"));
				benefitsLocationBean.setLatitude((String)l_row.get("latitude"));
				benefitsLocationBean.setLongitude((String)l_row.get("longitude"));
				benefitsLocationBean.setBenefit_id(Integer.parseInt(l_row.get("benefit_id").toString()));
				benefitsLocationBean.setBusiness_id(Integer.parseInt(l_row.get("business_id").toString()));
				benefitsLocationBean.setDateTimeStamp(l_row.get("dateTimeStamp").toString());
				benefitsLocationBeanList.add(benefitsLocationBean);
			}
			benefitsDetailsBean.setLocationList(benefitsLocationBeanList);
			
			benefitsDetailsBeanList.add(benefitsDetailsBean);
	    }
		
		return benefitsDetailsBeanList;
	}

	//Using Feature of RowMapper by creating Bean manually
	public List<BenefitsDetailsBean> getBenefitsListByUserId(int userid) {

		String SQL = "SELECT c.business_id AS cbusiness_id, c.businessName AS businessName, c.businessLogo AS logo, c.website, c.phoneNumber, " +
			     	 "b.business_id AS bbusiness_id, b.benefit_id, b.benefit_desc AS benefitDesc, b.category AS category " +
			         "FROM " +
			         "business_details c, benefits_desc b " + 
			         "WHERE " +
				     "c.business_id = b.business_id " +
				     "AND " +
				     "c.userId = ?  ORDER BY c.business_id;";
		
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(SQL, new Object[] { userid });
		
		List<BenefitsDetailsBean> benefitsDetailsBeanList = new ArrayList<BenefitsDetailsBean>();		
		
		for (Map row : rows) {
			BenefitsDetailsBean benefitsDetailsBean = new BenefitsDetailsBean();
			
			benefitsDetailsBean.setBenefit_id(Integer.parseInt(row.get("benefit_id").toString()));
			benefitsDetailsBean.setBusinessName((String)row.get("businessName"));
			benefitsDetailsBean.setBusinessLogo((String)row.get("logo"));
			benefitsDetailsBean.setWebsite((String)row.get("website"));
			benefitsDetailsBean.setPhoneNumber((String)row.get("phoneNumber"));
			benefitsDetailsBean.setBenefitDesc((String)row.get("benefitDesc"));
			benefitsDetailsBean.setCategory((String)row.get("category"));
			benefitsDetailsBean.setBbusiness_id(Integer.parseInt(row.get("bbusiness_id").toString()));
			benefitsDetailsBean.setCbusiness_id(Integer.parseInt(row.get("cbusiness_id").toString()));
			
			
			SQL = "SELECT benefits_loc_id, address_line, latitude, longitude, benefit_id, business_id, dateTimeStamp "+
				  "FROM benefits_loc WHERE benefit_id = ?;"; 
			List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { benefitsDetailsBean.getBenefit_id() });
			
			List<BenefitsLocationBean> benefitsLocationBeanList = new ArrayList<BenefitsLocationBean>();
			for (Map l_row : loc_rows) {
				BenefitsLocationBean benefitsLocationBean = new BenefitsLocationBean();
				
				benefitsLocationBean.setBenefits_loc_id(Integer.parseInt(l_row.get("benefits_loc_id").toString()));
				benefitsLocationBean.setAddress_line((String)l_row.get("address_line"));
				benefitsLocationBean.setLatitude((String)l_row.get("latitude"));
				benefitsLocationBean.setLongitude((String)l_row.get("longitude"));
				benefitsLocationBean.setBenefit_id(Integer.parseInt(l_row.get("benefit_id").toString()));
				benefitsLocationBean.setBusiness_id(Integer.parseInt(l_row.get("business_id").toString()));
				benefitsLocationBean.setDateTimeStamp(l_row.get("dateTimeStamp").toString());
				benefitsLocationBeanList.add(benefitsLocationBean);
			}
			benefitsDetailsBean.setLocationList(benefitsLocationBeanList);
			
			benefitsDetailsBeanList.add(benefitsDetailsBean);
	    }
		
		return benefitsDetailsBeanList;

	}
	
	//Using Feature of RowMapper by creating Bean manually. Used for Widget
	public List<BenefitsDetailsBean> getBenefitsListByBenefitId(int benefit_id) {

		String SQL = "SELECT c.business_id AS cbusiness_id, c.businessName AS businessName, " +
			     	 "b.business_id AS bbusiness_id, b.benefit_id, b.benefit_desc AS benefitDesc, b.category AS category " +
			         "FROM " +
			         "business_details c, benefits_desc b " + 
			         "WHERE " +
				     "c.business_id = b.business_id " +
				     "AND " +
				     "b.benefit_id = ?  ORDER BY c.business_id;";
		
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(SQL, new Object[] { benefit_id });
		
		List<BenefitsDetailsBean> benefitsDetailsBeanList = new ArrayList<BenefitsDetailsBean>();		
		
		for (Map row : rows) {
			BenefitsDetailsBean benefitsDetailsBean = new BenefitsDetailsBean();
			
			benefitsDetailsBean.setBenefit_id(Integer.parseInt(row.get("benefit_id").toString()));
			benefitsDetailsBean.setBusinessName((String)row.get("businessName"));
			benefitsDetailsBean.setBenefitDesc((String)row.get("benefitDesc"));
			benefitsDetailsBean.setCategory((String)row.get("category"));
			benefitsDetailsBean.setBbusiness_id(Integer.parseInt(row.get("bbusiness_id").toString()));
			benefitsDetailsBean.setCbusiness_id(Integer.parseInt(row.get("cbusiness_id").toString()));
			
			
			SQL = "SELECT benefits_loc_id, address_line, latitude, longitude, benefit_id, business_id, dateTimeStamp "+
				  "FROM benefits_loc WHERE benefit_id = ?;"; 
			List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { benefitsDetailsBean.getBenefit_id() });
			
			List<BenefitsLocationBean> benefitsLocationBeanList = new ArrayList<BenefitsLocationBean>();
			for (Map l_row : loc_rows) {
				BenefitsLocationBean benefitsLocationBean = new BenefitsLocationBean();
				
				benefitsLocationBean.setBenefits_loc_id(Integer.parseInt(l_row.get("benefits_loc_id").toString()));
				benefitsLocationBean.setAddress_line((String)l_row.get("address_line"));
				benefitsLocationBean.setLatitude((String)l_row.get("latitude"));
				benefitsLocationBean.setLongitude((String)l_row.get("longitude"));
				benefitsLocationBean.setBenefit_id(Integer.parseInt(l_row.get("benefit_id").toString()));
				benefitsLocationBean.setBusiness_id(Integer.parseInt(l_row.get("business_id").toString()));
				benefitsLocationBean.setDateTimeStamp(l_row.get("dateTimeStamp").toString());
				benefitsLocationBeanList.add(benefitsLocationBean);
			}
			benefitsDetailsBean.setLocationList(benefitsLocationBeanList);
			
			benefitsDetailsBeanList.add(benefitsDetailsBean);
	    }
		
		return benefitsDetailsBeanList;

	}
	
	public List<CategoryBean> getAllCategories() {

		String SQL = "SELECT category_type, category_name FROM category";
		List<CategoryBean> categoryList = jdbcTemplateObject.query(SQL, new CategoryMapper());
		return categoryList;
		
	}
	
	public List<BenefitsLocationBean> getAllLocationsByUser(int userid) {
		
		String SQL = "SELECT address_line, latitude, longitude FROM benefits_loc WHERE userId = ?";
		List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { userid });
		
		List<BenefitsLocationBean> benefitsLocationBeanList = new ArrayList<BenefitsLocationBean>();
		for (Map l_row : loc_rows) {
			BenefitsLocationBean benefitsLocationBean = new BenefitsLocationBean();
			
			benefitsLocationBean.setAddress_line((String)l_row.get("address_line"));
			benefitsLocationBean.setLatitude((String)l_row.get("latitude"));
			benefitsLocationBean.setLongitude((String)l_row.get("longitude"));
			benefitsLocationBeanList.add(benefitsLocationBean);
		}
		
		return benefitsLocationBeanList;
		
	}
	
	public List<BenefitsLocationBean> getAllLocationsByBusiness(int business_id) {
		
		String SQL = "SELECT address_line, latitude, longitude FROM benefits_loc WHERE business_id = ?";
		List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { business_id });
		
		List<BenefitsLocationBean> benefitsLocationBeanList = new ArrayList<BenefitsLocationBean>();
		for (Map l_row : loc_rows) {
			BenefitsLocationBean benefitsLocationBean = new BenefitsLocationBean();
			
			benefitsLocationBean.setAddress_line((String)l_row.get("address_line"));
			benefitsLocationBean.setLatitude((String)l_row.get("latitude"));
			benefitsLocationBean.setLongitude((String)l_row.get("longitude"));
			benefitsLocationBeanList.add(benefitsLocationBean);
		}
		
		return benefitsLocationBeanList;
		
	}

	public List<String> getAllLogoByUser(int userid) {
		
		String SQL = "SELECT businessLogo FROM business_details WHERE userId = ?";
		List<Map<String, Object>> loc_rows = jdbcTemplateObject.queryForList(SQL, new Object[] { userid });
		
		List<String> logoList = new ArrayList<String>();
		for (Map l_row : loc_rows) {
			String logo = (String)l_row.get("businessLogo");
			logoList.add(logo);
		}
		
		return logoList;
		
	}

	
	public List<PointsBean> getPointsByCartAmount(String cartAmount) {
		
		String SQL = "SELECT * FROM loyality_card_points WHERE currency_count = ? ";
		List<PointsBean> pointsList = jdbcTemplateObject.query(SQL, new Object[] { cartAmount }, new PointsMapper());
		return pointsList;
	}

	public List<ItemsBean> getItemsByPurchases(String noOfPurchases) {
		
		String SQL = "SELECT * FROM loyality_card_items WHERE no_of_purchases = ? ";
		List<ItemsBean> itemList = jdbcTemplateObject.query(SQL, new Object[] { noOfPurchases }, new ItemsMapper());
		return itemList;
		
	}
}
