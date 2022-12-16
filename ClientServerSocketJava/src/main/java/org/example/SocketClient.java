package org.example;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SocketClient {

    public static void main(String[] args) throws Exception {
        System.out.println("Command and values :");
        try {
            Socket socket=new Socket("127.0.0.1",9998);

            ObjectInputStream inStream=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outStream=new ObjectOutputStream(socket.getOutputStream());

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String clientMessage="",clientParameter="";

            while(!clientMessage.equals("bye")) {
                System.out.println("Enter command:");
                clientMessage=br.readLine();

                if ("op1".equals(clientMessage)) {
                    outStream.writeObject(clientMessage);

                    System.out.println("Enter search (name):");
                    clientParameter = br.readLine();
                    outStream.writeObject(clientParameter);
                }

                outStream.flush();

                ArrayList<Product> products = (ArrayList<Product>) inStream.readObject();
                for(Product product: products) {
                    System.out.println(product);  // Will invoke overrided `toString()` method
                }
//                System.out.println(products);
            }

            outStream.close();
            outStream.close();
            socket.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
