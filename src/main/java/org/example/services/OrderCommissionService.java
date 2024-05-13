package org.example.services;

import org.example.models.Order;
import org.example.models.OrderCommissions;

import java.util.HashMap;
import java.util.List;

public class OrderCommissionService {

    static HashMap<String, OrderCommissions> commissionsHashMap = new HashMap<String, OrderCommissions>();
    public static void addOrderCommission(String orderId, OrderCommissions orderCommissions){
        commissionsHashMap.put(orderId,orderCommissions);
    }

//    public static Float getTotalCommissionByAffiliateId(OrderService orderService,String affiliateId){
//        Float totalCommission = 0.0f;
//        commissionsHashMap.forEach((key, value) -> {
//            orderService.getOrder()
//        });
//        for (Order order: orders){
//            OrderCommissions orderCommissions = commissionsHashMap.get(order.getOrderId());
//            totalCommission += orderCommissions.getAmount();
//        }
//        return totalCommission;
//    }

}
