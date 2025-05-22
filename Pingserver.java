//Pingserver.java 

import java.io.*; 

import java.net.*; 

class pingserver 

{ 

public static void main (String args[]) 

{ 

try 

{ 

String str; 

System.out.print(" Enter the IP Address to be Ping: "); 

BufferedReader buf1=new BufferedReader(new 

InputStreamReader(System.in)); 

String ip=buf1.readLine();

Runtime H=Runtime.getRuntime(); 

Process p=H.exec("ping " + ip); 

InputStream in=p.getInputStream(); 

BufferedReader buf2=new BufferedReader(new 

InputStreamReader(in)); 

 while((str=buf2.readLine())!=null) 

{ 

System.out.println(" " + str); 

} } 

catch (Exception e) 

{ 

System.out.println(e.getMessage()); 

} } }
/* OUTPUT: 

S:\ping> java pingserver 

Enter the IP Address to be Ping:172.16.17.9 

Pinging 172.16.17.9 with 32 bytes of data: 

Replyfrom172.16.17.9:bytes=32time<1msTTL=64Replyf

rom172.16.17.9:bytes=32time<1msTTL=64Replyfrom17

2.16.17.9:bytes=32time<1msTTL=64Replyfrom172.16.1

7.9:bytes=32time<1msTTL=64 

Ping statistics for 172.16.17.9: 

Packets: sent = 4, Received = 4, Lost = 0 (0% loss), 

Approximate round trip times in milli-seconds: 

Minimum=0ms, Maximum= 0ms, Average =0ms */
