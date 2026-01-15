package com.chakravarthy.project.batch.ItemProcessor;

import com.chakravarthy.project.service.implementation.XMLTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.request_model.xml.Root;
import com.model.response_model.batch.RequestJsonEntity;
import com.transformer.json_Response.implementation.xml.XmlToJsonTransformerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XmlToJsonProcessor implements ItemProcessor<String,String> {
    public static final Logger logger = LoggerFactory.getLogger(XmlToJsonProcessor.class);
    public static final String startTag = "<Root";

//    @Override
//    public String process(String item) throws Exception {
//        return item;
//    }
    public static final String xml_type = "xml";
    @Autowired
    private XMLTransformer xmlTransformer;
    @Autowired
    private XmlToJsonTransformerService xmlToJsonTransformerService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String process(String item) throws Exception {
        try{
            logger.info("Entry tp process XmlToJson item");
            String xmlStringWithoutEncoding = item.substring(item.indexOf(startTag));
            Root root = xmlTransformer.transformXml(xmlStringWithoutEncoding);
            if(root != null)
                return processReqStyleXml(root);
            else {
                logger.info("Existing from process method the xml is not valid for doing conversion");
                return "conversion failed : " + item;
            }
        }
        catch (RuntimeException e){
            logger.error("Exception occured while procesing the cml it will be written in error location and the cause is ",e);
            return "conversionfailed" + item;
        }
    }

    public String processReqStyleXml(Root root) throws JsonProcessingException {
        RequestJsonEntity requestJsonEntity = xmlToJsonTransformerService.convertXmlToJson(root);
        String processedJsonFile = objectMapper.writeValueAsString(requestJsonEntity);
        processedJsonFile = "conversionsuccess" + processedJsonFile;
        return processedJsonFile;
    }
}
