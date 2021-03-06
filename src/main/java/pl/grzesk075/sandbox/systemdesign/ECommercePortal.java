package pl.grzesk075.sandbox.systemdesign;

import java.util.List;
import java.util.Map;

/**
 * We need modules: SQL DB, rest API, WebApp.
 * With microservices concept, model is in database, and is read and write with small rest requests
 * caused by customer browser events like clicking.
 * Actors (activity diagram):
 * ShopOwner caries out Shop
 * Customer buys Products
 * Customer uses Shop
 * Stock stores Products
 * Workers ship Products
 *
 * Data model:
 */
public class ECommercePortal {

    WebFramework customerAPI;
    List<CustomerAccount> customers;
    List<Product> products;
    Map<Product, StockInfo> product2StockInfo;
    //List<Cart> cart consists of Customer and Order
}

class CustomerAccount {
    long id;
    String firstName;
    String lastName;
    Address invoiceAddress;
    Address shippingAddress;
    String login;
    String encryptedPassword;
}

class Address {
}

class Price {
}

class Invoice {
}

class Shipping {
}

class WebFramework {
}

class StockInfo {
}

class Payment {
}


class Product {
    long id;
    Price price;
    float weight;
    //size
    String description;
}

class Order {
    long id;
    List<Product> products;
    Invoice invoice;
    Payment payment;
    CustomerAccount customer;
    Address shippingAddress;
}