//UDPServer.java 

import java.io.*; 

import java.net.*: 

class UDPServer 

{

public static DatagramSocketserversocket; 

public static DatagramPacketdp; 

public static BufferedReaderdis; 

public static InetAddressia; 

public static bytebuf[]=newbyte[1024]; public static int cport=789,sport=790; 

public static void main(String[]a)throwsIOException 

{ 

serversocket=newDatagramSocket(sport); 

dp=newDatagramPacket(buf,buf.length); 

dis=newBufferedReader(newInputStreamReader(System.in)); 

ia=InetAddress.getLocalHost(); 

System.out.println("ServerisRunning..."); 

while(true) { 

serversocket.receive(dp); 

Stringstr=newString(dp.getData(),0,dp.getLength()); 

 if(str.equals("STOP")) 

{ 

System.out.println("Terminated..."); 

break; 

} 

System.out.println("Client: " + str); 

 Stringstr1=newString(dis.readLine()); 

buf=str1.getBytes(); 

serversocket.send(newDatagramPacket(buf,str1.length(),ia,cport)); 

} 

} 

}
