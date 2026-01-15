package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"countryCode",
		"telePhoneCode",
		"number",
		"areaCode",
		"updatedDate",
		"updatedBy",
		"status",
		"verificationStatus"
})
public class PhoneDetails extends CommonExtensionObjType{
	@XmlElement(name = "CountryCode")
	protected String countryCode;
	@XmlElement(name = "TelePhoneCode")
	protected String telePhoneCode;
	@XmlElement(name = "Number")
	protected String number;
	@XmlElement(name = "AreaCode")
	protected String areaCode;
	@XmlElement(name = "UpdatedDate")
	protected String updatedDate;
	@XmlElement(name = "UpdatedBy")
	protected String updatedBy;
	@XmlElement(name = "Status")
	protected String status;
	@XmlElement(name = "VerificationStatus")
	protected String verificationStatus;

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTelePhoneCode() {
		return telePhoneCode;
	}

	public void setTelePhoneCode(String telePhoneCode) {
		this.telePhoneCode = telePhoneCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
