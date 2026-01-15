package com.chakravarthy.project.service.implementation;

import com.model.request_model.xml.Root;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
public class XMLTransformer {
    private static final Logger logger = LoggerFactory.getLogger(XMLTransformer.class);
    @Autowired
    private JAXBContext jaxbContext;
    public Root transformXml(final String inputXmlLine){
        Root root = null;
        try{
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            root = (Root)unmarshaller.unmarshal(new ByteArrayInputStream(inputXmlLine.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            logger.error("Exception occured while converting xml to Root Object and the cause is {0}",e);
        }
        return root;
    }
}
