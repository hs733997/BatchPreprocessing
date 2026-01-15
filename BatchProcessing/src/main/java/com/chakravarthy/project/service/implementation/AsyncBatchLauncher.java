package com.chakravarthy.project.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class AsyncBatchLauncher {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncBatchLauncher.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Async
    public void startJob(Job job, JobParameters jobParameters) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        LOGGER.debug("Job with name {} started with thread name {}",job.getName(),Thread.currentThread().getName());
        JobExecution jobExecution = null;
        jobExecution = jobLauncher.run(job,jobParameters);
        LOGGER.debug("Job Status is {}",jobExecution.getStatus());
    }
}
