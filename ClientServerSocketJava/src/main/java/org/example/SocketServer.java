package org.example;
import java.net.*;
import java.io.*;
import java.util.Date;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    int squre;

    ProductStorage productStorage;

    ServerClientThread(Socket inSocket,int counter, ProductStorage productStorage){
        serverClient = inSocket;
        clientNo = counter;
        this.productStorage = productStorage;
    }
    public void run(){
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(serverClient.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(serverClient.getInputStream());
            outStream.flush();

            String clientCommand="", clientParameter="";
            while(!clientCommand.equals("bye")){
                clientCommand=inStream.readObject().toString();
                if ("op1".equals(clientCommand)) {
                    clientParameter=inStream.readObject().toString();
                    System.out.println(productStorage.filterByName(clientParameter));
                    outStream.writeObject(productStorage.filterByName(clientParameter));
                }
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}

public class SocketServer {
    public static void main(String[] args) {

        try {
            ServerSocket server=new ServerSocket(9998);
            int counter=0;
            System.out.println("Server Started ....");

            ProductStorage productStorage = new ProductStorage();
            productStorage.addProduct(new Product(1, "bread", "1231", "KievBread", 40, new Date(System.currentTimeMillis()), 30));
            productStorage.addProduct(new Product(2, "tomato", "4345", "Tomatos", 50, new Date(System.currentTimeMillis()), 1000));
            productStorage.addProduct(new Product(3, "tomatoses", "4335", "Tomatses", 50, new Date(System.currentTimeMillis()), 1000));

            while(true) {
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter,productStorage); //send  the request to a separate thread
                sct.start();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}