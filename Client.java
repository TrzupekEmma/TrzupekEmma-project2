import java.util.*;
import java.net.*;
import java.io.*;
public class Client{
	private Socket sock;
	private PrintWriter pw;
	private BufferedReader in;
	public Client(String localAdress, int port){
		try{
		sock = new Socket(localAdress,port);
		pw = new PrintWriter(sock.getOutputStream());           
      		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		}catch(Exception e){
            		System.err.println("Cannot Connect");
            		System.exit(1);
		}
	}
	public Socket getSocket(){
		return sock; 
	}
	public void disconnect(){ 
		try{            
           	in.close(); //close the input stream
		pw.close(); //close the stream
		sock.close();//close the soc
		}catch(Exception e){
			System.err.print("IOException");
            		System.exit(1);
		}
	}
	public void handshake(){
		try{
		pw.println("12345");
		pw.flush();
		}catch(Exception e){
			System.err.print("IOException");
            		System.exit(1);
		}
	}
	public String request(String s){return("unfinished method");}
}
