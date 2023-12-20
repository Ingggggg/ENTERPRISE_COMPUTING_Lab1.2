//UDPClient.java
import java.net.*;
import java.util.*;

class UDPClient { 
    public static void main(String args[]) throws Exception { 
        Scanner inFromUser = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket(); 

        InetAddress IPAddress = InetAddress.getByName("localhost"); 

        byte[] sendData = new byte[1024]; 
        byte[] receiveData = new byte[1024];

        System.out.print("Press Enter to request current date and time from the server: ");
        inFromUser.nextLine();

        sendData = new byte[0];

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1667); 
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
        clientSocket.receive(receivePacket);

        String serverDateTime = new String(receivePacket.getData()).trim();
        System.out.println("Server date and time: " + serverDateTime);
    }
} 