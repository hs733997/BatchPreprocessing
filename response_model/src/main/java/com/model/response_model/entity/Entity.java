package com.model.response_model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.model.response_model.common.CrossWalk;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = IndividualEntity.class, name = "configuration/entityTypes/Individual")
})
public class Entity {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("type")
    private String type;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdTime")
    private String createdTime;
    @JsonProperty("updatedTime")
    private String updatedTime;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("crosswalk")
    private List<CrossWalk> crosswalk;
    @JsonProperty("label")
    private String label;
}
