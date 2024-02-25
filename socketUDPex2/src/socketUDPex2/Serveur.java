package socketUDPex2;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Scanner;
public class Serveur {
	public static void manin(String argv[])
	{
		int port=0;
		try
		{
			Scanner keyb= new Scanner(System.in);
			System.out.println("port d'écoute : ");
			port=keyb.nextInt();
			
			DatagramSocket socket= new DatagramSocket(port);
			
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			
			socket.receive(packet);
			
			
			ByteArrayInputStream bis= new ByteArrayInputStream(data);
			ObjectInputStream in= new ObjectInputStream(bis);
			Voiture voiture= (Voiture)in.readObject();
			//affichage des informations de la voiture recue
			System.out.println("Voiture reçue : ");
			System.out.println("Quantité de carburant: "+ voiture.getCarburant());
			
			
			//Réponse au client
			String reponse= "Objet Voiture reçu";
		    byte[] reponseData=reponse.getBytes();
		    DatagramPacket reponsePacket= new DatagramPacket(reponseData,reponseData.length,packet.getAddress(),packet.getPort());
		    socket.send(reponsePacket);
		    
		    //fermeture de la socket
		    socket.close();
		    
			
			
		}
		catch (Exception e)
		{
			System.err.println("Error"+e);
			
		}
	}
	
	
	
	

}
