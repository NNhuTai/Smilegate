# Smilegate
# Project tree
* [src](./src)
  * [main](./src/main)
    * [java](./src/main/java)
      * [config](./src/main/java/com/example/smilegate/config)
      * [controllers](./src/main/java/com/example/smilegate/controller)
      * [model](./src/main/java/com/example/smilegate/model)
      * [repos](./src/main/java/com/example/smilegate/repos)
      * [response](./src/main/java/com/example/smilegate/responses)
      * [security](./src/main/java/com/example/smilegate/security)
      * [service](./src/main/java/com/example/smilegate/services)
      * [mainClass](./src/main/java/com/example/smilegate/SmilegateApplication.java)
    * [resource](./src/main/resources)
      * [properties](./src/main/resources/application.properties)
  * [test](./src/test)
      * [service](./src/test/java/com/example/smilegate/services)
* [README.md](./README.md)
* [pom.xml](./pom.xml)
* [Diagram](./Database_table_Digram.png)

# Guideline to run the application on local computer.
- Create SQL Server Database:  `CREATE DATABASE Smilegate`
- After start application.
- To Create user Call API: POST -> `http://localhost:8080/user/register` with body
  - ```yaml
    {
      "name":"tai",
      "pass":"123",
      "role": ["ADMIN"]
    }
- After we have user with `ADMIN` role: 
We need to add basic Authorization:
- username: `tai` and password: `123`
- Call POST -> `http://localhost:8080/customer/create/{tai}` to create customer
- Call POST -> `http://localhost:8080/game/create` with body
- ```yaml 
  {
    "name": "Sniper Fury 4",
    "price": 6,
    "categoryId": 1
  } 
- to create game Product.
- Call POST -> `http://localhost:8080/order/create` with body 

  - ```yaml
    {
       "customerId": 1,
       "gameIds": [1]
    }
  
to create Order.
- Call GET -> `http://localhost:8080/order/get/{oderId}` to get Order Detail
* Sample response with request `http://localhost:8080/order/get/1`
- ```yaml 
  {
    "id": 1,
    "name": "Order 01",
    "customerId": 1,
    "ordered": true,
    "pay": true,
    "total": 6,
    "listGame": [
        {
            "id": 3,
            "name": "Sniper Fury 3",
            "categoryId": 1,
            "price": 4
        },
        {
            "id": 2,
            "name": "Sniper Fury 2",
            "categoryId": 1,
            "price": 2
        }
    ]
  }
- We call API: ```http://localhost:8080/order/update``` to update new game List
- ```yaml
  {
    "id": "1", 
    "gameIds": [1, 2]
  }
- We call API: `http://localhost:8080/order/addGame` to add new game to game list
- ```yaml
  {
    "id": "1", 
    "gameIds": [1, 2]
  }
- We call API: `http://localhost:8080/order/deliver` to update order `Status`: [delivered or not]
- ```yaml
  {
    "id": "1"
  }
- We call API: `http://localhost:8080/order/pay` to update payment `Status`: [pay or not]
- ```yaml
  {
    "id": "1"
  }
- ![alt text](Database_table_Digram.png)