package com.chakravarthy.project.service.implementation;

import com.chakravarthy.project.rest.request.BatchRequest;
import com.chakravarthy.project.service.FilePreProcessing;
import com.chakravarthy.project.utils.BatchProcessingUtils;
import io.micrometer.common.util.StringUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static com.chakravarthy.project.constants.BatchProcessingConstants.*;

@Service
public class FilePreProcessingService implements FilePreProcessing {

    @Autowired
    @Qualifier("xmlToJsonConvertor")
    private Job xmlToJsonConverter;

    @Autowired
    @Qualifier("csvToJsonConvertor")
    private Job csvToJsonConverter;

    @Autowired
    private BatchProcessingUtils batchProcessingUtils;

    @Autowired
    private FileValidatorService fileValidatorService;

    @Autowired
    private AsyncBatchLauncher asyncBatchLauncher;

    @Value("${fileReadyToBePreccessedLocation}")
    public String fileReadyToBePreccessedLocation;

    @Value("${fileValidationSuccessLocation}")
    public String fileValidationSuccessLocation;

    @Value("${fileValidationFailedLoaction}")
    public String fileValidationFailedLoaction;

    @Override
    public String executeBatch(BatchRequest batchRequest) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, IOException {
        String sourceSystem = batchRequest.getSourceSystem();
        String filePath = batchRequest.getFilePath();
        String fileType = batchRequest.getFileType();
        List<File> fileList;
        if(!StringUtils.isBlank(sourceSystem)){
            switch (fileType){
                case "xml":
                    fileList  = batchProcessingUtils.getFileList(filePath);
                    if(!fileList.isEmpty()) {
                        processFile(xmlToJsonConverter, fileList, batchRequest, sourceSystem);
                    }
                    break;
                case "csv":
                    fileList  = batchProcessingUtils.getFileList(filePath);
                    if(!fileList.isEmpty()) {
                        processFile(csvToJsonConverter, fileList, batchRequest, sourceSystem);
                    }                    break;
                default:
                    System.out.println("not a valid file: try to write an exception");
            }
        }
        return "success";
    }

    private void processFile(Job job, List<File> fileList, BatchRequest batchRequest, String sourceSystem) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, IOException {
        for(File file:fileList){
            String absolutePath = "";
            if(fileValidatorService.isValidFile(file)){
                absolutePath = file.getAbsolutePath();
                String writingFileName = file.getName().substring(0,file.getName().lastIndexOf("."))+JSON_DOT;
                Path newFilePath = Files.move(Path.of(absolutePath),
                        Path.of(fileReadyToBePreccessedLocation+file.getName()),
                        StandardCopyOption.ATOMIC_MOVE);
                String writingLocation = (new StringBuilder()).append(fileValidationSuccessLocation)
                        //.append(sourceSystem.toLowerCase())
                        .append(PATH_DELIMITER)
                        .append(writingFileName).toString();
                String failedLocation = (new StringBuilder()).append(fileValidationFailedLoaction)
                        //.append(sourceSystem.toLowerCase())
                        .append(PATH_DELIMITER)
                        .append(file.getName()).toString();
                batchRequest.setToWritingLocation(writingLocation);
                JobParameters jobParameters =
                        batchProcessingUtils.getJobParameters(batchRequest,newFilePath.toAbsolutePath().toString(),failedLocation);
                if(!absolutePath.isEmpty() &&
                        absolutePath.endsWith(".csv") || absolutePath.endsWith(".json") || absolutePath.endsWith(".xml"))
                    asyncBatchLauncher.startJob(job,jobParameters);
            }
        }
    }
}
