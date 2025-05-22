import java.io.*; 

import java.net.*; 

classTCPServer 

{

public static void main (String argv[]) throws Exception 

{ 

String fromclient; 

String toclient; 

ServerSocket Server = new ServerSocket (5000); 

System.out.println("TCPServerWaitingforclientonport5000"); 

while(true) 

{ 

Socket connected = Server.accept(); 

System.out.println("THECLIENT"+""+ 

connected.getInetAddress() +":"+connected.getPort()+" IS CONNECTED"); 

BufferedReaderin FromUser=new BufferedReader(new 

InputStreamReader(System.in)); 

BufferedReaderin FromClient=new 

BufferedReader(newInputStreamReader(connected.getInputStream())); 

PrintWriter outToClient=new 

PrintWriter(connected.getOutputStream(),true); 

while (true) { 

System.out.println("SEND (Type Q or q to Quit):"); 

toclient=inFromUser.readLine(); 

if ( toclient.equals ("q") || toclient.equals("Q") ) 

{ 

outToClient.println(toclient); 

connected.close(); 

break; 

} 

else 

{ 

outToClient.println(toclient); 

} 

fromclient = inFromClient.readLine(); 

if(fromclient.equals("q")||fromclient.equals("Q") ) { 

 

 connected.close(); 

break; 

}

else 

{ 

System.out.println("RECIEVED:" + fromclient ); 

} 

} 

} 

} 

}
