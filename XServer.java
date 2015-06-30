import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
import java.io.*;
interface whatever extends Remote
{
public File getImageFile() throws RemoteException;
public byte[] downloadFile() throws RemoteException;
}
class XServer extends UnicastRemoteObject implements whatever
{
private boolean isReady=false;
//private ClientInterface clientAddress;
private Robot1 r;
XServer() throws RemoteException
{
System.out.println("Server object created.");
r=new Robot1();
}
public File getImageFile()
{
File f=r.getScreenCapturedImage();
System.out.println("Server side-getImageFile() got called.");
isReady=true;
return f;
}




public byte[] downloadFile()
{
try
{
File file=r.getScreenCapturedImage();
byte buffer[] = new byte[(int)file.length()];
BufferedInputStream input = new BufferedInputStream(new FileInputStream(file.getName()));
input.read(buffer,0,buffer.length);
input.close();
return buffer;
}catch(Exception e)
{
System.out.println("FileImpl: "+e.getMessage());
return(null);
}
}



public static void main(String ggp[])
{
try
{
XServer xServer=new XServer();
Naming.bind("lionKing",xServer);
}catch(Exception exception)
{
System.out.println(exception+"*********");
}
}
}