package com.model.response_model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleAttributeType {
    @JsonProperty("type")
    private String type;
    @JsonProperty("ov")
    private boolean ov;
    @JsonProperty("value")
    private String value;
    @JsonProperty("lookupError")
    private String lookupError;
    @JsonProperty("lookupCode")
    private String lookupCode;
    @JsonProperty("uri")
    private String uri;
}
