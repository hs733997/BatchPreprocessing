package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"contractType",
		"name",
		"code",
		"controlledBy",
		"channel",
		"status",
		"startDate",
		"contractor"
})
public class ContractInfo extends CommonExtensionObjType{
	@XmlElement(name = "ContractType")
	protected String contractType;
	@XmlElement(name = "Name")
	protected String name;
	@XmlElement(name = "Code")
	protected String code;
	@XmlElement(name = "ControlledBy")
	protected String controlledBy;
	@XmlElement(name = "Channel")
	protected String channel;
	@XmlElement(name = "Status")
	protected String status;
	@XmlElement(name = "StartDate")
	protected String startDate;
	@XmlElement(name = "Contractor")
	protected List<Contractor> contractor;

	public List<Contractor> getContractor() {
		return contractor;
	}

	public void setContractor(List<Contractor> contractor) {
		this.contractor = contractor;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getControlledBy() {
		return controlledBy;
	}

	public void setControlledBy(String controlledBy) {
		this.controlledBy = controlledBy;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


}
