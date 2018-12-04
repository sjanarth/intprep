package com.intprep.trees.problems;

public class TreesExecutor 
{
	private static AbstractTreeProblem[] problems = {
		new BSTToLinkedList(),	
		new ClosestLeaf(),
		new DeepestLeaf(),
		new DistanceBetweenNodes(),
		new IsBinarySearchTree(),
		new IsBinarySearchTree2(),
		new IsSubTree(),
		new IsSubTree2(),
		new LevelWithMostNodes(),
		new ListAllPaths(),
		new ListAllPaths2(),
		new LongestLeafToLeafPath(),
		new LowestCommonAncestor(),
		new MergeTwoBSTs(),
		new SortedArrayToBST(),
		new FlipBinaryTree(),
	};
	
	public static void main (String[] args) {
		for (AbstractTreeProblem problem : problems) {
			System.out.println("-------- "+problem.getClass().getSimpleName()+" --------");
			problem.executeAllTestCases();
		}
	}
}