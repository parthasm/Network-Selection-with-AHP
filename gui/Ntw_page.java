package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Ntw_page extends JFrame implements ActionListener
{
	private int num_of_ntw;
	private int srv_cls;
	private double[][] ntw;
	
	JPanel panel= new JPanel();
	JLabel label_space1=new JLabel();
	JLabel label_space2=new JLabel();
	JLabel[] label_ntw;
	JTextField[] text_ntw;
	JButton BUT_FINISH = new JButton("Done");
	Ntw_page()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setTitle("Network Parameters");
	       
	}
	public void set_num_of_ntw_srvcls(int n1,int n2)
	{
		num_of_ntw = n1;
		
		srv_cls = n2;
		
		ntw = new double[num_of_ntw][5];
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals("Done"))
		{
			String[] values = new String[num_of_ntw];
			int i,j,col;
			for(i=0;i<num_of_ntw;i++)
			{
				values[i]=text_ntw[i].getText();
				col=0;
				while(values[i].indexOf("-")!=-1)
				{
					
					j=values[i].indexOf("-");
					ntw[i][col++] = Double.parseDouble(values[i].substring(0,j));
					values[i]=values[i].substring(j+1);
				}
				ntw[i][col++] = Double.parseDouble(values[i]);
			}
		
			Output_ntw obj = new Output_ntw();
	
			obj.set_var(num_of_ntw, srv_cls, ntw);
			
			this.setVisible(false);
			
			obj.display();
			
			obj.setVisible(true);
	
			//printing entered matrix
			/*for(i=0;i<num_of_ntw;i++)
			{
				for(j=0;j<5;j++)
					System.out.print(ntw[i][j]+"\t");
				System.out.println();
			}*/
		
		
		
		
		}
		
		
	}
	public void display()
	{
		this.setSize(700, (100*num_of_ntw));
		label_space1.setText("            ");
		label_space2.setText("            ");
		label_ntw = new JLabel[num_of_ntw];
		text_ntw = new JTextField[num_of_ntw];
		
		panel=new JPanel(new GridLayout((2*(num_of_ntw+1)),1));
		//panel.add(label_space1);
		int i;
		for(i=0;i<num_of_ntw;i++)
		{
			text_ntw[i] = new JTextField(20);
			label_ntw[i]= new JLabel();
			label_ntw[i].setText("Enter ANT,RP,IC,CB,SE values for network "+(i+1)+" separated by '-' between each value.Eg:2-3-4-5-6");
			panel.add(label_ntw[i]);
			panel.add(text_ntw[i]);
		}
		panel.add(label_space2);
		panel.add(BUT_FINISH);
		
		this.add(panel,BorderLayout.CENTER);
		BUT_FINISH.addActionListener(this);
		
	}
}
