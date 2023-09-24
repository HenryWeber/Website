import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Listener implements ActionListener {

	InputWindow myinputw;
	BST tree;
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//check where action happened
		Object source = e.getSource();
		
		
		if(source instanceof JButton)
		{
			JButton buttonclicked = (JButton) source;
			
			String label = buttonclicked.getText();
			String str = "null";
			
			switch(label) {
			  case "InOrder":
				  str = tree.show("InOrder");
			    break;
			  case "Descending":
				  str = tree.show("Descending");
			    break;
			  case "Leaves":
				  str = tree.show("Leaves");
				    break;
			  case "Between":
				  str = tree.show("Between");
				    break;
			  case "SmallestOverX(41)":
				  str = tree.show("SmallestOverX(41)");
				    break;
			  case "Sum":
				  str = tree.show("Sum");
				    break;
			  case "SumLeaves":
				  str = tree.show("SumLeaves");
				    break;
			  case "Height":
				  str = tree.show("Height");
				    break;  
			}
				
			
			myinputw.showinput(str);	
				
				
			
			
		}
		
	}

	public void setInputWindow(InputWindow inputw) {
		// TODO Auto-generated method stub
		
		myinputw = inputw;
	}

	public void setDM(BST list) {
		// TODO Auto-generated method stub
		tree = list;
	}



}
