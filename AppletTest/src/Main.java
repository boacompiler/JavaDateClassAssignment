import java.awt.*;
import javax.swing.*;


public class Main extends JApplet // errors for some silly eclipse reason
{
	private double sum;
	
	public void init()
	{
		String n1 = JOptionPane.showInputDialog("Enter first number: ");
		String n2 = JOptionPane.showInputDialog("Enter second number: ");
		
		sum = Double.parseDouble(n1) + Double.parseDouble(n2);
		
		//String a = JOptionPane.showMessageDialog(sum + " a", sum + " b");
		
	}
	
	public void paint (Graphics g)
    {
        super.paint(g);
        g.drawString(sum + "", 25, 25);
    }

}
