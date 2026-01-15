package com.model.response_model.entity.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.response_model.common.NestedAttributeType;
import com.model.response_model.common.SimpleAttributeType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NationalIdentifiersAttribute extends NestedAttributeType {

    @JsonProperty("value")
    private NationalIdentifier value;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NationalIdentifier {
        @JsonProperty("Type")
        private List<SimpleAttributeType> type;
        @JsonProperty("Value")
        private List<SimpleAttributeType> value;
        @JsonProperty("StartDate")
        private List<SimpleAttributeType> startDate;
        @JsonProperty("EndDate")
        private List<SimpleAttributeType> endDate;
        @JsonProperty("UpdatedDate")
        private List<SimpleAttributeType> updatedDate;
        @JsonProperty("UpdatedBy")
        private List<SimpleAttributeType> updatedBy;
    }
}
