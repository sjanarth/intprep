package com.coreds.trees.problems;

public class MergeTwoBSTs extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new MergeTwoBSTs().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
    }
	
	@Override 
	public void executeAllTestCases()	{
    	int[] arr1 = new int[] {30,40,45,50,55,60,70};
    	printArray ("Input-1", arr1);
    	Node root1 = arrayToBST (arr1, 0, arr1.length-1);
    	int[] arr2 = new int[] {32,42,47,52,57,62,72};
    	printArray ("Input-2", arr2);
    	Node root2 = arrayToBST (arr2, 0, arr2.length-1);
    	Node merged = mergeBSTs (root1, root2);
    	System.out.println("InOder(merged): "+traverseInOrder (merged));
    }

    private void printArray (String msg, int[] arr) {
    	System.out.print(msg+":");
    	for (int k : arr)
    		System.out.print(" "+k);
    	System.out.println();
    }
	
    private Node arrayToBST (int[] arr, int start, int end) {
    	if (start > end)
    		return null;
    	int mid = (start+end)/2;
    	//System.out.println("("+start+" "+(mid-1)+") "+mid+" ("+(mid+1)+" "+end+")");
    	Node root = new Node (arr[mid]);
		root.left = arrayToBST (arr, start, mid-1);
		root.right = arrayToBST (arr, mid+1, end);
    	return root;
    }
    
    private int[] bstToArray (Node root) {
    	String inOrder = traverseInOrder (root);
    	String[] splits = inOrder.split(",");
    	int[] arr = new int[splits.length];
    	for (int i = 0; i < splits.length; i++)
    		arr[i] = Integer.parseInt(splits[i]);
    	return arr;
    }
    
    private Node mergeBSTs (Node root1, Node root2) {
    	int[] arr1 = bstToArray (root1);
    	int[] arr2 = bstToArray (root2);
    	int[] mergedArr = mergeArrays (arr1, arr2);
    	return arrayToBST (mergedArr, 0, mergedArr.length-1);
    }

    private int[] mergeArrays (int[] arr1, int[] arr2) {
    	int[] merged = new int[arr1.length+arr2.length];
    	int i = 0, j = 0, k = 0;
    	while (i < arr1.length && j < arr2.length)	{	
    		if (arr1[i] < arr2[j])
    			merged[k++] = arr1[i++];
    		else
    			merged[k++] = arr2[j++];
    	}
    	while (i < arr1.length) merged[k++] = arr1[i++];
    	while (j < arr2.length) merged[k++] = arr2[j++];
    	return merged;
    }
}