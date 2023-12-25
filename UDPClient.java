import java.io.*; 
import java.net.*; 

class UDPClient { 
  public static void main(String args[]) throws Exception { 
    DatagramSocket clientSocket = new DatagramSocket(); 
    InetAddress IPAddress = InetAddress.getByName("localhost"); 
    byte[] sendData = new byte[1024]; 
    byte[] receiveData = new byte[1024]; 

    String request = "Request Current Date and Time";
    sendData = request.getBytes();  
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
    clientSocket.send(sendPacket); 

    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
    clientSocket.receive(receivePacket); 
    String response = new String(receivePacket.getData()).trim(); 

    System.out.println("FROM SERVER: " + response); 
    clientSocket.close(); 
  } 
}
