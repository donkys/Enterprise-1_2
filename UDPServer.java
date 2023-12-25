import java.io.*; 
import java.net.*; 
import java.text.SimpleDateFormat;
import java.util.Date;

class UDPServer { 
  public static void main(String args[]) throws Exception { 
    DatagramSocket serverSocket = new DatagramSocket(9876);
    byte[] receiveData = new byte[1024]; 
    byte[] sendData  = new byte[1024];

    while(true) { 
      System.out.println("The server is waiting for client request...");
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
      serverSocket.receive(receivePacket);

      InetAddress IPAddress = receivePacket.getAddress(); 
      int port = receivePacket.getPort(); 

      String currentDateAndTime = getCurrentDateAndTime();
      sendData = currentDateAndTime.getBytes(); 
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
      serverSocket.send(sendPacket); 
    } 
  } 

  private static String getCurrentDateAndTime() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    return formatter.format(date);
  }
}
