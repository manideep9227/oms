# Getting Started
####OMS Service:
Exposed two apis to create an Order and retrieve order details 
- http://localhost:8080/oms/createNewOrder
 - Sample RequestBody
 - {
       "orderId": "1234",
       "customerName": "customer1",
       "orderDate": "2020-07-07",
       "shippingAddress": "Hyderabad",
       "orderItems":{
           "productCode": 12345,
           "productName": "Samsung Galaxy M31",
           "quantity":1
           },
       "totalOrders": 2
   }
 - http://localhost:8080/oms/getOrderInfo/{orderId} 
- Exposed two apis to create an Order Item and retrieve order Item details
- http://localhost:8080/oms/getOrderItemInfo/{productCode}
- http://localhost:8080/oms/createNewOrderItem
  - Sample Request Body
  - {
        "productCode": 12345,
        "productName": "Samsung Galaxy M31",
        "quantity":1
    }
- OMS Service will interact with Order-item-service to fetch and create Order Items via feignClient
####Order-Item-Service:
- Exposed two apis to create an Order Item and retrieve order Item details
- http://localhost:8081/oms/getOrderItemInfo/{productCode}
- http://localhost:8081/oms/createNewOrderItem
  - Sample Request Body
  - {
        "productCode": 12345,
        "productName": "Samsung Galaxy M31",
        "quantity":1
    }
