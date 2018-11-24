package com.intprep.trees.problems;

public class SortedArrayToBST 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }

    private static void traverseInOrder (Node node, StringBuffer sb) {
    	if (node.left != null)	
    		traverseInOrder(node.left, sb);
    	if (sb.length() > 0)
    		sb.append(","+node.data);
    	else
    		sb.append(node.data);
    	if (node.right != null)	
    		traverseInOrder(node.right, sb);
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
    
    public static void main (String[] args) {
    	int[] arr = new int[] {30,40,45,50,51,55,60,70};
    	printArray ("Input", arr);
    	Node root = convertToBST (arr, 0, arr.length-1);
    	StringBuffer sb = new StringBuffer();
    	traverseInOrder (root, sb);
    	System.out.println("InOder: "+sb.toString());
    }
	
}
