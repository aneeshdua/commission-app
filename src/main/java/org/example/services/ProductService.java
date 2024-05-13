package org.example.services;

import org.example.enums.Categories;
import org.example.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService {
//    List<Product> productList = new <Product>();
    HashMap<String, Product> productList = new HashMap<String, Product>();

    public void addProduct(String productId, Enum<Categories> category){
        Product newProduct = new Product();
        newProduct.setProductId(productId);
        newProduct.setCategoryId(category);
        productList.put(productId,newProduct);
    }

    public Product getProduct(String productId){
        try {

            return productList.get(productId);
        } catch (Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkIfExists(String productId){
        if (productList.get(productId) != null){
            return true;
        } else {
            return false;
        }
    }
}
