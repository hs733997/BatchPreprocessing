package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import com.model.response_model.entity.IndividualEntity;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndividualNameAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private IndividualName value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IndividualName {

        @JsonProperty("FirstName")
        private List<SimpleAttributeType> firstName;
        @JsonProperty("LastName")
        private List<SimpleAttributeType> lastName;
        @JsonProperty("MiddleName")
        private List<MiddleNameAttribute> middleName;
        @JsonProperty("Initial")
        private List<SimpleAttributeType> initial;
        @JsonProperty("StartDate")
        private List<SimpleAttributeType> startDate;
        @JsonProperty("EndDate")
        private List<SimpleAttributeType> endDate;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
        @JsonProperty("Title")
        private List<SimpleAttributeType> title;
    }
}
