import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//Constructors
		InputWindow inputw = new InputWindow();
		Listener listener = new Listener();
		BST tree = new BST();
		
		//listener and inputwindow can communicate
		inputw.setListener(listener);
		listener.setInputWindow(inputw);
		listener.setDM(tree);
		
		Scanner scan = new Scanner(new File("BST.txt"));
		int root = scan.nextInt();
		tree.insert(tree, root);
		
		
		//read a file with random values and insert each value into the tree
		while(scan.hasNext() == true){
			int input = scan.nextInt();
			tree.insert(tree, input);
		}
		/*
		System.out.println("InOrder: "+tree.inorder(tree));
		System.out.println();
		System.out.println("Descending: "+tree.descending(tree));		
		System.out.println();
		System.out.println("Leaves: "+tree.leaves(tree));		
		System.out.println();
		System.out.println("Smallest and Largest: "+tree.and(tree));
		System.out.println();
		System.out.println("Between: "+tree.between(tree));		
		System.out.println();
		System.out.println("SmallestOverX: "+tree.smallestoverx(tree,41));		
		System.out.println();
		System.out.println("SumLeaves: "+tree.sumleaves(tree));		
		System.out.println();
		System.out.println("Sum: "+tree.sum(tree));		
		System.out.println();
		System.out.println("Height: "+tree.height(tree));		
		System.out.println();
		*/
		
		
		
		
	}

}