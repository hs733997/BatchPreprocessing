package com.model.request_model.xml;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"info",
		"details"
})
public class Root extends CommonExtensionObjType{

	@XmlElement(name = "Info")
	protected Info info;
	@XmlElement(name = "Details")
	protected Details details;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}
}
