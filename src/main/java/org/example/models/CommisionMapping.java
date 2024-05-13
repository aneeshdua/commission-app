package org.example.models;

import org.example.enums.Categories;
import org.example.enums.CommissionType;

import static org.example.enums.CommissionType.PERCENTAGE;

public class CommisionMapping {

    Enum<Categories> category;

    Float percentage;

    Float flatRate;

    Float maxCap;

    Float newAttr;

    public void setCategory(Enum<Categories> category) {
        this.category = category;
    }

    public void setFlatRate(Float flatRate) {
        this.flatRate = flatRate;
    }

    public void setMaxCap(Float maxCap) {
        this.maxCap = maxCap;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public void addCommision(Enum<Categories> category, Enum<CommissionType> commissionTypeEnum, Float percentage, Float flatRate, Float maxCap){
        setCategory(category);
        if (commissionTypeEnum==PERCENTAGE){

            setPercentage(percentage);
            setMaxCap(maxCap);
        } else {
            setFlatRate(flatRate);
        }
    }

    public Object getCommissionTypeEnum() {
        return this.percentage != null ? PERCENTAGE : CommissionType.FLAT_RATE;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public Float getMaxCap() {
        return this.maxCap;
    }

    public Float getFlatRate() {
        return this.flatRate;
    }
}
