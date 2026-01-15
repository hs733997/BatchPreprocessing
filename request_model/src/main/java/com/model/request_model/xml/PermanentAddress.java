package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"dNo",
		"street",
		"landMark",
		"city",
		"district",
		"state",
		"pinCode"
})
public class PermanentAddress extends CommonExtensionObjType{
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
