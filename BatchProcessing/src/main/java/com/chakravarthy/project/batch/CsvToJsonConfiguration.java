package com.chakravarthy.project.batch;

//import com.chakravarthy.project.batch.ItemProcessor.XmlToJsonProcessor;
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
public class CsvToJsonConfiguration {

    @Autowired
    private BatchPlatformTransactionManager batchPlatformTransactionManager;

    @Bean
    @Scope
    public Job csvToJsonConvertor(JobRepository jobRepository){
        return new JobBuilder("csvToJsonConvertor",jobRepository)
                .start(csvConvertStep(jobRepository, batchPlatformTransactionManager.getTransactionManager()))
                .build();
    }

    @Bean
    public Step csvConvertStep(JobRepository jobRepository, PlatformTransactionManager batchTransactionManager){
        return new StepBuilder("convertStep",jobRepository)
                .<String,String>chunk(2,batchTransactionManager)
                .reader(flatFileItemReader(null))
                .processor(myProcessor())
                .writer(flatFileItemWriter())
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
        return new ItemProcessor<String, String>() {
            @Override
            public String process(String item) throws Exception {
                return null;
            }
        };
//        return new XmlToJsonProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> flatFileItemWriter(){
        FlatFileItemWriter<String> flatFileItemWriter = new FlatFileItemWriter<>();
        flatFileItemWriter.setResource(new FileSystemResource("C:\\Users\\pc\\Documents\\op.xml"));
        LineAggregator<String> lineAggregator = item -> item;
        flatFileItemWriter.setLineAggregator(lineAggregator);
        return flatFileItemWriter;
    }

}
