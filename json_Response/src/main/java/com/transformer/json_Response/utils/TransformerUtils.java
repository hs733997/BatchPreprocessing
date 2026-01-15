package com.transformer.json_Response.utils;

import com.model.request_model.xml.*;
import com.model.response_model.common.CrossWalk;
import com.model.response_model.common.SimpleAttributeType;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransformerUtils {

    public static final String DATE_FORMAT_WITH_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public List<CrossWalk> buildCrossWalk(Contract contract){
        List<CrossWalk> crossWalkList = new ArrayList<>();
        CrossWalk crossWalk = new CrossWalk();
        crossWalk.setType("configuration/sources"+contract.getOwner());
        crossWalk.setValue(contract.getOwner()+contract.getContractInfo().get(0).getCode());
        crossWalkList.add(crossWalk);
        return crossWalkList;
    }
    public List<CrossWalk> buildCrossWalk(final String crossWalkTypeInput, final String crossWalkValue){
        List<CrossWalk> crossWalkList = new ArrayList<>();
        CrossWalk crossWalk = new CrossWalk();
        crossWalk.setType(crossWalkTypeInput);
        crossWalk.setValue(crossWalkValue);
        crossWalkList.add(crossWalk);
        return crossWalkList;
    }

    public List<SimpleAttributeType> buildSimpleAttribute(String value){
        List<SimpleAttributeType> simpleAttributeTypeList = new ArrayList<>();
        SimpleAttributeType simpleAttributeType = new SimpleAttributeType();
        simpleAttributeType.setValue(value);
        simpleAttributeTypeList.add(simpleAttributeType);
        return simpleAttributeTypeList;
    }

    public List<Contract> getContractList(Root root){
        return root.getDetails().getContract();
    }

    public List<ContractInfo> getContractInfoList(Contract contract){
        return contract.getContractInfo();
    }

    public List<ContestantDetails> getContestantDetailsList(Contract contract){
        return contract.getContestantDetails();
    }

    public int getAddressHashCode(PermanentAddress permanentAddress){
        String address = permanentAddress.getdNo() + permanentAddress.getStreet()
                + permanentAddress.getCity() + permanentAddress.getDistrict() + permanentAddress.getState()
                + permanentAddress.getLandMark() + permanentAddress.getPinCode();
        return address.hashCode();
    }

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getCurrentDateWithTimeStamp(){
        return new SimpleDateFormat(DATE_FORMAT_WITH_TIMESTAMP).format(new Date());
    }
}
