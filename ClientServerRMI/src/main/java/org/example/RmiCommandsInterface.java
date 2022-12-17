package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

interface RmiCommandsInterface extends Remote {
    ArrayList<Product> filterByName(String name, ArrayList<Product> products) throws RemoteException;
    ArrayList<Product> filterByPrice(int price, ArrayList<Product> products) throws RemoteException;
    ArrayList<Product> filterByShelfLife(Date date, ArrayList<Product> products) throws RemoteException;
}