import java.io.*; 

import java.net.*; 

class TCPClient 

{ 

public static void main (String argv[]) throws Exception 

{ 

String FromServer; 

String ToServer; 

Socket clientSocket = new Socket ("localhost", 5000); 

BufferedReaderin FromUser=new BufferedReader(newInputStreamReader(System.in)); 

PrintWriterout ToServer=new PrintWriter(clientSocket.getOutputStream(),true); 

BufferedReaderin FromServer=new BufferedReader(new 

InputStreamReader(clientSocket.getInputStream())); 

while (true) 

{ 

FromServer=inFromServer.readLine(); 

if(FromServer.equals("q")||FromServer.equals("Q")) 

{ 

clientSocket.close(); 

break; 

} 

else 

{ 

System.out.println("RECIEVED:" + FromServer); 

System.out.println("SEND (Type Q or q to Quit):"); 

ToServer=inFromUser.readLine(); 

if(ToServer.equals("Q")||ToServer.equals("q"))

{ 

outToServer.println(ToServer); 

clientSocket.close(); 

break; 

} 

else 

{ 

outToServer.println(ToServer); 

} 

} 

} 

} 

}
