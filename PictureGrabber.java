import java.io.*;
class PictureGrabber extends Thread
{
private XClient xClient;
private whatever serverAddress;
PictureGrabber(XClient xClient,whatever serverAddress)
{
System.out.println("Picture Grabber is instantiated.");
this.xClient=xClient;
this.serverAddress=serverAddress;
start();
}
public void run()
{
File file=new File("abcd.jpg");
while(true)
{
try
{
byte[] fileData=serverAddress.downloadFile();
//java.io.File f=serverAddress.getImageFile();
FileOutputStream fileOutputStream=new FileOutputStream(file.getName());
BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
bufferedOutputStream.write(fileData,0,fileData.length);
bufferedOutputStream.flush();
bufferedOutputStream.close();
xClient.setImage(file);
Thread.sleep(4000);
//xClient.deleteImageFile(file);
}catch(Exception exception)
{
System.out.println(exception+"-------");
}
}
}
}