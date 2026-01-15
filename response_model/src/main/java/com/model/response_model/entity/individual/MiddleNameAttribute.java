package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MiddleNameAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private MiddleName value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MiddleName {
        @JsonProperty("GivenName1")
        private List<SimpleAttributeType> givenName1;
        @JsonProperty("GivenName2")
        private List<SimpleAttributeType> givenName2;
        @JsonProperty("GivenName3")
        private List<SimpleAttributeType> givenName3;
        @JsonProperty("GivenName4")
        private List<SimpleAttributeType> givenName4;
    }
}
