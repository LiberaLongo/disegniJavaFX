package dimensioni;
import java.awt.Dimension;
import java.awt.Toolkit;
public class ScreenSize {
public static void main(String[] args)
{
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
System.out.println("Screen Widht: " + screenSize.getWidth());
System.out.println("Screen Height: " + screenSize.getHeight());
}
}
