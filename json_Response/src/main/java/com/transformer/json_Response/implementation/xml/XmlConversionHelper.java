package com.transformer.json_Response.implementation.xml;

import com.model.request_model.xml.Contestant;
import com.model.request_model.xml.Root;
import com.model.response_model.batch.RequestJsonEntity;
import com.model.response_model.entity.IndividualEntity;
import com.transformer.json_Response.utils.TransformerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XmlConversionHelper {
    @Autowired
    private IndividualBuilder individualBuilder;
    @Autowired
    private TransformerUtils transformerUtils;

    public void setIndividualBuilder(Contestant contestant, IndividualEntity.Attributes attributes, String sourceSystem){
        attributes.setBirthDate(transformerUtils.buildSimpleAttribute(contestant.getDateOfBirth()));
        attributes.setBrand(transformerUtils.buildSimpleAttribute(contestant.getBrand()));
        attributes.setBirthGender(transformerUtils.buildSimpleAttribute(contestant.getGender()));
        attributes.setCustomerId(transformerUtils.buildSimpleAttribute(contestant.getCustomerId()));
        attributes.setDeceasedConfirmationDate(transformerUtils.buildSimpleAttribute(contestant.getDeceasedConfirmationDate()));
        attributes.setDeceasedDate(transformerUtils.buildSimpleAttribute(contestant.getDeceasedDate()));
        attributes.setDeceasedNotificationDate(transformerUtils.buildSimpleAttribute(contestant.getDeceasedNotificationDate()));
        attributes.setIntroducer(transformerUtils.buildSimpleAttribute(contestant.getIntroducer()));
        attributes.setMaritalStatus(transformerUtils.buildSimpleAttribute(contestant.getMaritalStatus()));
        attributes.setName(transformerUtils.buildSimpleAttribute(contestant.getName().getFirstName()));
        attributes.setNationality(transformerUtils.buildSimpleAttribute(contestant.getNationality()));
        attributes.setOan(transformerUtils.buildSimpleAttribute(contestant.getOan()));
        attributes.setUpdatedBy(transformerUtils.buildSimpleAttribute(contestant.getUpdatedBy()));
        attributes.setUpdatedDate(transformerUtils.buildSimpleAttribute(contestant.getUpdatedDate()));
        attributes.setUserId(transformerUtils.buildSimpleAttribute(contestant.getUserId()));

//        attributes.setAddress(transformerUtils.buildSimpleAttribute(contestant.ge));
//        attributes.setIndividualName(transformerUtils.buildSimpleAttribute(contestant.ge));
//        attributes.setEmail();
//        attributes.setNationalIdentifiers();
//        attributes.setPhone();

    }
    public void setInfoDetails(RequestJsonEntity requestJsonEntity, Root root){
        requestJsonEntity.setSource(root.getInfo().getSource());
        requestJsonEntity.setType(root.getInfo().getType());
        requestJsonEntity.setVersion(root.getInfo().getVersion());
        requestJsonEntity.setSourceId(root.getInfo().getSourceId());
        requestJsonEntity.setSourceDateTimeStamp(root.getInfo().getSourceDateTimeStamp());
    }

}
