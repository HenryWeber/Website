
public class Driver {
	
	public static void main(String[] args) {
		
		
		
		InputWindow inputw = new InputWindow();
		
		Listener listener = new Listener();
		
		//listener and inputwindow know each other
		inputw.setListener(listener);
		listener.setInputWindow(inputw);
		
		LinkedList list = new LinkedList();
		
		
		listener.setDM(list);
		
		
		//create list and add to it
		
		 list.insert("MN", "Winona", 100000, 55000, 45000, 12);
		 list.insert("MN", "LaCrosse", 120000, 70000, 50000, 4);
		 list.insert("MI", "Cheboygan", 180000, 100000, 80000, 6);
		 list.insert("MI", "Chippewa", 130000, 65000, 65000, 9);
		 list.insert("WI", "St. Croix", 145000, 75000, 70000, 3);
		 list.insert("WI", "Bayfield", 165000, 90000, 75000, 4);
		 //display list
		  
		  System.out.println();
		  
		  

	}
}
