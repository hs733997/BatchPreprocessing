package com.chakravarthy.project.utils;

import com.chakravarthy.project.exceptions_custom.HariFileNotFoundException;
import com.chakravarthy.project.rest.request.BatchRequest;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BatchProcessingUtils {

    public List<File> getFileList(String path) {
        try{
            return Files.list(Paths.get(path))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .filter(file -> !file.getName().endsWith("ctl"))
                    .collect(Collectors.toList());
        } catch (IOException e){
            throw new HariFileNotFoundException("No file present in the Path");
        }
    }

    public JobParameters getJobParameters(BatchRequest request, String absoluteFilePath, String failedPath) {
        JobParametersBuilder builder = new JobParametersBuilder();
        if(request!=null && request.getFilePath()!=null)
            builder.addString("filePath",request.getFilePath());

        if(absoluteFilePath != null)
            builder.addString("filePath",absoluteFilePath);

        if(request!=null && request.getSourceSystem()!=null)
            builder.addString("sourceSystem", request.getSourceSystem());

        if(request!=null && request.getFileType()!=null)
            builder.addString("fileType", request.getFileType());

        if(request!=null && request.getToWritingLocation()!=null)
            builder.addString("writePath", request.getToWritingLocation());

        if(failedPath!=null)
            builder.addString("failedPath", failedPath);

        if(request!=null)
            builder.addDate("date",new Date());

        return builder.toJobParameters();
    }
}
