package com.model.response_model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NestedAttributeType {
    @JsonProperty("label")
    private String label;
    @JsonProperty("ov")
    private boolean ov;
    @JsonProperty("uri")
    private String uri;
}
