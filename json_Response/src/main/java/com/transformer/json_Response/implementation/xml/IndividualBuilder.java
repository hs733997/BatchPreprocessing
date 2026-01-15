package com.transformer.json_Response.implementation.xml;

import com.model.request_model.xml.Address;
import com.model.request_model.xml.Contestant;
import com.model.request_model.xml.Name;
import com.model.request_model.xml.Phone;
import com.model.response_model.common.SimpleAttributeType;
import com.model.response_model.entity.individual.*;
import com.transformer.json_Response.utils.TransformerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualBuilder {

    @Autowired
    private TransformerUtils transformerUtils;

    public List<SimpleAttributeType> buildBirthGender(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildMaritalStatus(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildAge(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildNationality(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildBirhDate(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildBrand(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    public List<SimpleAttributeType> buildDeseasedDate(String value){
        return transformerUtils.buildSimpleAttribute(value);
    }
    //add null checks
    public List<IndividualNameAttribute> buildIndividualName(Name personName, String sourceSystem){
        List<IndividualNameAttribute> individualNameAttributeList = new ArrayList<>();
        IndividualNameAttribute individualNameAttribute = new IndividualNameAttribute();
        IndividualNameAttribute.IndividualName individualName = new IndividualNameAttribute.IndividualName();
        individualName.setFirstName(transformerUtils.buildSimpleAttribute(personName.getFirstName()));
        individualName.setLastName(transformerUtils.buildSimpleAttribute(personName.getLastName()));
        individualName.setTitle(transformerUtils.buildSimpleAttribute(personName.getTitle()));
        individualName.setInitial(transformerUtils.buildSimpleAttribute(personName.getTitle()));
        individualName.setStartDate(transformerUtils.buildSimpleAttribute(personName.getStartDate()));
        individualName.setEndDate(transformerUtils.buildSimpleAttribute(personName.getEndDate()));
        individualName.setUpdatedBy(transformerUtils.buildSimpleAttribute(personName.getUpdatedBy()));
        individualName.setUpdatedDate(transformerUtils.buildSimpleAttribute(personName.getUpdateDate()));
        individualName.setMiddleName(buildMiddleName(personName));
        return individualNameAttributeList;
    }

    private List<MiddleNameAttribute> buildMiddleName(Name personName) {
        List<MiddleNameAttribute> middleNameAttributeList = new ArrayList<>();
        MiddleNameAttribute middleNameAttribute = new MiddleNameAttribute();
        MiddleNameAttribute.MiddleName middleName = new MiddleNameAttribute.MiddleName();
        middleName.setGivenName1(transformerUtils.buildSimpleAttribute(personName.getMiddleName()));
        middleName.setGivenName2(transformerUtils.buildSimpleAttribute(personName.getMiddleName2()));
        middleName.setGivenName3(transformerUtils.buildSimpleAttribute(personName.getMiddleName3()));
        middleName.setGivenName4(transformerUtils.buildSimpleAttribute(personName.getMiddleName4()));
        middleNameAttribute.setValue(middleName);
        middleNameAttributeList.add(middleNameAttribute);
        return middleNameAttributeList;
    }

    public List<PhoneAttribute> buildPhone(List<Phone> phoneList, String sourceSystem){
        List<PhoneAttribute> phoneAttributeList = new ArrayList<>();
        if(!phoneList.isEmpty()){
            phoneList.forEach(phone -> {
                PhoneAttribute phoneAttribute = new PhoneAttribute();
                PhoneAttribute.Phone ph = new PhoneAttribute.Phone();
                ph.setAreaCode(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getAreaCode()));
                ph.setStartDate(transformerUtils.buildSimpleAttribute(phone.getStartDate()));
                ph.setEndDate(transformerUtils.buildSimpleAttribute(phone.getEndDate()));
                ph.setUpdatedBy(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getUpdatedBy()));
                ph.setUpdatedDate(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getUpdatedDate()));
                ph.setCountryCode(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getCountryCode()));
                ph.setNumber(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getNumber()));
                ph.setStatus(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getStatus()));
//                ph.setType(transformerUtils.buildSimpleAttribute(phone.getType()));
                ph.setUsage(transformerUtils.buildSimpleAttribute(phone.getType()));
                ph.setValidationStatus(transformerUtils.buildSimpleAttribute(phone.getPhoneDetails().getVerificationStatus()));
                phoneAttribute.setValue(ph);
                phoneAttributeList.add(phoneAttribute);
            });
        }
        return phoneAttributeList;
    }

    public List<EmailAttribute> buildEmailAttribute(String emailId, String sourceSystem){
        List<EmailAttribute> emailAttributeList = new ArrayList<>();
        EmailAttribute emailAttribute = new EmailAttribute();
        EmailAttribute.Email email = new EmailAttribute.Email();
//        email.setType();set if present else set default type
        email.setEmailAddress(transformerUtils.buildSimpleAttribute(emailId));
//        email.setStatus();
//        email.setStartDate();
//        email.setEndDate();
//        email.setUpdatedBy();
        email.setUpdatedDate(transformerUtils.buildSimpleAttribute(transformerUtils.getCurrentDateWithTimeStamp()));
//        email.setUsername();
//        email.setUsage();
//        email.setPreferred();
        emailAttribute.setValue(email);
        emailAttributeList.add(emailAttribute);
        return emailAttributeList;
    }

    public List<NationalIdentifiersAttribute> buildNationalIdentifier(Contestant contestant, String sourceSystem){
        List<NationalIdentifiersAttribute> nationalIdentifiersAttributeList = new ArrayList<>();
        NationalIdentifiersAttribute nationalIdentifiersAttribute = new NationalIdentifiersAttribute();
        NationalIdentifiersAttribute.NationalIdentifier nationalIdentifier
                = new NationalIdentifiersAttribute.NationalIdentifier();
//        nationalIdentifier.setType();
//        nationalIdentifier.setValue();
        nationalIdentifier.setStartDate(transformerUtils.buildSimpleAttribute(transformerUtils.getCurrentDate()));
//        nationalIdentifier.setEndDate();
//        nationalIdentifier.setUpdatedBy();
        nationalIdentifier.setUpdatedDate(transformerUtils.buildSimpleAttribute(transformerUtils.getCurrentDateWithTimeStamp()));
        nationalIdentifiersAttribute.setValue(nationalIdentifier);
        nationalIdentifiersAttributeList.add(nationalIdentifiersAttribute);
        return nationalIdentifiersAttributeList;
    }

    public List<AddressReference> buildAddress(List<Address> addresses){
        List<AddressReference> addressReferenceList = new ArrayList<>();
        AddressReference addressReference = new AddressReference();
        AddressReference.Address add = new AddressReference.Address();
        addresses.forEach(address -> {
            add.setAddressLine1(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getdNo()));
//            add.setAddressLine2();
//            add.setAddressLine3();
//            add.setAddressLine4();
//            add.setAddressLine5();
//            add.setAddressLine6();
//            add.setAddressType();
            add.setBuildingNumber(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getBuildingNo()));
            add.setCity(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getCity()));
            add.setCountry(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getCountry()));
            add.setLandmark(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getLandMark()));
            add.setState(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getState()));
            add.setStreet(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getStreet()));
            add.setVarificationStatus(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getVerificationStatus()));
            add.setUpdatedBy(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getUpdatedBy()));
            add.setUpdatedDate(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getUpdatedDate()));
//            add.setZip(transformerUtils.buildSimpleAttribute(address.getCurrentAddress().getPinCode()));
            addressReference.setValue(add);
            addressReferenceList.add(addressReference);
        });
        return addressReferenceList;
    }

}
