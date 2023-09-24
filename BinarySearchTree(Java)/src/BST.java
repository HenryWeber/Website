
public class BST {
	
	BSTNode root;
	
	public BST(){
		root = null;
	}
	
	public void insert(BST r,int i) {
		
		if (root == null)
			root = new BSTNode(r, i);
		else
			root.insert(r, i);
	}
	public String inorder(BST tree) {
		
		if (root != null)
			return root.inorder(tree.root);
		else
			return "No values";
	}
	public String descending(BST tree) {
		
		if (root != null)
			return root.descending(tree.root);
		else
			return "No values";
	}
	public String leaves(BST tree) {
		
		if (root != null)
			return root.leaves(tree.root);
		else
			return "None";
	}
	public String between(BST tree) {
		
		if (root != null)
			return root.between(tree.root);
		else
			return "No values";
	}

	public int smallestoverx(BST tree,int x) {
		
		if (root != null)  
			return root.smallestoverx(tree.root, x);
		else
			return -1;
	}

	public int sumleaves(BST tree) {

		if (root != null)  
			return root.sumleaves(tree.root);
		else
			return -1;
	}

	public int sum(BST tree) {
		
		if (root != null)
			return root.sum(tree.root);
		else
			return -1;
	}

	public int height(BST tree) {

		if (root != null) {
			
			int height = root.height(tree.root);
			
			if(height % 2 == 1)
				return (height/2)+1;
			else
				return height/2;
		}
		else
			return -1;
	}

	public String and(BST tree) {

		if (root != null)  
			return root.and(tree.root);
		else
			return "None Available";
	}

	public String show(String label) {
		
		String output = "null";
		int x = -1;
		
		switch(label) {
		  case "InOrder":
			  output = root.inorder(root);
		    break;
		  case "Descending":
			  output = root.descending(root);
		    break;
		  case "Leaves":
			  output = root.leaves(root);
			    break;
		  case "Between":
			  output = root.between(root);  
			    break;
		  case "SmallestOverX(41)":
			  x = root.smallestoverx(root, 41); 
			  output = String.valueOf(x);
			    break;
		  case "Sum":
			  x = root.sum(root); 
			  output = String.valueOf(x);
			    break;
		  case "SumLeaves":
			  x = root.sumleaves(root); 
			  output = String.valueOf(x);
			    break;
		  case "Height":
			  x = root.height(root);
			  output = String.valueOf(x);
			    break;  
		}
		return output;
	}
				
}


