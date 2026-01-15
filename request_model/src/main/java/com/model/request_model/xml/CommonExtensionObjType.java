package com.model.request_model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/***
 * Java Class for CommonExtensionObjType Complex Type
 * the following schema fragment specifies the expected content contained within this class.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonExtensionObjType")
@XmlSeeAlso({
        Root.class,
        Info.class,
        Details.class,
        Contract.class,
        ContractInfo.class,
        Contractor.class,
        ContestantDetails.class,
        Phone.class,
        PhoneDetails.class,
        Contestant.class,
        Name.class,
        Address.class,
        PermanentAddress.class,
        CurrentAddress.class,
        Character.class
})
public class CommonExtensionObjType {
}
