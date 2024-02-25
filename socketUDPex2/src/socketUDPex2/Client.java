package socketUDPex2;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;
public class Client {
public static void main(String argv[])
{
	int port=0;
	String host="";
	try {
		//Demander de l'utilisateur le port d'ecoute du serveur
		Scanner keyb= new Scanner(System.in);
		System.out.println("Adresse du serveur : ");
		host= keyb.next();
		System.out.println("Port d'écoute du serveur : ");
		port = keyb.nextInt();
		
		
		// creation de l'objet Voiture
		Voiture voiture= new Voiture("BMW","X5");
		voiture.setCarburant(10);
		
		// Serialisation
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		ObjectOutputStream out= new ObjectOutputStream(bos);
		out.writeObject(voiture);
		out.flush();
		byte[] data= bos.toByteArray();
		
		//creation du paquet a envoyer
		InetAddress adr= InetAddress.getByName(host);
		DatagramPacket packet= new DatagramPacket(data,data.length,adr,port);
		
		
		// creation d'une socket et envoi du packet
		DatagramSocket socket=new DatagramSocket();
		socket.send(packet);
		
		
		System.out.println("objet voiture envoyé au serveur.");
		
		
		// fermeture dde la socket
		socket.close();
		
			}
	
	catch(Exception e)
	{
		System.err.println("Error : "+ e);
		
	}
}
}
