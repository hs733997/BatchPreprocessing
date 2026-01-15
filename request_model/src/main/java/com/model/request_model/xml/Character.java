package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"characterType",
		"contestantDetails",
		"address"
})
public class Character extends CommonExtensionObjType{
	@XmlElement(name = "CharacterType")
	protected String characterType;
	@XmlElement(name = "ContestantDetails")
	protected ContestantDetails contestantDetails;
	@XmlElement(name = "Address")
	protected Address address;

	public String getCharacterType() {
		return characterType;
	}

	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}

	public ContestantDetails getContestantDetails() {
		return contestantDetails;
	}

	public void setContestantDetails(ContestantDetails contestantDetails) {
		this.contestantDetails = contestantDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
