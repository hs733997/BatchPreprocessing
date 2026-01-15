package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"owner",
		"contractInfo",
		"contestantDetails",
		"address",
        "characters"
})
public class Contract extends CommonExtensionObjType{
	@XmlElement(name = "Owner")
	protected String owner;
	@XmlElement(name = "ContractInfo")
	protected List<ContractInfo> contractInfo;
	@XmlElement(name = "ContestantDetails")
	protected List<ContestantDetails> contestantDetails;
	@XmlElement(name = "Address")
	protected List<Address> address;
    @XmlElement(name = "Character")
    protected List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<ContractInfo> getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(List<ContractInfo> contractInfo) {
        this.contractInfo = contractInfo;
    }

    public List<ContestantDetails> getContestantDetails() {
        return contestantDetails;
    }

    public void setContestantDetails(List<ContestantDetails> contestantDetails) {
        this.contestantDetails = contestantDetails;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
