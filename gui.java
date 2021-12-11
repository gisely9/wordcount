package application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Date : 19/11/2021 
 * Creating a constructor(GUI) that will push a text from the WebSite  and displays top 10 words 
 * @author GISELE 
 *
 *  
 */

public class gui<Private> implements ActionListener {
	
	// Creating a frame(object) which is a window used in a GUI 
	// Creating a panel (object) which is a container class 
	// Creating a label(object) where words will be placed in a container 
	// Creating a Hyperlink (object) where a WebSite  URL will be placed 
	
	
	private int count = 0;
	private JLabel label;
	private JFrame frame ;
	private JPanel panel ;
	Private JHyperlink;
	/**
	 * Creating a frame and button where words will be stored 
	 */
	
	public gui () {
		
		  frame = new JFrame ();
		
		  JButton button = new JButton ("Click me");
		  button.addActionListener(this);
		
		  label   =   new JLabel("Number of clicks :0");
		  
	// Creating a border object using borderFactory 	
		
	    panel = new JPanel ();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		
		String str = ("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		try {
			new URI (str);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	    panel.setLayout(new GridLayout(0,1));
	    panel.add(button);
	    panel.add(label);
		
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("OUR GUI");
	    frame.pack();
	    frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		

	}
	
 

	@Override
	public void actionPerformed(ActionEvent e) {
		count ++;
		label.setText("Number of clicks: " + count); 
		
	}

}



	
			 