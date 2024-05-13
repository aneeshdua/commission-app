package org.example.services;

import org.example.models.Order;
import org.example.models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionService {
    static HashMap<String, List<Transaction>> transactionList = new HashMap<String, List<Transaction>>();

    public static void addTransaction(Transaction transaction){
        List<Transaction> transactions =  transactionList.get(transaction.getAffiliateId());
        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
        }
        transactions.add(transaction);
        transactionList.put(transaction.getAffiliateId(), transactions);
    }

    public List<Transaction> getTransactionByAffiliateId(String affiliateId){
        return transactionList.get(affiliateId);
    }
}
