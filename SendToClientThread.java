/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Dewi.k
 */
class SendToClientThread implements Runnable
{
    PrintWriter pwPrintWriter;
	Socket clientSock = null;
    private Object messageString;
	
	public SendToClientThread(Socket clientSock)
	{
		this.clientSock = clientSock;
	}
	public void run() 
        {
		try{
		pwPrintWriter = new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
		
                while(true)
		{
			String msgToClientString = null;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput
			
                        msgToClientString = input.readLine();//get message to send to client
			
			pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
			
                        //pwPrintWriter.println("helow");
                        pwPrintWriter.flush();//flush the PrintWriter
			//System.out.println("Please enter something to send back 1 to client..");
                        
                
                }//end while
		}
		catch(Exception ex){System.out.println(ex.getMessage());}	
	}
}
