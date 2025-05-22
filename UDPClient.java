//UDPClient.java 

import java.io.*; import java.net.*: 

class UDPClient 

{ 

public static DatagramSocketclientsocket; 

public static DatagramPacketdp; 

public static BufferedReaderdis; public static InetAddressia; 

public static bytebuf[]=newbyte[1024]; public static intcport=789,sport=790; 

public static void main (String [] a) throws IOException 

{ 

clientsocket=newDatagramSocket(cport); dp=newDatagramPacket(buf,buf.length);

dis = new BufferedReader(newInputStreamReader(System.in)); 

ia=InetAddress.getLocalHost(); 

System.out.println("Client is Running... Type 'STOP' to quit"); 

while(true) 

{ 

String str=new String(dis.readLine()); 

buf = str.getBytes(); if(str.equals("STOP")) 

{ 

System.out.println("Terminated..."); 

clientsocket.send(new DatagramPacket(buf,str.length(), ia,sport)); 

break; 

} 

clientsocket.send(new DatagramPacket(buf,str.length(),ia,sport)); 

clientsocket.receive(dp); 

Stringstr2=newString(dp.getData(),0,dp.getLength()); 

System.out.println("Server:"+str2); 

} 

}}
