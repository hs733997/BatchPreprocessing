package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"id",
		"sourceContestantId",
		"email",
		"phone",
		"contestant"
})
public class ContestantDetails extends CommonExtensionObjType{
	@XmlElement(name = "Id")
	protected String id;
	@XmlElement(name = "SourceContestantId")
	protected String sourceContestantId;
	@XmlElement(name = "Email")
	protected String email;
	@XmlElement(name = "Phone")
	protected List<Phone> phone;
	@XmlElement(name = "Contestant")
	protected List<Contestant> contestant;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceContestantId() {
		return sourceContestantId;
	}

	public void setSourceContestantId(String sourceContestantId) {
		this.sourceContestantId = sourceContestantId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public List<Contestant> getContestant() {
		return contestant;
	}

	public void setContestant(List<Contestant> contestant) {
		this.contestant = contestant;
	}
}
