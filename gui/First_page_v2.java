package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class First_page_v2 extends JFrame implements ActionListener
{
	JPanel panel;
	
	JLabel label_wlc=new JLabel();
	JLabel label_space1=new JLabel();
	JLabel label_num_net=new JLabel();
	JTextField text_num_net = new JTextField(40);
	JLabel label_srv_cls=new JLabel();
	JTextField text_srv_cls = new JTextField(40);
	JLabel label_space2=new JLabel();
	JButton BUT_NTW = new JButton("Save and go to next page to enter network parameters");
	
	First_page_v2()
	{
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals("Save and go to next page to enter network parameters"))
		{
			int value_num_net = Integer.parseInt(text_num_net.getText());
			int value_srv_cls = Integer.parseInt(text_srv_cls.getText());
			
			Ntw_page obj = new Ntw_page();
			
			this.setVisible(false);
			
			obj.set_num_of_ntw_srvcls(value_num_net,value_srv_cls);
			
			obj.display();
			
			obj.setVisible(true);
		}
		
	}
	public void display()
	{
		label_wlc.setText("Hi! You have reached a wi-fi hotspot. Kindly enter the required parameters to select your network.");
		label_space1.setText("            ");
		label_num_net.setText("Enter the number of networks available:");
		label_srv_cls.setText("Enter 1,2,3 or 4 as the running service class (1 for Conversational,2 for Streaming,3 for Interactive and 4 for Background)");
		label_space2.setText("                    ");
		
		panel=new JPanel(new GridLayout(8,1));
		panel.add(label_wlc);
		panel.add(label_space1);
		panel.add(label_num_net);
		panel.add(text_num_net);
		panel.add(label_srv_cls);
		panel.add(text_srv_cls);
		panel.add(label_space2);
		panel.add(BUT_NTW);
		
		this.add(panel,BorderLayout.CENTER);
		
		BUT_NTW.addActionListener(this);
	}
}
