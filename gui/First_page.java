package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class First_page extends JFrame implements ActionListener
{
	JPanel panel;
	
	JLabel label_wlc=new JLabel();
	JLabel label_space1=new JLabel();
	JLabel label_cnv1=new JLabel();
	JLabel label_cnv2=new JLabel();
	JLabel label_cnv3=new JLabel();
	JLabel label_cnv4=new JLabel();
	JTextField text_cnv = new JTextField(40);
	JLabel label_strm=new JLabel();
	JTextField text_strm = new JTextField(40);
	JLabel label_itrt=new JLabel();
	JTextField text_itrt = new JTextField(40);
	JLabel label_bck=new JLabel();
	JTextField text_bck = new JTextField(40);
	JLabel label_num_net=new JLabel();
	JTextField text_num_net = new JTextField(40);
	JLabel label_srv_cls=new JLabel();
	JTextField text_srv_cls = new JTextField(40);
	JLabel label_space2=new JLabel();
	JButton BUT_NTW = new JButton("Save and go to next page to enter network parameters");
	
	First_page()
	{
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}
	public void display()
	{
		label_wlc.setText("Hi! You have reached a wi-fi hotspot. Kindly enter the required parameters to select your network.");
		label_space1.setText("            ");
		label_cnv1.setText("For the Conversational class, enter the three priority vectors:");
		label_cnv2.setText("The first(4X1) for access network type(ant), with the values separated by spaces and ending with a semicolon.");
		label_cnv3.setText("The 2nd(3X1) for the relative importance of ant, roaming and internet connectivity, with same procedure.");
		label_cnv4.setText("The 3rd(2X1) for the relative importance of cost per byte and security. (Sample Input:.43 .22 .22 .13;.42 .34 .24;.67 .33)");
		label_strm.setText("Similarly, for the Streaming class, enter the three priority vectors:");
		label_itrt.setText("Similarly, for the Interactive class, enter the three priority vectors:");
		label_bck.setText("Similarly, for the Background class, enter the three priority vectors:");
		label_num_net.setText("Enter the number of networks available:");
		label_srv_cls.setText("Enter the running service class (Allowed inputs:Background, Streaming, Interactive or Conversational)");
		label_space2.setText("                    ");
		
		panel=new JPanel(new GridLayout(19,1));
		panel.add(label_wlc);
		panel.add(label_space1);
		panel.add(label_cnv1);
		panel.add(label_cnv2);
		panel.add(label_cnv3);
		panel.add(label_cnv4);
		
	}
}
