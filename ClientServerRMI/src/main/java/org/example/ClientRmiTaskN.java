package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;


public class ClientRmiTaskN {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(8001);
        RmiCommandsInterface rmi = (RmiCommandsInterface) registry.lookup("productsRMI");

        // FIX TO STORE A LIST ON A SERVER
        ArrayList<Product> productStorage = new ArrayList<Product>();
        productStorage.add(new Product(1, "bread", "1231", "KievBread", 40, new Date(System.currentTimeMillis()), 30));
        productStorage.add(new Product(2, "tomato", "4345", "Tomatos", 50, new Date(System.currentTimeMillis()), 1000));
        productStorage.add(new Product(3, "tomatoses", "4335", "Tomatses", 50, new Date(System.currentTimeMillis()), 1000));


        System.out.println(rmi.filterByName("bread", productStorage));
        System.out.println(rmi.filterByPrice(60, productStorage));
        System.out.println(rmi.filterByShelfLife(new Date(System.currentTimeMillis()), productStorage));
    }
}