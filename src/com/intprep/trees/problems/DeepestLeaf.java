package com.intprep.trees.problems;

public class DeepestLeaf extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new DeepestLeaf().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root) {
		System.out.println("Deepest Path: "+getDeepestPath(root));
    }
	
	private static String getDeepestPath(Node node) {
		if(node == null) return "";
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		String sLeft = getDeepestPath(node.left);
		String sRight = getDeepestPath(node.right);
		String[] aLeft = (sLeft.isEmpty() ? new String[0] : sLeft.split(DELIM, -1));
		String[] aRight = (sRight.isEmpty() ? new String[0] : sRight.split(DELIM, -1));
		//System.out.println("node="+node.data+", aLeft="+aLeft.length+",aRight="+aRight.length);
		String[] aLonger = (aLeft.length > aRight.length ? aLeft : aRight);
		if (aLeft.length == 0) aLonger = aRight;
		if (aRight.length == 0) aLonger = aLeft;
		for (int i = 0; i < aLonger.length; i++)	{
			if (!aLonger[i].equals(""))
				sb.append(","+aLonger[i]);
		}
		return sb.toString();
	}
}