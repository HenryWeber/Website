public class BSTNode {
	
	int data, parent;
	BSTNode left, right;
	BST trueRoot;
	
	String result = "";
	int resultInteger = -1;
	
	int llargest = 0;
	int rlargest = 0;
	int min = 101;
	int max = -1;
	
	public void resetResult() {
		this.result = "";
		this.resultInteger = -1;
		this.min = 101;
		this.max = -1;
	}
	
	public BSTNode(BST r, int v){
		data = v;
		left = null;
		right = null;
		parent = v;
		trueRoot = r; 
	}
	
	public void insert(BST root, int v){
		if (v < data){
			if (left == null){
				BSTNode child = new BSTNode(root, v);
				child.parent = data;
				left = child;
			}
			else 
				left.insert(root, v);
		}
		else if (v > data){
			if (right == null){
				BSTNode child = new BSTNode(root, v);
				child.parent = data;
				right = child;
			}
			else 
				right.insert(root, v);
		}	
	}
	
	public String inorder(BSTNode tree){
		
		resetResult();
		
		if (left != null)
			 result += tree.left.inorder(tree.left);
		
		result += data + ", ";
		
		if (right != null)
			result += tree.right.inorder(tree.right);
		
		return result;
	}
	
	public String descending(BSTNode tree){
		
		resetResult();
		
		if (right != null) 
			 result += tree.right.descending(tree.right);
			
		result += data + ", ";
		
		if (left != null) 
			result += tree.left.descending(tree.left);
		
		return result;
	}

	public String between(BSTNode tree) {
		
		resetResult();
		
		if(tree.data > 50 && tree.data < 100 )
			result += data + " ";
		
		if (right != null)
			 result += tree.right.between(tree.right);
		
		if (left != null)
			result += tree.left.between(tree.left);
		
		return  result;
	}
	
	public String and(BSTNode tree) {
		
		resetResult();
				
		if (left != null) 
			result += tree.left.and(tree.left);
		
		if (right != null) 
			result += tree.right.and(tree.right);
		
		if(right == null && left == null)
			result += data + " ";
		
		return result;
	}
	public int smallestoverx(BSTNode tree, int x) {
		
		resetResult();
		
		resultInteger = parent;
		
		//left leaves
		if(left ==null && right == null && tree.parent < x && x < tree.trueRoot.root.data)
			resultInteger = tree.trueRoot.root.data;
	
		//if small enough
		if((tree.data > x && tree.left == null)  || (tree.data > x && tree.left.data < x)){	
			resultInteger = data;
			
			//right leaves
			if(tree.data > x && tree.data > tree.trueRoot.root.data && right == null && parent < x)
				return resultInteger;
			
		}
		if(tree.right != null && tree.data <= x  )
			return tree.right.smallestoverx(tree.right, x);		
		
		if(tree.left != null && tree.data > x)  
			return tree.left.smallestoverx(tree.left , x);
		
		return resultInteger;
	}
	
	public String leaves(BSTNode tree) {
		
		resetResult();
		
		if(right == null && left == null)
			result += ", " + data;
		
		if (left != null)
			result += left.leaves(tree.left);
		
		if (right != null)
			result += right.leaves(tree.right);

		return result;
	}

	public int sumleaves(BSTNode tree) {
		
		resetResult();
		
		if(right == null && left == null)
			resultInteger += data;
		
		if (right != null) 
			resultInteger += tree.right.sumleaves(tree.right);
			
		if (left != null) 
			resultInteger += tree.left.sumleaves(tree.left);
		
		return resultInteger;
	}

	public int sum(BSTNode tree) {

		resetResult();
		
		if (right != null) 
			 resultInteger += tree.right.sum(tree.right);
			
		resultInteger += data;
		
		if (left != null) 
			resultInteger += tree.left.sum(tree.left);
	
		return resultInteger;
	}

	public int height(BSTNode tree) {
		
		if(left != null) {
			llargest += 1;	
			llargest += tree.left.height(tree.left);
		}
		
		if(right != null)  {
			rlargest += 1;
			rlargest += tree.right.height(tree.right);
		}
		
		return 1 + Math.max(rlargest, llargest);		
	}

}