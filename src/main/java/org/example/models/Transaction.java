package org.example.models;

import java.util.HashMap;
import java.util.List;

public class Transaction {
    String transactionId;

    String affiliateId;

    Float totalAmount;
    List<OrderCommissions> orderCommissions;

    public String getAffiliateId() {
        return affiliateId;
    }

    public  List<OrderCommissions> getorderCommissions() {
        return orderCommissions;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setOrderCommissions(List<OrderCommissions> orderCommissions) {
        this.orderCommissions = orderCommissions;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }
}
