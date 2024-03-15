import java.io.*;
import java.net.*;
class udps
{
public static void main(String args[])
{
DatagramSocket ds=null;
DatagramSocket dp=null,reply;

try
{
ds=new DatagramSocket(1234);
byte[]buffer=new byte[1000];
dp=new DatagramPacket(buffer,buffer.length);
ds.receive(dp);

System.out.println("from client: " +(new String(dp.getData())).trim());
reply=new DatagramPacket("from server ok".getBytes(),"from server ok".length(),dp.getAddress(),dp.getPort());
ds.send(reply);
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
ds.close();
}
}
}
