import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;


public class Main extends JApplet implements ActionListener // errors for some silly eclipse reason
{
	private double sum;
	Button button1;
	
	public void init()
	{
		String n1 = JOptionPane.showInputDialog("Enter first number: ");
		String n2 = JOptionPane.showInputDialog("Enter second number: ");
		
		button1 = new Button("Button 1");
		button1.setSize(100, 25);
		button1.setLabel("this is a button");
		add(button1);
		button1.addActionListener(this);
		
		sum = Double.parseDouble(n1) + Double.parseDouble(n2);
		
		//String a = JOptionPane.showMessageDialog(sum + " a", sum + " b");
		
	}
	
	public void paint (Graphics g)
    {
        super.paint(g);
        g.drawString(sum + " poop", 25, 25);
    }
	
	public void actionPerformed(ActionEvent e) 
	{
		String n1 = JOptionPane.showInputDialog("button worked");
	}


}
