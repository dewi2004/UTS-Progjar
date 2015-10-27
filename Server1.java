/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dewi.k
 */
public class Server1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        final int port = 6666;
        System.out.println("Server waiting for connection");
        ServerSocket ss = new ServerSocket(port);
        Socket clientsocket = ss.accept();
        System.out.println("Received connection from" +clientsocket.getInetAddress()+ "on port" + clientsocket.getPort());
        
        ReceiveFromClientThread receive = new ReceiveFromClientThread(clientsocket);
        
        Thread thread = new Thread((Runnable) receive);
        thread.start();
        
        SendToClientThread send = new SendToClientThread(clientsocket);
        
        Thread thread2 = new Thread(send);
        thread2.start();
        
// TODO code application logic here
    }    
}
