package org.example.models;

public class OrderCommissions {
    String orderId;
    Float amount;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }
}
