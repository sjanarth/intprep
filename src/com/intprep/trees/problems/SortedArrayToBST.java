package com.intprep.trees.problems;

public class SortedArrayToBST extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new SortedArrayToBST().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
    }
	
	@Override 
	public void executeAllTestCases()	{
    	int[] arr = new int[] {30,40,45,50,51,55,60,70};
    	printArray ("Input", arr);
    	Node root = convertToBST (arr, 0, arr.length-1);
    	System.out.println("InOder: "+traverseInOrder (root));
    }
	
    private void printArray (String msg, int[] arr) {
    	System.out.print(msg);
    	for (int k : arr)
    		System.out.print(" "+k);
    	System.out.println();
    }
    
    private Node convertToBST (int[] arr, int start, int end) {
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