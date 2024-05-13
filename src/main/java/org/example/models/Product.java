package org.example.models;

import org.example.enums.Categories;

public class Product {

    String productId;
    Enum<Categories> category;

    public void setCategoryId(Enum<Categories> category) {
        this.category = category;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Enum<Categories> getCategory() {
        return category;
    }

    public String getProductId() {
        return productId;
    }
}
