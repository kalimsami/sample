package com.shoppree.rest.bean;

import java.util.List;

public class BenefitsDetailsBean {
	private Integer cbusiness_id;
	private String businessName;
	private String businessLogo;
	private String website;
	private String phoneNumber;
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String benefitDesc;
	private Integer bbusiness_id;
	private Integer benefit_id;
	private String category;
	private List<BenefitsLocationBean> locationList;

	public Integer getCbusiness_id() {
		return cbusiness_id;
	}

	public void setCbusiness_id(Integer cbusiness_id) {
		this.cbusiness_id = cbusiness_id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBenefitDesc() {
		return benefitDesc;
	}

	public void setBenefitDesc(String benefitDesc) {
		this.benefitDesc = benefitDesc;
	}

	public Integer getBbusiness_id() {
		return bbusiness_id;
	}

	public void setBbusiness_id(Integer bbusiness_id) {
		this.bbusiness_id = bbusiness_id;
	}

	public Integer getBenefit_id() {
		return benefit_id;
	}

	public void setBenefit_id(Integer benefit_id) {
		this.benefit_id = benefit_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<BenefitsLocationBean> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<BenefitsLocationBean> locationList) {
		this.locationList = locationList;
	}

	public String getBusinessLogo() {
		return businessLogo;
	}

	public void setBusinessLogo(String businessLogo) {
		this.businessLogo = businessLogo;
	}

}
