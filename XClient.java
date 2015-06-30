import java.awt.*;
import java.rmi.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class XClient
{
private JFrame jFrame;
private JLabel lbl;
private Container c;
private PictureGrabber pg;
private whatever serverAddress;
private File f;
XClient()
{
System.out.println("XClient is instantiated.");
lbl=new JLabel("Wait...");
initComponents();
}
public void initComponents()
{
lookupServer();

pg=new PictureGrabber(this,serverAddress);

jFrame=new JFrame();
c=jFrame.getContentPane();
c.setLayout(new BorderLayout());
//lbl=new JLabel();
c.add(lbl,BorderLayout.CENTER);
jFrame.setSize(800,750);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
jFrame.setLocation(20,30);
jFrame.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we)
{
we.getWindow().dispose();
}
});
jFrame.setVisible(true);
setLabel();
}
public void setLabel()
{
while(true)
{
try{
Thread.sleep(1000);
this.lbl.setIcon(new ImageIcon(f.getName()));
}catch(Exception e)
{
}

}
}
public void deleteImageFile(File f)
{
System.out.println("Client Side- deleteImageFile() got called.");
try
{
this.f=f;
this.f.delete();
}catch(Exception exception)
{
System.out.println(exception);
}
if(f.exists()==false)
{
System.out.println("File deleted.");
}
}
public void lookupServer()
{
try
{
serverAddress=(whatever)Naming.lookup("rmi://localhost/lionKing");
}catch(Exception exception)
{
System.out.println(exception+"+++++++++");
System.exit(0);
}
}
public static void main(String ggg[])
{
XClient xClient=new XClient();
}
public void setImage(File f)
{
System.out.println("setImage got called.");
this.f=f;
}
}