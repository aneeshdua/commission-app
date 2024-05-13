package org.example;

import org.example.models.Affiliate;
import org.example.models.Order;
import org.example.models.Product;
import org.example.models.Transaction;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.enums.Categories.Furniture;
import static org.example.enums.Categories.Mobiles;
import static org.example.enums.CommissionType.FLAT_RATE;
import static org.example.enums.CommissionType.PERCENTAGE;
import static org.example.enums.OrderStatus.*;

public class Main {


    public static void main(String[] args) {

        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TransactionService transactionService = new TransactionService();
        AffiliateService affiliateService = new AffiliateService();
        ComissionMappingService comissionMappingService = new ComissionMappingService();

        comissionMappingService.addCommision(Mobiles, PERCENTAGE, (float) 10.0, null, (float) 1000.0);
        comissionMappingService.addCommision(Furniture, FLAT_RATE, null, (float)1000, null);
        productService.addProduct("pid1", Mobiles);
        productService.addProduct("pid2", Furniture);
        affiliateService.addAffiliate("af1","af1");
        OrderService.addOrder(productService,affiliateService,comissionMappingService,"order1", (float)600.00, "pid1", Mobiles, "af1", CREATED,"2024-05-05 11:11:11");
        OrderService.updateOrder("order1", DISPATCHED);
        OrderService.updateOrder("order1", DELIVERED);
        OrderService.updateOrder("order1", RETURN_PERIOD_EXPIRED);
        OrderService.addOrder(productService,affiliateService,comissionMappingService,"order2", (float)600.00, "pid2", Furniture, "af1", CREATED,"2024-05-05 11:11:11");
        OrderService.updateOrder("order2", DISPATCHED);
        OrderService.updateOrder("order2", DELIVERED);
        OrderService.updateOrder("order2", RETURN_PERIOD_EXPIRED);

        transactionService.getTransactionByAffiliateId("af1");
        List<Order> ordersByAffiliateAndStatus= orderService.getOrdersByAffiliateAndStatus("1",CREATED);




    }
}