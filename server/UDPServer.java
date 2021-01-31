import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket sersock = new DatagramSocket(9876);
		System.out.println("Server Started on Port 9876");
		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while(true)
		{
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			sersock.receive(receivePacket);
			receivePacket.getData();
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			System.out.println("Client Connected");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the message to be sent: ");
			String message = input.readLine();
			sendData = message.getBytes();
			DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);
			sersock.send(sendPacket);
			System.exit(0);
		}
	}
}