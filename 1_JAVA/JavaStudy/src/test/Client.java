package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		int port =3000;
		String serverIP;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			try {
				Socket socket = new Socket(serverIP,port);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
