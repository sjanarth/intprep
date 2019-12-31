package com.intprep.trees.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new SerializeDeserialize().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
		String s = serialize (root);
		System.out.println("Serialized form = ["+s+"]");
		Node node = deserialize (s);
		showTree(node);
    }
	
	private String serialize (Node root)	{
		StringBuilder sb = new StringBuilder ();
		serialize (root, sb);
		return sb.toString();
	}
	
	private void serialize(Node root, StringBuilder sb)	{
		if (root == null) {
			sb.append("$").append(",");
		} else {
			sb.append(root.data).append(",");
			serialize (root.left, sb);
			serialize (root.right, sb);
		}
	}
	
	private Node deserialize (String s)	{
		Queue<String> q = new LinkedList<String>();
		for (String f : s.split(","))
			q.offer(f);
		return deserialize (q);
	}
	
	private Node deserialize (Queue<String> q) {
		Node root = null;
		if (!q.isEmpty())	{
			String f = q.poll();
			if (!f.equals("$"))	{
				root = new Node (Integer.parseInt(f));
				root.left = deserialize (q);
				root.right = deserialize (q);
			}
		}
		return root;
	}
}
