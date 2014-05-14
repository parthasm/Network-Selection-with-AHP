package gui;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class Demo 
{
	public static void main(String[] args) 
	{
		try
		{
		First_page_v2 obj=new First_page_v2();
		obj.setSize(800,240);
		obj.display();
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	catch(Exception e)
		{JOptionPane.showMessageDialog(null, e.getMessage());}
	}

	}

