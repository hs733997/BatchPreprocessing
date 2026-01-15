package com.chakravarthy.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class BatchDataSourceConfiguration {

    @Bean(name = "batchDataSource")
    public DataSource batchDataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                .addScript("schema-drop-h2.sql")
                .addScript("schema-h2.sql")
                .build();
    }
}
