import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;


public class Main extends JApplet //implements ActionListener // errors for some silly eclipse reason
{
	private double sum;
	Button button1;
	Button button2;
	Label label1;
	Frame mainFrame;
	Panel controlPanel;
	
	JTextField txtbx;
	
	public void init()
	{
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
      
      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      //controlPanel.setLayout(new GridBagLayout());
		//String n1 = JOptionPane.showInputDialog("Enter first number: ");
		//String n2 = JOptionPane.showInputDialog("Enter second number: ");
		
		button1 = new Button("Button 1");
		button1.setSize(100, 25);
		button1.setLabel("this is a button");
		
		button1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 String n1 = JOptionPane.showInputDialog("button worked");
	          }
	       });
		
		button2 = new Button("Button 1");
		button2.setSize(100, 25);
		button2.setLabel("this is another button");
		
		button2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 label1.setText(txtbx.getText());
	          }
	       });
		
		label1 = new Label("this is a label");
		
		txtbx = new JTextField(20);
		
		controlPanel.add(button1,"Center");
		controlPanel.add(label1);
		controlPanel.add(button2,"South");
		controlPanel.add(txtbx);
		add(controlPanel);
		//mainFrame.add(controlPanel);
		//mainFrame.setVisible(true); 
		//sum = Double.parseDouble(n1) + Double.parseDouble(n2);
		
		//String a = JOptionPane.showMessageDialog(sum + " a", sum + " b");
		
	}
	
	public void paint (Graphics g)
    {
        super.paint(g);
        g.drawString(sum + " poop", 25, 25);
    }
	
//	public void actionPerformed(ActionEvent e) 
//	{
//		String n1 = JOptionPane.showInputDialog("button worked");
//	}


}
