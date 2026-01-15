package com.model.response_model.batch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.model.response_model.entity.IndividualEntity;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestJsonEntity {

    private String type;
    private String version;
    private String source;
    private String sourceId;
    private String sourceDateTimeStamp;

    private List<IndividualEntity> individualEntityList;
}
