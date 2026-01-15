package com.chakravarthy.project.configuration;

import com.model.request_model.xml.Root;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.transformer.json_Response"})
public class DataProcessorConfiguration {

    private static Logger logger = LoggerFactory.getLogger(DataProcessorConfiguration.class);

    /***
     * This configuration creates an instance of JaxbContext
     */
    @Bean(name = "jaxbContext")
    public JAXBContext jaxbContext(){
        JAXBContext context = null;
        try{
            context = JAXBContext.newInstance(Root.class);
        } catch (JAXBException e) {
            logger.error("Not able to create JAXBContext using the Root class");
        }
        return context;
    }
}
