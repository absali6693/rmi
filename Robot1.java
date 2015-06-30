import java.awt.*;
import java.io.*;
import java.awt.image.*;
class Robot1
{
private File f=null;
Robot1()
{
System.out.println("Robot1 is instantiated.");
}
public File getScreenCapturedImage()
{
try
{
java.awt.Robot r=new java.awt.Robot();
java.awt.Dimension d=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
java.awt.Rectangle rect=new java.awt.Rectangle(d);
java.awt.image.BufferedImage bi=r.createScreenCapture(rect);
f=new java.io.File("screen.jpg");
javax.imageio.ImageIO.write(bi,"jpg",f);
}catch(Exception exception)
{
System.out.println(exception+">>>>>>>>>>");
}
return f;
}

}