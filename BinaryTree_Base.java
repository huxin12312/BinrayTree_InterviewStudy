package BinaryTree;

import java.util.*;

public class BinaryTree_Base {
    
	private static class TreeNode{
		int val; 
		TreeNode left;
		TreeNode right;
		   
		   public TreeNode(int val){
			   this.val= val;
		   }
	}
	
	public static int getNumOfTreeNode(TreeNode root){
		if(root == null) return 0;
		else return getNumOfTreeNode(root.right) + getNumOfTreeNode(root.left) +1;
	}
	
    public static int getNumOfTreeNode_Iterative(TreeNode root){
    	if(root == null) return 0;
    	int Number = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()){
    		TreeNode temp = queue.poll();
    		if(temp.left != null){
    			queue.add(temp.left);
    			Number ++;
    		}
    		if(temp.right != null){
    			queue.add(temp.right);
    			Number ++;
    		}
    	}
    	return Number;
    }
    
    public static int getDepthOfTreeNode(TreeNode root){
    	if(root == null) return 0;
    	int left = getDepthOfTreeNode(root.left);
    	int right = getDepthOfTreeNode(root.right);
    	return Math.max(left, right)+1;
    }
    
    public static int getDepthOfTreeNode_Iterative(TreeNode root){
    	if(root == null) return 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	int level = 0;
    	int current = 1;
    	int next = 0;
    	queue.add(root);
    	while(!queue.isEmpty()){
    		TreeNode temp = queue.poll();
    		current--;
    		if(temp.left != null){
    			queue.add(temp.left);
    			next++;
    		}
    		if(temp.right != null){
    			queue.add(temp.right);
    			next++;
    		}
    		if(current == 0){
    			current = next;
    			next = 0;
    			level ++;
    		}
    	}
    	return level;
    }
    
    public static ArrayList<Integer> preorderTraversal(TreeNode root){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(root == null) return list;
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode temp = stack.pop();
    		list.add(temp.val);
    		if(temp.right != null){
    		    stack.push(temp.right);
    		}
    		if(temp.left != null){
    			stack.push(temp.left);
    		}
    	}
    	return list;
    }
    
    public static void preorderTraversal_Recursive(TreeNode root){
    	if(root == null) return;
    	
    	System.out.print(root.val);
    	preorderTraversal_Recursive(root.left);
    	preorderTraversal_Recursive(root.right);    
    }
    
    public static void inorderTraversal_Recursive(TreeNode root){
    	if(root == null) return;
    	inorderTraversal_Recursive(root.left);
    	System.out.println(root.val);
    	inorderTraversal_Recursive(root.right);
    }
    
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
    	ArrayList<Integer> Array = new ArrayList<Integer>();
    	if(root == null) return Array;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode temp =root;
    	while(true){
    		while(temp != null) {
    			stack.push(temp);
    			temp = temp.left;
    		}
    		
    		if(stack.isEmpty()) break;
    		temp = stack.pop();
    		Array.add(temp.val);
    		temp = temp.right;
    		
    	}
    	return Array;
    }
    
    public static void postorderTraversal_Recursive(TreeNode root){
    	if(root == null) return;
    	postorderTraversal_Recursive(root.left);
    	postorderTraversal_Recursive(root.right);
    	System.out.println(root.val);
    }
    
    public static ArrayList<Integer> postordereTraversal(TreeNode root){
    	ArrayList<Integer> Array = new ArrayList<Integer>();
    	if(root == null) return Array;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<TreeNode> temp = new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    	    	TreeNode node = stack.pop();
    	    	temp.push(node);
    	    	if(node.left != null){
    	    		stack.push(node.left);
    	    	}
    	    	if(node.right != null){
    	    		stack.push(node.right);
    	    	}
    	}
    	
    	while(!temp.isEmpty()){
    		Array.add(temp.pop().val);
    	}
    	return Array;
    	}
    
    public static ArrayList<Integer> levelTraversal(TreeNode root){
    	ArrayList<Integer> Array = new ArrayList<Integer>();
    	if(root == null) return Array;
    	int current = 1, next = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		current--;
    		TreeNode temp = queue.poll();
    		Array.add(temp.val);
    		if(temp.left != null){
    			queue.add(temp.left);
    			next++;
    		}
    		if(temp.right != null){
    			queue.add(temp.right);
    			next++;
    		}
    		if(current == 0){
    			current = next;
    			next =0;
    		}
    	}
    	return Array;
    }
    
    public static void levelTraversal_Recursive(TreeNode root){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        level_Rec(root, 0, result);
        System.out.println(result);
    }
    
    public static void level_Rec(TreeNode root, int level, ArrayList<ArrayList<Integer>> Array){
    	if(root == null) return;
    	
    	if(level >= Array.size()){
    		Array.add(new ArrayList<Integer>());
    	}
    	
    	Array.get(level).add(root.val);
    	level_Rec(root.left, level+1, Array);
    	level_Rec(root.right, level+1, Array);
    }
    
    public static TreeNode convertTreeToDLL(TreeNode root){
    	if(root == null) return root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode current = root, old = null, head = null;
    	
    	while(true){
    		while(current != null){
    			stack.push(current);
    			current = current.left;
    		}
    		
    		if(stack.isEmpty()) break;
    		
    		current = stack.pop();
    		if(old!= null){
    			old.right = current;
    		}
    		if(head == null) head = current;
    		
    		old = current;
    		current = current.right;
    	}
    	
    	return head;
    }
    
    public static int getNumOfKInNode(TreeNode root, int k){
    	if(root == null || k == 0) return 0;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	int current = 1, next = 0, level = 1;
    	int result = 0;
    	stack.push(root);
    	while(!stack.isEmpty()){
    		current--;
    		if(level == k) {
    			result = current;
    			break;
    		}
    		TreeNode temp = stack.pop();
    		if(temp.left != null){
    			next++;
    			stack.push(temp.left);
    		}
    		if(temp.right != null){
    			next++;
    			stack.push(temp.right);
    		}
    		if(current == 0){
    			current = next;
    			next = 0;
    			level ++;
    		}
    	}
    	return result;
    }
    
    public static int getNumOfKInNode_Recursive(TreeNode root, int k){
    	if(root == null || k < 1) return 0;
    	if(k == 1) return 1;
    	
    	int left = getNumOfKInNode_Recursive(root.left, k-1);
    	int right = getNumOfKInNode_Recursive(root.right, k-1);
    	return left+right;
    }
    
    public static int getLeafNumber_Rec(TreeNode root){
    	if(root == null) return 0;
    	if(root.right == null && root.left == null) return 1;
    	return getLeafNumber_Rec(root.left) + getLeafNumber_Rec(root.right);
    }
    
    public static int getLeafNumber(TreeNode root){
    	if(root == null) return 0;
    	int result = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		TreeNode temp = queue.poll();
    		if(temp.left != null){
    			queue.add(temp.left);
    		}
    		if(temp.right != null){
    			queue.add(temp.right);
    		}
    		if(temp.right == null && temp.left == null) result++;
    	}
    	return result;
    }
    
    public static boolean isSame_Recursive(TreeNode root1, TreeNode root2){
    	if(root1.val == root2.val) return true;
    	if(root1 == null && root2 == null) return true;
    	if(root1 == null || root1 == null) return false;
    	if(root1.val != root2.val) return false;
    	boolean left = isSame_Recursive(root1.left, root2.left);
    	boolean right = isSame_Recursive(root1.right, root2.left);
    	return left && right;  	
    	}
    
    public static boolean isSame(TreeNode root1, TreeNode root2){
    	if(root1 == null || root2 == null || root1.val != root2.val) return false;
    	Stack<TreeNode> stack1 = new Stack<TreeNode>();
    	Stack<TreeNode> stack2 = new Stack<TreeNode>();
    	stack1.push(root1);
    	stack2.push(root2);
    	while(!stack1.isEmpty() && !stack2.isEmpty()){
    		TreeNode temp1 = stack1.pop(), temp2 = stack2.pop();
    		if((temp1.val == temp2.val)) continue;
    		else if((temp1.left != null && temp2.left != null) || (temp1.right != null && temp2.right != null)){
    			stack1.push(temp1.left);
    			stack1.push(temp1.right);
    			stack2.push(temp2.left);
    			stack2.push(temp2.right);
    		}
    		else return false;
    	}
    	return true;
    }
    
    public static boolean isBalance(TreeNode root){
    	if(root == null) return true;
    	int leftDepth = getDepth(root.left);
    	int rightDepth = getDepth(root.right);
    	return leftDepth == rightDepth;
    }
    
    public static int getDepth(TreeNode root){
    	if(root == null) return 0;
    	return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    
    public static TreeNode mirrorTree(TreeNode root){
    	if(root == null) return root;
    	TreeNode left = mirrorTree(root.left);
    	TreeNode right = mirrorTree(root.right);
    	root.left = right;
    	root.right = left;
    	return root;
    }
    
    public static TreeNode mirrorTree_Iterative(TreeNode root){
    	if(root == null) return root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode temp = stack.pop();
    		TreeNode mirror = temp.right;
    		temp.right = temp.left;
    		temp.left = mirror;
    		if(temp.left != null) stack.push(temp.left);
    		if(temp.right != null) stack.push(temp.right);
    	}
    	return root;
    }
    
    public static TreeNode mirrorTree_Modify(TreeNode root){
    	if(root == null) return root;
    	TreeNode result = new TreeNode(root.val);
    	result.left = mirrorTree_Modify(root.right);
    	result.right = mirrorTree_Modify(root.left);
    	return result;
    }
    
    public static TreeNode mirrorTree_Modify_Iterative(TreeNode root){
    	if(root == null) return root;
    	TreeNode result = new TreeNode(root.val);
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<TreeNode> newstack = new Stack<TreeNode>();
    	stack.push(root);
    	newstack.push(result);
    	while(!stack.isEmpty()){
    		TreeNode tempOld = stack.pop();
    		TreeNode tempNew = newstack.pop();
    		if(tempOld.left != null){
    			tempNew.right = new TreeNode(tempOld.left.val);
    			stack.push(tempOld.left);
    			newstack.push(tempNew.right);
    		}
    		if(tempOld.right != null){
    			tempNew.left = new TreeNode(tempOld.right.val);
    			stack.push(tempOld.right);
    			newstack.push(tempNew.left);
    		}
    	}
    	return result;
    }
    
    public static boolean checkMirror(TreeNode root1, TreeNode root2){
    	if(root1 == null || root2 == null) return false;
    	if(root1.val != root2.val) return false;
    	if(root1.val == root2.val) return true;
    	if(root1 == null && root2 == null) return true;
    	return checkMirror(root1.left, root2.right) && checkMirror(root1.right, root2.left);
    }
    
    public static TreeNode LastCommonParent(TreeNode root, TreeNode node1, TreeNode node2){
    	if(root == null) return root;
    	if(FindNode(root.left, node1)){
    		if(FindNode(root.right, node2)) return root;
    		else return LastCommonParent(root.left, node1, node2);
    	}
    	else {
    		if(FindNode(root.left, node2)) return root;
    		else return LastCommonParent(root.right, node1, node2);
    	}
    }
    
    public static boolean FindNode(TreeNode root, TreeNode node){
    	if(root == node) return true;
    	if(root == null) return false;
    	boolean check = FindNode(root.left, node);
    	if(!check) FindNode(root.right, node);
    	return check;
    }
    
    public static TreeNode LastCommonParent_Iterative(TreeNode root, TreeNode node1, TreeNode node2){
    	if(root == null || node1 == null || node2 == null) return root;
    	
    	ArrayList<TreeNode> array1 = new ArrayList<TreeNode>();
    	boolean check1 = getPath(root, node1, array1);
    	ArrayList<TreeNode> array2 = new ArrayList<TreeNode>();
    	boolean check2 = getPath(root, node2, array2);
    	
    	if(!check1 || !check2) return null;
    	
    	TreeNode last = null;
    	Iterator<TreeNode> iter1 = array1.iterator();
    	Iterator<TreeNode> iter2 = array2.iterator();
    	
    	while(iter1.hasNext() && iter2.hasNext()){
    		TreeNode temp1 = iter1.next();
    		TreeNode temp2 = iter2.next();
    		if(temp1 == temp2) last = temp1;
    		else break;
    	}
    	return last;
    }
    
    public static boolean getPath(TreeNode root, TreeNode node, ArrayList<TreeNode> array){
    	if(root == null) return false;
    	array.add(root);
    	if(root == node) return true;
    	boolean finding = false;
    	finding = getPath(root.left, node, array);
    	if(!finding) finding = getPath(root.right, node, array);
    	if(!finding) array.remove(root);
    	return finding;
    }
    
    public static Depthance MaxDistance(TreeNode root){
    	    Depthance Result =  new Depthance();
    	if(root == null) {
    	    Result = new Depthance(0, -1);
    		return Result;
    	}
    	
    	Depthance left = MaxDistance(root.left);
    	Depthance right = MaxDistance(root.right);
    	Result.Depth = Math.max(left.Depth, right.Depth);
    	Result.distance = Math.max(left.Depth + right.Depth, Math.max(left.distance, right.distance));
    	return Result;
    }
    
    private static class Depthance{
    	int distance, Depth;
    	public Depthance(){
    		
    	}
    	public Depthance(int Maxdistance, int MaxDepth){
    		distance = Maxdistance;
    		Depth = MaxDepth;
    	}
    }
    
    public static TreeNode buildTree_preinorder(List<TreeNode> preorder, List<TreeNode> inorder){
    	TreeNode result = new TreeNode(preorder.get(0).val); //the first index of preorder must be the root;
    	if((preorder.size() != 0) && (inorder.size() != 0)){
    	//going to split the inorder has left tree and right by using root
    	int inorder_Rootindex = inorder.indexOf(preorder.get(0));
    	List<TreeNode> leftinorder = inorder.subList(0, inorder_Rootindex);
    	List<TreeNode> rightinorder = inorder.subList(inorder_Rootindex+1, inorder.size());
    	int preorder_Rootindex = leftinorder.size();
    	List<TreeNode> leftpreorder = preorder.subList(1, preorder_Rootindex);
    	List<TreeNode> rightpreorder = preorder.subList(preorder_Rootindex + 1, preorder.size());
    	result.left = buildTree_preinorder(leftpreorder, leftinorder);
    	result.right = buildTree_preinorder(rightpreorder, rightinorder);
    	}
    	return result;
    }
    
    public static TreeNode buildTree_inpostorder(List<TreeNode> inorder, List<TreeNode> postorder){
    	TreeNode result = new TreeNode(postorder.get(postorder.size()-1).val); // the last index of postorder must be the root;
    	if((inorder.size() != 0) && (postorder.size() != 0)){
    		int inorder_Rootindex = inorder.indexOf(postorder.get(postorder.size() -1));
    		List<TreeNode> leftinorder = inorder.subList(0, inorder_Rootindex);
    		List<TreeNode> rightinorder = inorder.subList(inorder_Rootindex+1, inorder.size());
    		List<TreeNode> leftpostorder = postorder.subList(0, leftinorder.size());
    		List<TreeNode> rightpostorder = postorder.subList(leftinorder.size(), postorder.size() -1);
    		result.left = buildTree_inpostorder(leftinorder, leftpostorder);
    		result.right = buildTree_inpostorder(rightinorder, rightpostorder);
    	}
    	return result;
    }
    
    public static boolean checkCompleteTree(TreeNode root){
    	if(root == null) return true;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	boolean isLastlevel = false;
    	boolean checker = true;
    	while(!queue.isEmpty()){
    		TreeNode temp = queue.poll();
    		// if it is last level of tree, then child should not have value;
    		if(isLastlevel){
    			if(temp.left != null || temp.right != null) {
    				checker = false;
    				break;
    			}
    		}
    	    if(temp.right != null && temp.left != null) {
    	    	queue.add(temp.left);
    	    	queue.add(temp.right);
      	    }//check if there still in mid of level of tree
    	    else if((temp.right != null && temp.left == null)){
    	    	isLastlevel = true;
    	        queue.add(temp.right);  	
    	    }else if(temp.left != null && temp.right == null){
    	    	isLastlevel = true;
    	    	queue.add(temp.left);
    	    }else isLastlevel = true;
    	    
    	}
    	return checker;
    }
    
    /*
     * there is a best way to solve the completely tree and fully tree
     */
    public static boolean isCompleteTree_Recirsive(TreeNode root){
    	return isCompleteTree_Support(root).height != -1;
    }
    
    public static boolean isfullyTree(TreeNode root){
    	return isCompleteTree_Support(root).isFull;
    }
    
    public static Pair isCompleteTree_Support(TreeNode root){
    	if(root == null) return new Pair(0, true);
    	
    	Pair left = isCompleteTree_Support(root.left);
    	Pair right = isCompleteTree_Support(root.right);
    	
    	//if left leaf has full nodes, and left and right has same height, then it is fully tree
    	if(left.isFull && left.height == right.height){
    		return new Pair(1+left.height, right.isFull);
    	}
    	
    	//if right tree full but left is not, and left height == right height+1
    	//so is not full, and if tree is not completely tree, the height is -1
    	if(right.isFull && left.height == right.height +1){
    		return new Pair(1+left.height, false);
    	}
    	//others are not completely tree, set height to -1; 
    	return new Pair(-1, false);
    	
    }
    
    private static class Pair{
    	int height;
    	boolean isFull;
    	
    	public Pair(int height, boolean isFull){
    		this.height = height;
    		this.isFull = isFull;
    	}   	
    }
}
