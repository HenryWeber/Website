import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputWindow  extends JFrame
{
	
	Dimension d;
	Container canvas;
	JTextArea area;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	Listener l;
	BST bstTree;
	
	
	public InputWindow()
	{
		//set up defaults
		d = new Dimension(800,200);
		this.setSize(d);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Input Window");
		
		
		//set layout and canvas
		canvas = this.getContentPane();
		this.setLayout(new FlowLayout());
		
		//set up objects on canvas
		area = new JTextArea(20,55);
		area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button1 = new JButton("InOrder");
		button2 = new JButton("Descending");
		button3 = new JButton("Leaves");
		button4 = new JButton("Between");
		button5 = new JButton("SmallestOverX(41)");
		button6 = new JButton("SumLeaves");
		button7 = new JButton("Sum");
		
		//add objects to canvas
		canvas.add(button1);
		canvas.add(button2);
		canvas.add(button3);
		canvas.add(button4);
		canvas.add(button5);
		canvas.add(button6);
		canvas.add(button7);
		canvas.add(area);
		
		
		this.setSize(750,400);	
	}

	public void setListener(Listener listener) {
		// TODO Auto-generated method stub
		
		l = listener;
		button1.addActionListener(l);
		button2.addActionListener(l);
		button3.addActionListener(l);
		button4.addActionListener(l);
		button5.addActionListener(l);
		button6.addActionListener(l);
		button7.addActionListener(l);
		
	}
	
	public void setLL(BST list) {
		// TODO Auto-generated method stub
		bstTree = list;
	}

	public void showinput(String str) {
		// TODO Auto-generated method stub
		area.setText(str);
	}
	
	
	
}
