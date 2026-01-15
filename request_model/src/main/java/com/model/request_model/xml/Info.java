package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {
		"type",
		"version",
		"source",
		"sourceId",
		"sourceDateTimeStamp"
})
public class Info extends CommonExtensionObjType{
	@XmlElement(name = "Type")
	protected String type;
	@XmlElement(name = "Version")
	protected String version;
	@XmlElement(name = "Source")
	protected String source;
	@XmlElement(name = "SourceId")
	protected String sourceId;
	@XmlElement(name = "SourceDateTimeStamp")
	protected String sourceDateTimeStamp;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceDateTimeStamp() {
		return sourceDateTimeStamp;
	}

	public void setSourceDateTimeStamp(String sourceDateTimeStamp) {
		this.sourceDateTimeStamp = sourceDateTimeStamp;
	}
}
