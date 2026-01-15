package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"dNo",
		"buildingNo",
		"street",
		"landMark",
		"city",
		"district",
		"state",
		"pinCode",
		"country",
		"updatedBy",
		"updatedDate",
		"verificationStatus"
})
public class CurrentAddress extends CommonExtensionObjType{
	@XmlElement(name = "DNo")
	protected String dNo;
	@XmlElement(name = "Street")
	protected String street;
	@XmlElement(name = "LandMark")
	protected String landMark;
	@XmlElement(name = "City")
	protected String city;
	@XmlElement(name = "District")
	protected String district;
	@XmlElement(name = "State")
	protected String state;
	@XmlElement(name = "PinCode")
	protected String pinCode;
	@XmlElement(name = "Country")
	protected String country;
	@XmlElement(name = "UpdatedBy")
	protected String updatedBy;
	@XmlElement(name = "UpdatedDate")
	protected String updatedDate;
	@XmlElement(name = "VerificationStatus")
	protected String verificationStatus;
	@XmlElement(name = "BuildingNo")
	protected String buildingNo;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
