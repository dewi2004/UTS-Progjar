/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client1;

import java.net.Socket;

/**
 *
 * @author Dewi.k
 */
public class Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
	Socket sock = new Socket("localhost",6666);
	SendThread sendThread = new SendThread(sock);
	
        Thread thread = new Thread(sendThread);thread.start();
	RecieveThread recieveThread = new RecieveThread(sock);
	Thread thread2 =new Thread(recieveThread);thread2.start();
	} catch (Exception e) {System.out.println(e.getMessage());}
// TODO code application logic here
    }
    
}
