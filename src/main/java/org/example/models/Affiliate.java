package org.example.models;

public class Affiliate {
    String affiliateId;
    String name;

    Float commissionAmountTillDate = 0.0f;

    Float commissionAmountPaidTillDate = 0.0f;
    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public String getName() {
        return name;
    }

    public void setCommissionAmountPaidTillDate(Float commissionAmountPaidTillDate) {
        this.commissionAmountPaidTillDate = commissionAmountPaidTillDate;
    }

    public void setCommissionAmountTillDate(Float commissionAmountTillDate) {
        this.commissionAmountTillDate = commissionAmountTillDate;
    }

    public Float getCommissionAmountPaidTillDate() {
        return commissionAmountPaidTillDate;
    }

    public Float getCommissionAmountTillDate() {
        return commissionAmountTillDate;
    }
}
