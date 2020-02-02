package com.intprep.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView extends AbstractTreeProblem 
{
	public static void main(String[] args) {
		new RightSideView().executeAllTestCases();
	}
	
	@Override
	protected void mainLogic(Node root) {
		List<Integer> rView = new ArrayList<Integer>();
		rightSideView (root, rView);
		System.out.print("Right Side view {");
		for (int i = 0; i < rView.size(); i++)	{
			if (i > 0) System.out.print(" => ");
			System.out.print(rView.get(i));;
		}
		System.out.println("}");
	}
	
	private static void rightSideView (Node root, List<Integer> rView, int level)	{
		if (root == null) return;
		// this ensue only the first element in that level gets added to the list
		if (level == rView.size())
			rView.add(root.data);
		// notice that we first process the right node 	
		// flip the order to get left side view
		rightSideView(root.right, rView, level+1);
		rightSideView(root.left, rView, level+1);
	}
	
	private static void rightSideView (Node root, List<Integer> rView) {
		if (root == null) return;
		Queue<Node> q1 = new LinkedList<Node>();
		q1.offer(root);
		Queue<Node> q2 = new LinkedList<Node>();
		while (!q1.isEmpty())	{
			Node cur = q1.poll();
			if (cur.left != null) q2.offer(cur.left);
			if (cur.right != null) q2.offer(cur.right);
			if (q1.isEmpty()) {
				rView.add(cur.data);
				while (!q2.isEmpty())
					q1.offer(q2.poll());
			}
		}
	}
}