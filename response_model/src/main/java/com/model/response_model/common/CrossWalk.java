package com.model.response_model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossWalk {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("updatedDate")
    private String updatedDate;
    @JsonProperty("attributes")
    private List<String> attributes;
}
