package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private Phone value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Phone {
        @JsonProperty("Type")
        private List<SimpleAttributeType> type;
        @JsonProperty("Usage")
        private List<SimpleAttributeType> usage;
        @JsonProperty("StartDate")
        private List<SimpleAttributeType> startDate;
        @JsonProperty("EndDate")
        private List<SimpleAttributeType> endDate;
        @JsonProperty("CountryCode")
        private List<SimpleAttributeType> countryCode;
        @JsonProperty("AreaCode")
        private List<SimpleAttributeType> areaCode;
        @JsonProperty("Number")
        private List<SimpleAttributeType> number;
        @JsonProperty("Status")
        private List<SimpleAttributeType> status;
        @JsonProperty("ValidationStatus")
        private List<SimpleAttributeType> validationStatus;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
    }
}
