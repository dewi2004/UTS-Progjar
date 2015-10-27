/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Dewi.k
 */
class ReceiveFromClientThread implements Runnable
{
    	Socket clientsocket=null;
	BufferedReader brBufferedReader = null;
	
	public ReceiveFromClientThread(Socket clientsocket)
	{
		this.clientsocket = clientsocket;
	}//end constructor
            @Override
           public void run() 
           {
		try{
		brBufferedReader = new BufferedReader(new InputStreamReader(this.clientsocket.getInputStream()));		
		
		String messageString;
		while(true){
		while((messageString = brBufferedReader.readLine())!= null){//assign message from client to messageString
			if(messageString.equals("EXIT"))
			{
				break;//break to close socket if EXIT
			}
			System.out.println("From Client: " + messageString);//print the message from client
			//System.out.println("Please enter something to send back 2 to client..");
                        
                }
		this.clientsocket.close();
		System.exit(0);
                        }
                }
	catch(Exception ex){System.out.println(ex.getMessage());}
	}
}
