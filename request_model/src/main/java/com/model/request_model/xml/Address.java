package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"addressId",
		"permanentAddress",
		"currentAddress"
})
public class Address extends CommonExtensionObjType{
	@XmlElement(name = "AddressId")
	protected String addressId;
	@XmlElement(name = "PermanentAddress")
	protected PermanentAddress permanentAddress;
	@XmlElement(name = "CurrentAddress")
	protected CurrentAddress currentAddress;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public PermanentAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(PermanentAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public CurrentAddress getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(CurrentAddress currentAddress) {
		this.currentAddress = currentAddress;
	}
}
