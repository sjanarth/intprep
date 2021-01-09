package com.coreds.trees.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblings2  extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new ConnectSiblings2().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
		if(root == null) return;
		connectSiblings(root);
		showConnections(root);
	}
	
	private void connectSiblings (Node root) {
		Queue<Node> q1 = new LinkedList<Node>();
		q1.offer(root);
		Queue<Node> q2 = new LinkedList<Node>();
		while (!q1.isEmpty())	{
			Node curr = q1.poll();
			if (curr.left != null) q2.offer(curr.left);
			if (curr.right != null) q2.offer(curr.right);
			if (q1.isEmpty()) {
				curr.next = null;
				while (!q2.isEmpty())
					q1.offer(q2.poll());
			} else {
				curr.next = q1.peek();
			}
		}
	}
	
	private void showConnections (Node root)	{
		Queue<Node> queue = new LinkedList<Node>();
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