package com.intprep.trees.problems;

public class SortedArrayToBST 
{
	protected static final String DELIM = ",";
	
	protected static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
	protected static String traverseInOrder(Node node) {
		StringBuilder sb = new StringBuilder();
		if (node.left != null)
			sb.append(traverseInOrder(node.left));
		if (sb.length() > 0) sb.append(DELIM);
		sb.append(node.data);
		if (node.right != null)
			sb.append(DELIM+traverseInOrder(node.right));
		return sb.toString();
	}
	
    public static void main (String[] args) {
    	int[] arr = new int[] {30,40,45,50,51,55,60,70};
    	printArray ("Input", arr);
    	Node root = convertToBST (arr, 0, arr.length-1);
    	System.out.println("InOder: "+traverseInOrder (root));
    }
	
    private static void printArray (String msg, int[] arr) {
    	System.out.print(msg);
    	for (int k : arr)
    		System.out.print(" "+k);
    	System.out.println();
    }
    
    private static Node convertToBST (int[] arr, int start, int end) {
    	if (start > end)
    		return null;
    	int mid = (start+end)/2;
    	//System.out.println("("+start+" "+(mid-1)+") "+mid+" ("+(mid+1)+" "+end+")");
    	Node root = new Node (arr[mid]);
		root.left = convertToBST (arr, start, mid-1);
		root.right = convertToBST (arr, mid+1, end);
    	return root;
    }
}
