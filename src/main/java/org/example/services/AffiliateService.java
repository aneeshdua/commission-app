package org.example.services;

import org.example.models.Affiliate;

import java.util.HashMap;

public class AffiliateService {

    static HashMap<String, Affiliate> affiliateList = new HashMap<String, Affiliate>();

    public static void updateAffiliateBalance(String affiliateId, Float commission) {
        Affiliate affiliate = affiliateList.get(affiliateId);
        affiliate.setCommissionAmountTillDate(affiliate.getCommissionAmountTillDate() + commission);
    }

    public void addAffiliate(String affiliateId, String name){
        Affiliate newAffiliate = new Affiliate();
        newAffiliate.setAffiliateId(affiliateId);
        newAffiliate.setName(name);
        affiliateList.put(affiliateId,newAffiliate);
    }

    public boolean checkIfAffiliateExists(String affiliateId){
        if (affiliateList.get(affiliateId) != null){
            return true;
        } else {
            return false;
        }
    }

    public static Affiliate getAffiliateById(String affiliateId) {
        return affiliateList.get(affiliateId);
    }
}
