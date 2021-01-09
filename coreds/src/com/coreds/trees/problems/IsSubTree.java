package com.coreds.trees.problems;

public class IsSubTree extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new IsSubTree().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root)	{
	}
	
	@Override
	public void executeAllTestCases()	{
		Node main = buildLargeTree();
		System.out.println("Main tree: ");
		showTree(main);
		Node test1 = buildSmallSubOfLargeTree();
		System.out.println("Test tree-1:");
		showTree(test1);
		System.out.println("IsSubTree: "+isSubTree(main, test1));
		Node test2 = buildBiggerSubOfLargeTree();
		//test2.left = new Node (5000);
		System.out.println("Test tree-2:");
		showTree(test2);
		System.out.println("IsSubTree: "+isSubTree(main, test2));
	}
	
    // For each node in root, check if the subtree at root is identical to root2
    private static boolean isSubTree (Node root, Node root2) {
    	if (areIdentical (root, root2))
    		return true;
    	if (root.left != null)
    		if (isSubTree(root.left, root2))
    			return true;
    	if (root.right != null)
    		if (isSubTree(root.right, root2))
    			return true;
    	return false;
    }
    
	private static boolean areIdentical (Node root, Node root2) {
    	if (root2 == null)
    		return true;
    	if (root == null)
    		return false;
    	if (root.data != root2.data)
    		return false;
    	if ((root.left == null) && (root2.left != null))
    		return false;
    	if ((root.right == null) && (root2.right != null))
    		return false;
    	return areIdentical (root.left, root2.left) &&
    			areIdentical (root.right, root2.right);
    }
}