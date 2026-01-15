package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"type",
		"startDate",
		"endDate",
		"phoneDetails"
})
public class Phone extends CommonExtensionObjType{
	@XmlElement(name = "Type")
	protected String type;
	@XmlElement(name = "StartDate")
	protected String startDate;
	@XmlElement(name = "EndDate")
	protected String endDate;
	@XmlElement(name = "PhoneDetails")
	protected PhoneDetails phoneDetails;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public PhoneDetails getPhoneDetails() {
		return phoneDetails;
	}

	public void setPhoneDetails(PhoneDetails phoneDetails) {
		this.phoneDetails = phoneDetails;
	}
}
