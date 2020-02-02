package com.intprep.trees.problems;

public class TreesExecutor 
{
	private static AbstractTreeProblem[] problems = {
		new BSTToLinkedList(),	
		new CloneTree(),
		new ClosestLeaf(),
		new ConnectSiblings(),
		new ConnectSiblings2(),
		new DeepestLeaf(),
		new DistanceBetweenNodes(),
		new FlipBinaryTree(),
		new IsBinarySearchTree(),
		new IsBinarySearchTree2(),
		new IsBinarySearchTree3(),
		new IsSubTree(),
		new IsSubTree2(),
		new LevelWithMostNodes(),
		new ListAllPaths(),
		new ListAllPaths2(),
		new ListAllPaths3(),
		new LongestLeafToLeafPath(),
		new LowestCommonAncestor(),
		new MergeTwoBSTs(),
		new RebuildTree(),
		new RightSideView(),
		new SerializeDeserialize(),
		new SortedArrayToBST(),
	};
	
	public static void main (String[] args) {
		for (AbstractTreeProblem problem : problems) {
			System.out.println("-------- "+problem.getClass().getSimpleName()+" --------");
			problem.executeAllTestCases();
		}
	}
}