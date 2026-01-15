package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZipAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private Zip value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Zip {

        @JsonProperty("ZipCode")
        private List<SimpleAttributeType> zipCode;
        @JsonProperty("PostalCode")
        private List<SimpleAttributeType> postalCode;
    }
}
