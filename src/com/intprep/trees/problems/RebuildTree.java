package com.intprep.trees.problems;

public class RebuildTree extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new RebuildTree().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
		if (root == null) return;
		rebuildTree(traverseInOrder(root), traversePreOrder(root));
	}
	
	private void rebuildTree(String in, String pre) {
		int[] in_nodes = getIntArray(in);
		int[] pre_nodes = getIntArray(pre);
		Node root = rebuildTree(in_nodes, 0, in_nodes.length-1, pre_nodes);
		System.out.println("Showing reconstructed tree: ");
		showTree(root);
		pre_ind = 0;
	}
	
	int pre_ind = 0;
	private Node rebuildTree(int[] in_nodes, int start, int end, int[] pre_nodes) {
		//System.out.println("rebuildTree: start="+start+", end="+end+", pre_ind="+pre_ind);
		if (start > end) return null;
		Node root = new Node(pre_nodes[pre_ind++]);
		if (start == end) return root;
		int index = findNode (in_nodes, start, end, root.data);
		root.left = rebuildTree(in_nodes, start, index-1, pre_nodes);
		root.right = rebuildTree(in_nodes, index+1, end, pre_nodes);
		//System.out.println("rebuildTree: root="+root.data+", left="+root.left+", right="+root.right);
		return root;
	}
	
	private int findNode (int[] arr, int start, int end, int val) {
		for (int i = start; i <= end; i++)
			if (arr[i] == val) return i;
		return -1;
	}
	
	private int[] getIntArray(String s) {
		String[] splits = s.split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++)
			arr[i] = Integer.parseInt(splits[i]);
		return arr;
	}
}
