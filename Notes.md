## Entities
Enum Categories - 4 categories

Product - ProductId,CategoryId

Affiliate - AfilliateId, Name

Order - OrderId, PRice, ProductId, categoryId(clothing,mobile,mobilecovers,furniture), afiiliateId,timestamp
API method to update order status


Commission Engine-  Rule based
1. percentage with a maxCap
2. flat-rate

* figure out which rule is applicable
  CommissionMapping - CategoryId, Percentage, FlatRate

Brokerage Payout Transaction:
Transaction - AffiliateId, TransactionId, List[OrderIds]

1. when return period expires then Payout

2. TransactionToAffiliate: Minimum of 100rs and then add transaction with uuid

4. Calculate brokerage at order created state

5. method for affiliate to get their deets using affiliateId

Bonus:
1. commision rules can change based on date
2. handle concurrent orders
3.  


addOrder()
updateOrder()
