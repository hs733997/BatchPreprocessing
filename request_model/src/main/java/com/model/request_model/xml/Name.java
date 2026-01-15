package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"title",
		"firstName",
		"middleName",
		"middleName2",
		"middleName3",
		"middleName4",
		"lastName",
		"startDate",
		"endDate",
		"updatedBy",
		"updateDate"
})
public class Name extends CommonExtensionObjType{
	@XmlElement(name = "Title")
	protected String title;
	@XmlElement(name = "FirstName")
	protected String firstName;
	@XmlElement(name = "MiddleName")
	protected String middleName;

	public String getMiddleName2() {
		return middleName2;
	}

	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}

	public String getMiddleName3() {
		return middleName3;
	}

	public void setMiddleName3(String middleName3) {
		this.middleName3 = middleName3;
	}

	public String getMiddleName4() {
		return middleName4;
	}

	public void setMiddleName4(String middleName4) {
		this.middleName4 = middleName4;
	}

	@XmlElement(name = "MiddleName2")
	protected String middleName2;
	@XmlElement(name = "MiddleName3")
	protected String middleName3;
	@XmlElement(name = "MiddleName4")
	protected String middleName4;
	@XmlElement(name = "LastName")
	protected String lastName;
	@XmlElement(name = "StartDate")
	protected String startDate;
	@XmlElement(name = "EndDate")
	protected String endDate;
	@XmlElement(name = "UpdatedBy")
	protected String updatedBy;
	@XmlElement(name = "UpdateDate")
	protected String updateDate;

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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
