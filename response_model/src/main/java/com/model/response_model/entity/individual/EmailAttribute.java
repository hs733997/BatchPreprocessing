package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private Email value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Email {
        @JsonProperty("Type")
        private List<SimpleAttributeType> type;
        @JsonProperty("Usage")
        private List<SimpleAttributeType> usage;
        @JsonProperty("StartDate")
        private List<SimpleAttributeType> startDate;
        @JsonProperty("EndDate")
        private List<SimpleAttributeType> endDate;
        @JsonProperty("EmailAddress")
        private List<SimpleAttributeType> emailAddress;
        @JsonProperty("Preferred")
        private List<SimpleAttributeType> preferred;
        @JsonProperty("Username")
        private List<SimpleAttributeType> username;
        @JsonProperty("Status")
        private List<SimpleAttributeType> status;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
    }
}
