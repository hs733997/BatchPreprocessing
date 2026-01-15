package com.model.response_model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.SimpleAttributeType;
import com.model.response_model.entity.individual.*;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndividualEntity extends Entity{

    @JsonProperty("attributes")
    private Attributes attributes;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Attributes {
        @JsonProperty("CustomerId")
        private List<SimpleAttributeType> customerId;
        @JsonProperty("UserId")
        private List<SimpleAttributeType> userId;
        @JsonProperty("Brand")
        private List<SimpleAttributeType> brand;
        @JsonProperty("DeceasedNotificationDate")
        private List<SimpleAttributeType> deceasedNotificationDate;
        @JsonProperty("BirthGender")
        private List<SimpleAttributeType> birthGender;
        @JsonProperty("Email")
        private List<EmailAttribute> email;
        @JsonProperty("Introducer")
        private List<SimpleAttributeType> introducer;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("IndividualName")
        private List<IndividualNameAttribute> individualName;
        @JsonProperty("Name")
        private List<SimpleAttributeType> name;
        @JsonProperty("DeceasedConfirmationDate")
        private List<SimpleAttributeType> deceasedConfirmationDate;
        @JsonProperty("Oan")
        private List<SimpleAttributeType> oan;
        @JsonProperty("NationalIdentifiers")
        private List<NationalIdentifiersAttribute> nationalIdentifiers;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
        @JsonProperty("Addresses")
        private List<AddressReference> address;
        @JsonProperty("BirthDate")
        private List<SimpleAttributeType> birthDate;
        @JsonProperty("Nationality")
        private List<SimpleAttributeType> nationality;
        @JsonProperty("Phone")
        private List<PhoneAttribute> phone;
        @JsonProperty("DeceasedDate")
        private List<SimpleAttributeType> deceasedDate;
        @JsonProperty("MaritalStatus")
        private List<SimpleAttributeType> maritalStatus;
    }
}
