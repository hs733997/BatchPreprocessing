package com.chakravarthy.project.batch;

import com.chakravarthy.project.batch.ItemProcessor.XmlToJsonProcessor;
import com.chakravarthy.project.batch.ItemWriter.CompositeItemWriter;
import com.chakravarthy.project.configuration.BatchPlatformTransactionManager;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing(dataSourceRef = "batchDataSource", transactionManagerRef = "batchTransactionManager")
public class XmlToJsonConfiguration {

//    @Value("${filePath}")
//    private String FilePath;
//    @Autowired
//    private BatchRequest request;

    @Autowired
    private BatchPlatformTransactionManager batchPlatformTransactionManager;

    @Bean
    @Scope
    public Job xmlToJsonConvertor(JobRepository jobRepository){
        return new JobBuilder("xmlToJsonConvertor",jobRepository)
                .start(convertStep(jobRepository, batchPlatformTransactionManager.getTransactionManager()))
                .build();
    }

    @Bean
    public Step convertStep(JobRepository jobRepository, PlatformTransactionManager batchTransactionManager){
        return new StepBuilder("convertStep",jobRepository)
                .<String,String>chunk(2,batchTransactionManager)
                .reader(flatFileItemReader(""))
                .processor(myProcessor())
//                .writer(flatFileItemWriter(""))
                .writer(xmlToJsonWriter("",""))
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<String> flatFileItemReader(@Value("#{jobParameters[filePath]}") String pathToFile){
        FlatFileItemReader<String> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setLineMapper(new PassThroughLineMapper());
        flatFileItemReader.setResource(new FileSystemResource(pathToFile));
        return flatFileItemReader;
    }

    @Bean
    public ItemProcessor<String,String> myProcessor(){
        return new XmlToJsonProcessor();
    }

    /***
     * this method is used for flat file item writer in the write path mentioned.
     */
//    @Bean
//    @StepScope
//    public FlatFileItemWriter<String> flatFileItemWriter(@Value("#{jobParameters[writePath]}") String pathToWrite){
//        FlatFileItemWriter<String> flatFileItemWriter = new FlatFileItemWriter<>();
//        flatFileItemWriter.setResource(new FileSystemResource(pathToWrite));
//        LineAggregator<String> lineAggregator = item -> item;
//        flatFileItemWriter.setLineAggregator(lineAggregator);
//        return flatFileItemWriter;
//    }
    @Bean
    @StepScope
    public CompositeItemWriter xmlToJsonWriter(@Value("#{jobParameters[writePath]}") String pathToWrite,
                                               @Value("#{jobParameters[failedPath]}") String failedPath){
        return  new CompositeItemWriter(new FlatFileItemWriter<>(), new FlatFileItemWriter<>(),
                pathToWrite,failedPath);
    }
}
