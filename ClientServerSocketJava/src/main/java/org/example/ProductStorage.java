package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductStorage {
    List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> filterByName(String name) {
        var result = new ArrayList<Product>();

        for (Product product: products) {
            if (product.name.contains(name)) {
                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Product> filterByPrice(int price) {
        var result = new ArrayList<Product>();

        for (Product product: products) {
            if (product.price < price) {
                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Product> filterByShelfLife(Date date) {
        var result = new ArrayList<Product>();

        for (Product product: products) {
            if (date.before(product.shelfLife)) {
                result.add(product);
            }
        }

        return result;
    }


}
