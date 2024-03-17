# Anagram Finder - instructions to execute

## Prerequisite software
1) JDK 17
2) Maven 3+

## Shopping Cart
1) Open/Import ShoppingCart project in IDE.
2) Make sure the maven build is fine with no compilation issues

## Instructions to run the application
- ShoppingCartApplication.java - the main application which takes item list as command line arguments.
   for ex-  java com.shopping.cart.main.app.ShoppingCartApplication "Apple,Banana,Melon,Melon,Melon,Melon,Lemon"
- Run/Debug - ShoppingCartApplication.java - with item list as program arguments.

### Design considerations / Improvements / Better design
- Each Shop Item and its configuration is declared as Enum constant in the code.
- Master list of items like (Apple, Banana..) and its configuration can be externalized in application.properties for better extendable and maintable code.
