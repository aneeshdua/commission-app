package org.example.services;

import org.example.enums.Categories;
import org.example.enums.CommissionType;
import org.example.models.CommisionMapping;

import java.util.HashMap;

import static org.example.enums.CommissionType.PERCENTAGE;

public class ComissionMappingService {

    static HashMap<Enum<Categories>, CommisionMapping> commisionMappingHashMap = new HashMap<Enum<Categories>, CommisionMapping>();
    public void addCommision(Enum<Categories> category, Enum<CommissionType> commissionTypeEnum, Float percentage, Float flatRate, Float maxCap){
        CommisionMapping commisionMapping = new CommisionMapping();
        commisionMapping.setCategory(category);
        if (commissionTypeEnum==PERCENTAGE){

            commisionMapping.setPercentage(percentage);
            commisionMapping.setMaxCap(maxCap);
        } else {
            commisionMapping.setFlatRate(flatRate);
        }
        commisionMappingHashMap.put(category,commisionMapping);
    }

    public CommisionMapping getCommisionMappingByCategory(Enum<Categories> category){
        return commisionMappingHashMap.get(category);
    }
}
