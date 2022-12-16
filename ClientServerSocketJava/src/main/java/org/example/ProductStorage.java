package org.example;

import java.util.ArrayList;
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

        System.out.println(result);

//        Product[] arr = new Product[result.size()];
        return result;
    }

//    @Override
//    public String toString() {
//        return this.re + " + " + this.im + "i";
//    }
}
