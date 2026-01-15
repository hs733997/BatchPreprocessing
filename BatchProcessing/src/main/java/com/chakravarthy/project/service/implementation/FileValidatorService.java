package com.chakravarthy.project.service.implementation;

import com.chakravarthy.project.constants.BatchProcessingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileValidatorService {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileValidatorService.class);

    @Value(BatchProcessingConstants.FILE_VALIDATION_COUNT)
    private int count;

    @Value(BatchProcessingConstants.BATCH_VALIDATION_SOURCESYSTEM)
    private List<String> sourceSystem;

    public boolean isValidFile(File file) throws IOException {
        try {
            String fileName = file.getName();
            String[] fileNameParameters = fileName.split("\\.");
            return (validateSourceSystem(fileNameParameters[4], file) &&
                    validateEmptyFile(file) &&
                    validateRowCount(file));
        } catch(Exception e){
            System.out.println("Exception encountered --> "+e);
            LOGGER.error("FileName should be like : \"sys.bus.rao.form.SOURCESYSTEM.num(any)\" " +
                    "<--> compare fileName req. vs <--> your fileName({}) ",file.getName());
            return false;
        }
    }

    private boolean validateRowCount(File file) throws IOException {
        Path path = Paths.get(file.getPath());
        long lines = 0;
        lines = Files.readAllLines(path).stream().toList().size();
        if(lines<count)
            return true;
        else{
            LOGGER.error("No of lines exceeds the count in the input FileList {}",file.getName());
            return false;
        }
    }

    private boolean validateEmptyFile(File file) {
        if(file.length()!=0)
            return true;
        else {
            LOGGER.error("The File is Empty and so cannot be processed {}",file.getName());
            return false;
        }
    }

    private boolean validateSourceSystem(String sourceSystemName, File file) {
        if(sourceSystem.contains(sourceSystemName))
            return true;
        else {
            LOGGER.error("The SourceSystem in the FileName is invalid : {}", file.getName());
            return false;
        }
    }
}
