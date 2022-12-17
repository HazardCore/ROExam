package org.example;


import java.rmi.server.*;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

class RmiCommands extends UnicastRemoteObject implements RmiCommandsInterface {

    public RmiCommands() throws RemoteException {
        super();
    }


    public ArrayList<Product> filterByName(String name, ArrayList<Product> products) throws RemoteException {
        ArrayList<Product> result = new ArrayList();
        Iterator var3 = products.iterator();

        while(var3.hasNext()) {
            Product product = (Product)var3.next();
            if (product.name.contains(name)) {
                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Product> filterByPrice(int price, ArrayList<Product> products) throws RemoteException {
        ArrayList<Product> result = new ArrayList();
        Iterator var3 = products.iterator();

        while(var3.hasNext()) {
            Product product = (Product)var3.next();
            if (product.price < price) {
                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Product> filterByShelfLife(Date date, ArrayList<Product> products) throws RemoteException {
        ArrayList<Product> result = new ArrayList();
        Iterator var3 = products.iterator();

        while(var3.hasNext()) {
            Product product = (Product)var3.next();
            if (date.before(product.shelfLife)) {
                result.add(product);
            }
        }

        return result;
    }
}