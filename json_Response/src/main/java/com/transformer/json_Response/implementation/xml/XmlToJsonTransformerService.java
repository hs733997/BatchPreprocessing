package com.transformer.json_Response.implementation.xml;

import com.model.request_model.xml.*;
import com.model.request_model.xml.Character;
import com.model.response_model.batch.RequestJsonEntity;
import com.model.response_model.entity.IndividualEntity;
import com.transformer.json_Response.constant.TransformerConstant;
import com.transformer.json_Response.utils.TransformerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Qualifier("xmlToJsonTransformerService")
public class XmlToJsonTransformerService {

    private static final Logger log =
            LoggerFactory.getLogger(XmlToJsonTransformerService.class);

    @Autowired
    public IndividualBuilder individualBuilder;
    @Autowired
    public TransformerUtils transformerUtils;
    @Autowired
    public  XmlConversionHelper xmlConversionHelper;

    public RequestJsonEntity convertXmlToJson(Object inputObject){
        log.info("Converting Xml to Json Started");
        AtomicReference<String> hostName = new AtomicReference<>();
        RequestJsonEntity requestJsonEntity = new RequestJsonEntity();
        List<IndividualEntity> individualEntityList = new ArrayList<>();
        Root root = (Root) inputObject;
        List<Contract> contractList = transformerUtils.getContractList(root);
        if(!ObjectUtils.isEmpty(contractList)){
            RequestJsonEntity finalRequestJsonEntity = new RequestJsonEntity();
//            RequestJsonEntity finalRequestJsonEntity1 = new RequestJsonEntity();
            contractList.forEach(contract -> {
                hostName.set(contract.getOwner());
//                final List<ContractInfo> contractInfoList = transformerUtils.getContractInfoList(contract);
//                if(!ObjectUtils.isEmpty(contractInfoList)){
//                    contractInfoList.forEach(contractInfo -> {
//
//                    });
//                }
//                final List<ContractInfo> contractInfoList = transformerUtils.getContractInfoList(contract);
//                createPolicyTypeMapping(contractInfoList, finalRequestJsonEntity, hostName);
                final List<ContestantDetails> contestantDetailsList = transformerUtils.getContestantDetailsList(contract);
                processContestantDetailsList(contestantDetailsList,individualEntityList,hostName.get(),contract,finalRequestJsonEntity);
            });
        }
        if(!individualEntityList.isEmpty())
            requestJsonEntity.setIndividualEntityList(individualEntityList);

        xmlConversionHelper.setInfoDetails(requestJsonEntity,root);
        log.info("Conversion process completed Successfully returning the Json Output");
        return requestJsonEntity;
    }

//    private void createPolicyTypeMapping(List<ContractInfo> contractInfoList, RequestJsonEntity finalRequestJsonEntity, AtomicReference<String> hostName) {
//        if(!ObjectUtils.isEmpty(contractInfoList)){
//            contractInfoList.forEach(contractInfo -> {
////                if(ObjectUtils.isEmpty(contractInfo.getContractType())){
//
////                }
//            });
//        }
//    }

    private void processContestantDetailsList(List<ContestantDetails> contestantDetailsList,
                                             List<IndividualEntity> individualEntityList,
                                             String sourceSystem,Contract contract, RequestJsonEntity finalRequestJsonEntity) {
        if(!contestantDetailsList.isEmpty() && contestantDetailsList!=null){
            contestantDetailsList.forEach(contestantDetails -> {
                String contestantId = contestantDetails.getId();
                List<Character> characterList = contract.getCharacters();
                List<Character> filteredCharacterList = characterList.stream().filter(character -> character.getContestantDetails().getId().equalsIgnoreCase(contestantId)).toList();
                String addressId = characterList.get(0).getAddress().getAddressId();
                Address address = contract.getAddress().stream().filter(address1 -> address1.getAddressId().equalsIgnoreCase(addressId)).toList().get(0);
                List<Contestant> contestantList = contestantDetails.getContestant();
                if(contestantList != null && !contestantList.isEmpty()){
                    contestantList.forEach(contestant -> processOneContestant(individualEntityList, sourceSystem, contract, finalRequestJsonEntity, contestantDetails, filteredCharacterList, address, contestant));
                }

                //Line142 start
            });
        }
    }

    private void processOneContestant(List<IndividualEntity> individualEntityList, String sourceSystem, Contract contract, RequestJsonEntity finalRequestJsonEntity, ContestantDetails contestantDetails, List<Character> filteredCharacterList, Address address, Contestant contestant) {
        IndividualEntity individualEntity = new IndividualEntity();
        individualEntity.setCrosswalk(transformerUtils.buildCrossWalk(TransformerConstant.CROSSWALK + sourceSystem, contestantDetails.getSourceContestantId()));
        IndividualEntity.Attributes attributes = new IndividualEntity.Attributes();
        attributes.setCustomerId(transformerUtils.buildSimpleAttribute(contestantDetails.getSourceContestantId()));
        attributes.setUserId(transformerUtils.buildSimpleAttribute(contestantDetails.getId()));
        attributes.setPhone(individualBuilder.buildPhone(contestantDetails.getPhone(),sourceSystem));
        attributes.setEmail(individualBuilder.buildEmailAttribute(contestantDetails.getEmail(),sourceSystem));
        attributes.setAddress(individualBuilder.buildAddress(contract.getAddress()));
        attributes.setUpdatedDate(transformerUtils.buildSimpleAttribute(transformerUtils.getCurrentDateWithTimeStamp()));
        attributes.setUpdatedBy(transformerUtils.buildSimpleAttribute("SRK."));
        individualEntity.setAttributes(attributes);
        individualEntityList.add(individualEntity);
    }
}
