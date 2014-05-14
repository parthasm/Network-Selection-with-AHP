package gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Output_ntw extends JFrame 
{
	private int num_of_ntw;
	private int srv_cls;
	private double[][] ntw,outp;
	
	
	JPanel panel;
	JLabel label_line1 = new JLabel();
	JLabel[] label_space;
	JLabel[] label_ntw;
	Output_ntw()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setTitle("Ranked list of networks");
	}
	public void set_var(int n1,int n2,double[][] x)
	{
		num_of_ntw=n1;
		srv_cls = n2;
		ntw=x;
	}
	
	public void display()
	{
		this.setSize(500, (80*num_of_ntw));
		int i;
		label_line1.setText("The networks can be ordered in the following way(best to worst)");
		label_space = new JLabel[num_of_ntw];
		label_ntw = new JLabel[num_of_ntw];
		panel=new JPanel(new GridLayout((2*num_of_ntw+1),1));
		panel.add(label_line1);
		Calculate_ntw obj = new Calculate_ntw(num_of_ntw,srv_cls);
		
		obj.set_ntw(ntw);
		
		outp = obj.do_it();
		
		for(i=0;i<num_of_ntw;i++)
		{
			label_ntw[i]= new JLabel();
			label_space[i]= new JLabel();
			label_ntw[i].setText("network "+((int)outp[i][0])+" with the weight "+outp[i][1]);
			label_space[i].setText("              ");
			panel.add(label_space[i]);
			panel.add(label_ntw[i]);
			
		}
		this.add(panel,BorderLayout.CENTER);
	}
}
