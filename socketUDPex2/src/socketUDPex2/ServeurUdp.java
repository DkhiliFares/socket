package socketUDPex2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
public class ServeurUdp {
public static void main(String[]args)
{
	DatagramSocket socket=null;
	
	
	try
	{
		socket=new DatagramSocket(1250);
		System.out.println("serveur udp sur le port 1250");
		
		
		while(true)
		{
			byte[] buf= new byte[1024];
			DatagramPacket receivePacket=new DatagramPacket(buf,buf.length);
			
			
			
			socket.receive(receivePacket);
			InetAddress clientAddress= receivePacket.getAddress();
			int clientPort= receivePacket.getPort();
			
			
			String dateTime= new Date().toString();
			byte[] sendData= dateTime.getBytes();
			
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
			
			socket.send(sendPacket);
			System.out.println("date et heure envoyées à"+clientAddress+":"+clientPort);
					}
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally {
		if(socket!= null) socket.close();
	}
}
}
