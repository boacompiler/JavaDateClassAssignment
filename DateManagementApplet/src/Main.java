import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JApplet
{

	DateManager myDateManager;
	
	Panel controlPanel;
	Label labelDescriptor;
	
	Button buttonValidate;
	Button buttonSetDate;
	Button buttonGetEuropean;
	Button buttonGetAmerican;
	Button buttonGetInternational;
	Button buttonLeapYear;
	Button buttonDayName;
	
	JTextField textBoxNewYear;
	JTextField textBoxNewMonth;
	JTextField textBoxNewDay;
	
	public void init()
	{
		myDateManager = new DateManager(1994,11,4);//TODO which constructor, who knows?
		controlPanel = new Panel();
		controlPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		labelDescriptor = new Label("Year");
		c.fill = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		controlPanel.add(labelDescriptor, c);
		labelDescriptor = new Label("Month");
		c.fill = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 0;
		controlPanel.add(labelDescriptor, c);
		labelDescriptor = new Label("Day");
		c.fill = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 0;
		controlPanel.add(labelDescriptor, c);
		
		textBoxNewYear = new JTextField(4);
		c.fill = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		controlPanel.add(textBoxNewYear, c);
		textBoxNewMonth = new JTextField(2);
		c.fill = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 1;
		controlPanel.add(textBoxNewMonth, c);
		textBoxNewDay = new JTextField(2);
		c.fill = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 1;
		controlPanel.add(textBoxNewDay, c);
		
		buttonValidate = new Button("Check Valid");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		buttonValidate.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //TODO input validation
	        	 JOptionPane.showMessageDialog(null, myDateManager.validDate(Integer.valueOf(textBoxNewYear.getText()), Integer.valueOf(textBoxNewMonth.getText()), Integer.valueOf(textBoxNewDay.getText())));
	          }
	       });
		controlPanel.add(buttonValidate, c);
		
		buttonSetDate = new Button("Set Date");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		buttonSetDate.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	//TODO try/catch
	        	 myDateManager.setYear(Integer.valueOf(textBoxNewYear.getText()));
	        	 myDateManager.setMonth(Integer.valueOf(textBoxNewMonth.getText()));
	        	 myDateManager.setDay(Integer.valueOf(textBoxNewDay.getText()));
	          }
	       });
		controlPanel.add(buttonSetDate, c);
		
		labelDescriptor = new Label("Return Date As:");
		c.fill = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		controlPanel.add(labelDescriptor, c);

		buttonGetEuropean = new Button("European");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		buttonGetEuropean.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 JOptionPane.showMessageDialog(null, myDateManager.europeanString());
	          }
	       });
		controlPanel.add(buttonGetEuropean, c);
		
		buttonGetAmerican = new Button("American");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		buttonGetAmerican.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //TODO add optional initials?
	        	 JOptionPane.showMessageDialog(null, myDateManager.americanString());
	          }
	       });
		controlPanel.add(buttonGetAmerican, c);
		
		buttonGetInternational = new Button("International");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		buttonGetInternational.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 JOptionPane.showMessageDialog(null, myDateManager.internationalString());
	          }
	       });
		controlPanel.add(buttonGetInternational, c);
		
		buttonLeapYear = new Button("Check Leap Year");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		buttonLeapYear.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 JOptionPane.showMessageDialog(null, myDateManager.leapYear(myDateManager.getYear()));
	          }
	       });
		controlPanel.add(buttonLeapYear, c);
		
		buttonDayName = new Button("Check Week Day");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		buttonDayName.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 JOptionPane.showMessageDialog(null, myDateManager.dayName(myDateManager));
	          }
	       });
		controlPanel.add(buttonDayName, c);
		//TODO JOptionPane.showMessageDialog(null, "Init complete");
		
		add(controlPanel);
	}
	
}
