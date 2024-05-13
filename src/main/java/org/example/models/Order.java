package org.example.models;

import org.example.enums.Categories;
import org.example.enums.OrderStatus;

import java.sql.Timestamp;

public class Order {
    String orderId;
    Float price;
//    Product product;
    String productId;
    Enum<Categories> category;

//    Affiliate affiliate;
    String affiliateId;

    Timestamp timestamp;

    Enum<OrderStatus> orderStatusEnum;

    public void setCategory(Enum<Categories> category) {
        this.category = category;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatusEnum(Enum<OrderStatus> orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public String getOrderId() {
        return orderId;
    }

    public Enum<OrderStatus> getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void updateOrderStatus(Enum<OrderStatus> status){
        setOrderStatusEnum(status);
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public void setOrderDate(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
