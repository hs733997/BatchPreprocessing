package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressReference extends NestedAttributeType {

    @JsonProperty("value")
    private Address value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Address {
        @JsonProperty("AddressType")
        private List<SimpleAttributeType> addressType;
        @JsonProperty("AddressLine1")
        private List<SimpleAttributeType> addressLine1;
        @JsonProperty("AddressLine2")
        private List<SimpleAttributeType> addressLine2;
        @JsonProperty("AddressLine3")
        private List<SimpleAttributeType> addressLine3;
        @JsonProperty("AddressLine4")
        private List<SimpleAttributeType> addressLine4;
        @JsonProperty("AddressLine5")
        private List<SimpleAttributeType> addressLine5;
        @JsonProperty("AddressLine6")
        private List<SimpleAttributeType> addressLine6;
        @JsonProperty("City")
        private List<SimpleAttributeType> city;
        @JsonProperty("State")
        private List<SimpleAttributeType> state;
        @JsonProperty("Country")
        private List<SimpleAttributeType> country;
        @JsonProperty("Zip")
        private List<ZipAttribute> zip;
        @JsonProperty("VarificationStatus")
        private List<SimpleAttributeType> varificationStatus;
        @JsonProperty("Street")
        private List<SimpleAttributeType> street;
        @JsonProperty("BuildingNumber")
        private List<SimpleAttributeType> buildingNumber;
        @JsonProperty("Landmark")
        private List<SimpleAttributeType> landmark;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
    }
}
