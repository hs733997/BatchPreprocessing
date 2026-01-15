package com.chakravarthy.project.service;

import com.chakravarthy.project.rest.request.BatchRequest;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.io.IOException;

public interface FilePreProcessing {

    public String executeBatch(BatchRequest batchRequest) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, IOException;
}
