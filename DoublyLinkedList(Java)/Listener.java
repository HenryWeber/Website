import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Listener implements ActionListener {

	InputWindow myinputw;
	LinkedList lister;
	
	boolean stateb = true;
	boolean countyb = true;
	boolean popb = true;
	boolean mpopb = true;
	boolean fpopb = true;
	boolean povb = true;
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//check where action happened
		Object source = e.getSource();
		
		
		if(source instanceof JButton)
		{
			JButton buttonclicked = (JButton) source;

			
				if(buttonclicked.getText() == "State")
				{
					
					if(stateb == true) 
					{
						String str = lister.show("State");
						myinputw.showinput(str);
						stateb = false;
					}
					else if(stateb == false)
					{
						String str = lister.showback("State");
						myinputw.showinput(str);
						stateb = true;
					}
					
				}
				if(buttonclicked.getText() == "County")
				{
					if(countyb == true) 
					{
						String str = lister.show("County");
						myinputw.showinput(str);
						countyb = false;
					}
					else if(countyb == false)
					{
						String str = lister.showback("County");
						myinputw.showinput(str);
						countyb = true;
					}
				}	
				if(buttonclicked.getText() == "Pop.")
				{
					if(popb == true) 
					{
						String str = lister.show("Pop.");
						myinputw.showinput(str);
						popb = false;
					}
					else if(popb == false)
					{
						String str = lister.showback("Pop.");
						myinputw.showinput(str);
						popb = true;
					}
				}	
				if(buttonclicked.getText() == "Female Pop.")
				{
					if(fpopb == true) 
					{
						String str = lister.show("Female Pop.");
						myinputw.showinput(str);
						fpopb = false;
					}
					else if(fpopb == false)
					{
						String str = lister.showback("Female Pop.");
						myinputw.showinput(str);
						fpopb = true;
					}
				}
				if(buttonclicked.getText() == "Male Pop.")
				{
					if(mpopb == true) 
					{
						String str = lister.show("Male Pop.");
						myinputw.showinput(str);
						mpopb = false;
					}
					else if(mpopb == false)
					{
						String str = lister.showback("Male Pop.");
						myinputw.showinput(str);
						mpopb = true;
					}
				}
				if(buttonclicked.getText() == "Perc. under Pov.")
				{
					if(povb == true) 
					{
						String str = lister.show("Perc. under Pov.");
						myinputw.showinput(str);
						povb = false;
					}
					else if(povb == false)
					{
						String str = lister.showback("Perc. under Pov.");
						myinputw.showinput(str);
						povb = true;
					}
				}
			
			
		}
		
	}

	public void setInputWindow(InputWindow inputw) {
		// TODO Auto-generated method stub
		
		myinputw = inputw;
	}

	public void setDM(LinkedList list) {
		// TODO Auto-generated method stub
		lister = list;
	}



}
