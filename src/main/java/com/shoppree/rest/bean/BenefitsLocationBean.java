package com.shoppree.rest.bean;

public class BenefitsLocationBean {
	private Integer benefits_loc_id;
	private String address_line;
	private String latitude;
	private String longitude;
	private Integer benefit_id;
	private Integer business_id;
	private String dateTimeStamp;

	public Integer getBenefits_loc_id() {
		return benefits_loc_id;
	}

	public void setBenefits_loc_id(Integer benefits_loc_id) {
		this.benefits_loc_id = benefits_loc_id;
	}

	public String getAddress_line() {
		return address_line;
	}

	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getBenefit_id() {
		return benefit_id;
	}

	public void setBenefit_id(Integer benefit_id) {
		this.benefit_id = benefit_id;
	}

	public Integer getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}

	public String getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(String dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

}
