package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"name",
		"age",
		"dateOfBirth",
		"maritalStatus",
		"gender",
		"nationality",
		"hobbies",
		"profession",
		"customerId",
		"introducer",
		"brand",
		"oan",
		"updatedDate",
		"updatedBy",
		"userId",
		"deceasedDate",
		"deceasedConfirmationDate",
		"deceasedNotificationDate"
})
public class Contestant extends CommonExtensionObjType{
	@XmlElement(name = "Name")
	protected Name name;
	@XmlElement(name = "Age")
	protected String age;
	@XmlElement(name = "DateOfBirth")
	protected String dateOfBirth;
	@XmlElement(name = "MaritalStatus")
	protected String maritalStatus;
	@XmlElement(name = "Gender")
	protected String gender;
	@XmlElement(name = "Nationality")
	protected String nationality;
	@XmlElement(name = "Hobbies")
	protected String hobbies;
	@XmlElement(name = "Profession")
	protected String profession;
	@XmlElement(name = "CustomerId")
	protected String customerId;
	@XmlElement(name = "Introducer")
	protected String introducer;
	@XmlElement(name = "Brand")
	protected String brand;
	@XmlElement(name = "Oan")
	protected String oan;
	@XmlElement(name = "UpdatedDate")
	protected String updatedDate;
	@XmlElement(name = "UpdatedBy")
	protected String updatedBy;
	@XmlElement(name = "UserId")
	protected String userId;
	@XmlElement(name = "DeceasedDate")
	protected String deceasedDate;
	@XmlElement(name = "DeceasedConfirmationDate")
	protected String deceasedConfirmationDate;
	@XmlElement(name = "DeceasedNotificationDate")
	protected String deceasedNotificationDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOan() {
		return oan;
	}

	public void setOan(String oan) {
		this.oan = oan;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeceasedDate() {
		return deceasedDate;
	}

	public void setDeceasedDate(String deceasedDate) {
		this.deceasedDate = deceasedDate;
	}

	public String getDeceasedConfirmationDate() {
		return deceasedConfirmationDate;
	}

	public void setDeceasedConfirmationDate(String deceasedConfirmationDate) {
		this.deceasedConfirmationDate = deceasedConfirmationDate;
	}

	public String getDeceasedNotificationDate() {
		return deceasedNotificationDate;
	}

	public void setDeceasedNotificationDate(String deceasedNotificationDate) {
		this.deceasedNotificationDate = deceasedNotificationDate;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
}
