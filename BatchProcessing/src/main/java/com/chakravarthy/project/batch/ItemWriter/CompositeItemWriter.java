package com.chakravarthy.project.batch.ItemWriter;

import com.chakravarthy.project.configuration.DataProcessorConfiguration;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class CompositeItemWriter implements ItemWriter<Object> {
    
    private final FlatFileItemWriter<String> successItemWriter;
    private final FlatFileItemWriter<String> failureItemWriter;
    private final String successPath;
    private final String failurePath;
    @Autowired
    private DataProcessorConfiguration dataProcessorConfiguration;

    public CompositeItemWriter(FlatFileItemWriter<String> successItemWriter,
                               FlatFileItemWriter<String> failureItemWriter,
                               String successPath,
                               String failurePath) {
        this.successItemWriter = successItemWriter;
        this.failureItemWriter = failureItemWriter;
        this.successPath = successPath;
        this.failurePath = failurePath;
    }

    @Override
    public void write(Chunk<? extends Object> chunk) throws Exception {
        List<? extends Object> objects = chunk.getItems();
        for (Object object : objects){
            String value = String.valueOf(object);
            value = value.replace("\\\\","");
            if(object!=null && value.startsWith("conversionsuccess")){
                value = value.replace("conversionsuccess","");
//                List<String> payLoadResponse = List.of(value.split());
                writeToSuccessLoaction(value);
            }
            else if(object != null && value.startsWith("conversionfailed")){
                value = value.replace("conversionfailed","");
                writeToFailureLoaction(value);
            }
        }
    }

    private void writeToSuccessLoaction(String value) throws Exception {
        successItemWriter.setResource(new FileSystemResource(successPath));
        LineAggregator<String> lineAggregator = item -> item;
        successItemWriter.setLineAggregator(lineAggregator);
        successItemWriter.setLineSeparator(System.lineSeparator());
        successItemWriter.setAppendAllowed(true);
        successItemWriter.afterPropertiesSet();
        ExecutionContext executionContext = new ExecutionContext();
        successItemWriter.open(executionContext);
        Chunk<String> obj = new Chunk<>(value);
        successItemWriter.write(obj);
    }

    private void writeToFailureLoaction(String value) throws Exception {
        failureItemWriter.setResource(new FileSystemResource(failurePath));//change to failed path
        LineAggregator<String> lineAggregator = item -> item;
        failureItemWriter.setLineAggregator(lineAggregator);
        failureItemWriter.setLineSeparator(System.lineSeparator());
        failureItemWriter.setAppendAllowed(true);
        failureItemWriter.afterPropertiesSet();
        ExecutionContext executionContext = new ExecutionContext();
        failureItemWriter.open(executionContext);
        Chunk<String> obj = new Chunk<>(value);
        failureItemWriter.write(obj);
    }
}
