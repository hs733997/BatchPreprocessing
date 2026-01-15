package com.chakravarthy.project.rest.controller;

import com.chakravarthy.project.rest.request.BatchRequest;
import com.chakravarthy.project.service.FilePreProcessing;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/preprocess")
public class PreProcessController {

    @Autowired
    private Job xmlToJsonConvertor;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    public FilePreProcessing filePreProcessing;

    @PostMapping("/start/job")
    public ResponseEntity<String> JobStart(@RequestBody BatchRequest request) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, IOException {
        filePreProcessing.executeBatch(request);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("success");
    }
//    @GetMapping("/start/job")
//    public ResponseEntity<String> startJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        JobParameters jobParameter = new JobParameters();
//        jobLauncher.run(xmlToJsonConvertor,jobParameter);
//        return ResponseEntity.ok("Success");
//    }

//    @PostMapping("/start/job")
//    public ResponseEntity<String> JobStart(@RequestBody BatchRequest request) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        JobParameters jobParameter = new JobParameters();
//        JobParametersBuilder builder = new JobParametersBuilder();
//        builder.addString("filePath", request.getFilePath())
//                .addString("sourceSystem", request.getSourceSystem())
//                .addString("fileType",request.getFileType());
//        jobParameter = builder.toJobParameters();
//        jobLauncher.run(xmlToJsonConvertor,jobParameter);
//        return ResponseEntity.ok("Success");
//    }
}
