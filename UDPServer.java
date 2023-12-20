//UDPServer.java
import java.util.Date; 
import java.net.*;
import java.text.SimpleDateFormat;
  
class UDPServer { 
    public static void main(String args[]) throws Exception { 
        DatagramSocket serverSocket = new DatagramSocket(1667); 
        byte[] receiveData = new byte[1024]; 
        byte[] sendData  = new byte[1024];
        while(true) { 
            System.out.println("The server is waiting ");

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            serverSocket.receive(receivePacket);

            InetAddress IPAddress = receivePacket.getAddress(); 
            int port = receivePacket.getPort();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            String dateTime = dateFormat.format(new Date());

            sendData = dateTime.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        } 
    } 
}  