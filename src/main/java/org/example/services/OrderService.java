package org.example.services;

import org.example.enums.Categories;
import org.example.enums.OrderStatus;
import org.example.models.*;

import java.sql.Timestamp;
import java.util.*;

import static org.example.enums.CommissionType.PERCENTAGE;

public class OrderService {
    static HashMap<String, Order> orderList = new HashMap<String, Order>();

    public static void addOrder(ProductService productService, AffiliateService affiliateService, ComissionMappingService comissionMappingService, String orderId, Float Price, String productId, Enum<Categories> category, String affiliateId, Enum<OrderStatus> status, String orderDate){
        if (productService.checkIfExists(productId) && affiliateService.checkIfAffiliateExists(affiliateId)){
            Order order = new Order();
            order.setOrderId(orderId);
            order.setPrice(Price);
            order.setProductId(productId);
            order.setCategory(category);
            order.setAffiliateId(affiliateId);
            order.setOrderStatusEnum(status);
            order.setOrderDate(Timestamp.valueOf(orderDate));
            orderList.put(orderId,order);
        } else {
            System.out.println("ERROR: Product or Affiliate does not exist");
        }
        //calculte commission
        CommisionMapping commisionMapping = comissionMappingService.getCommisionMappingByCategory(category);
        OrderCommissions orderCommissions = new OrderCommissions();
        orderCommissions.setOrderId(orderId);
        Float commission = 0.0f;

        if (commisionMapping.getCommissionTypeEnum().equals(PERCENTAGE)){
            commission = Price * commisionMapping.getPercentage();
            if (commission > commisionMapping.getMaxCap()){
                commission = commisionMapping.getMaxCap();
            }

        } else {
            commission = commisionMapping.getFlatRate();
        }
        orderCommissions.setAmount(commission);
        OrderCommissionService.addOrderCommission(orderId,orderCommissions);
        AffiliateService.updateAffiliateBalance(affiliateId,commission);
    }


    public static boolean checkIfExists(String orderId){
        if (orderList.get(orderId) != null){
            return true;
        } else {
            return false;
        }
    }

    public static void updateOrder(String orderId, Enum<OrderStatus> status){
        if (checkIfExists(orderId)) {
            Order orderObj = orderList.get(orderId);
            orderObj.setOrderStatusEnum(status);
            orderList.put(orderId,orderObj);

            if (status.equals(OrderStatus.RETURN_PERIOD_EXPIRED)){
                OrderCommissions orderCommissions = OrderCommissionService.commissionsHashMap.get(orderId);
                System.out.println("Commission for order "+orderId+" is "+orderCommissions.getAmount());

                // get all order comissions to add to transaction entry
//                List<OrderCommissions> orderCommissionsList = OrderCommissionsService.com
//                check total amount if >100 then initiate transaction
                Float totalAmount = AffiliateService.getAffiliateById(orderObj.getAffiliateId()).getCommissionAmountTillDate();
                Float paidAmount = AffiliateService.getAffiliateById(orderObj.getAffiliateId()).getCommissionAmountPaidTillDate();
                Float transactionAmt = totalAmount - paidAmount;
                if (transactionAmt > 100){
                    Transaction newTransaction = new Transaction();
                    newTransaction.setAffiliateId(orderObj.getAffiliateId());
                    newTransaction.setTotalAmount(transactionAmt);
                    newTransaction.setTransactionId(UUID.randomUUID().toString());
                    TransactionService.addTransaction(newTransaction);
                    AffiliateService.getAffiliateById(orderObj.getAffiliateId()).setCommissionAmountPaidTillDate(transactionAmt);
                    System.out.println("Transaction for affiliate "+orderObj.getAffiliateId()+"of Rs "+transactionAmt+" paid!");
                }
            }
        } else {
            System.out.println("ERROR: Order does not exist");
        }
    }

    public List<Order> getOrdersByAffiliateAndStatus(String affiliateId, Enum<OrderStatus> statusEnum) {
        List<Order> resultOrders = new ArrayList<Order>();
        for (Map.Entry<String, Order> entry : orderList.entrySet()) {
            Order orderEntry = entry.getValue();
            if (orderEntry.getAffiliateId().equals(affiliateId) && orderEntry.getOrderStatusEnum().equals(statusEnum)){
                resultOrders.add(orderEntry);
            }
        }
        return resultOrders;
    }
}
