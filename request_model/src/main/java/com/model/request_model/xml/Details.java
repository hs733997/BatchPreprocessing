package com.model.request_model.xml;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"contract"
})
public class Details extends CommonExtensionObjType{
	@XmlElement(name ="Contract")
	protected List<Contract> contract;
	@XmlAttribute(name ="Information")
	protected String information;

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
