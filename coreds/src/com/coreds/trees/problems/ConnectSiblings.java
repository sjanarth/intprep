package com.coreds.trees.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConnectSiblings extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new ConnectSiblings().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		Map<Node,Integer> levels = new HashMap<Node,Integer>();
		queue.add(root);
		levels.put(root, 0);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (levels.get(node) == 0) 	{ 
				node.next = null;
			} else if (queue.isEmpty())	{
				node.next = null;
			} else {
				Node next = queue.peek();
				if (levels.get(node) == levels.get(next))	{
					node.next = next;
				} else {
					node.next = null;
				}
			}
			if (node.left != null) { queue.add(node.left); levels.put(node.left, levels.get(node)+1); }
			if (node.right != null) { queue.add(node.right); levels.put(node.right, levels.get(node)+1); }
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data);
			Node curr = node.next;
			while (curr != null) {
				System.out.print(" => "+curr.data);
				curr = curr.next;
				queue.poll();
			}
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
			System.out.println();
		}
	}
}
