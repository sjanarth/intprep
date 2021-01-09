package com.coreds.trees.problems;

public class IsSubTree2 extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new IsSubTree2().executeAllTestCases();
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

    /*
     * We cannot rebuild a tree from from its in, pre or post order traversals.
     * However, if we knew the inorder and the pre or post orders, one can rebuild the tree.
     * Therefore, we take both the inorder and the preorder traversals below. 
     */
    private boolean isSubTree (Node root, Node root2) {
    	String rootInOrder = traverseInOrder (root); 
    	String rootPreOrder = traversePreOrder (root);
    	String root2InOrder = traverseInOrder (root2);
    	String root2PreOrder = traversePreOrder (root2);
    	return (rootInOrder.indexOf(root2InOrder.toString()) > -1 &&
    			rootPreOrder.indexOf(root2PreOrder.toString()) > -1);
    }
}
