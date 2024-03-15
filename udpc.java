import java.io.*;
import java.net.*;
class udpc
{
public static void main(String args[])
{
DatagramSocket ds=null;
DatagramSocket dp=null,reply=null;
InetAddress shost=null;

try
{
ds=new DatagramSocket();
byte[]="Byte".getBytes();
shost=InetAddress("localhost");
byte[]buffer=new byte[1000];
reply=new DatagramPacket(buffer,buffer.length);
ds.receive(reply);

System.out.println("reply:  " +(new String(reply.getData())).trim());

}


catch(SocketException e)
{
System.out.println("socket"+ e.getMessage());
}
catch(Exception e)
{
System.out.println("io"+ e.getMessage());
}
finally
{
if(ds!=null)
ds.clear();
}
}
