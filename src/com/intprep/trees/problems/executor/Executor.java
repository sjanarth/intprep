package com.intprep.trees.problems.executor;

import com.intprep.trees.problems.AbstractTreeProblem;
import com.intprep.trees.problems.BSTToLinkedList;
import com.intprep.trees.problems.ClosestLeaf;
import com.intprep.trees.problems.DeepestLeaf;
import com.intprep.trees.problems.DistanceBetweenNodes;
import com.intprep.trees.problems.IsBinarySearchTree;
import com.intprep.trees.problems.IsBinarySearchTree2;
import com.intprep.trees.problems.IsSubTree;
import com.intprep.trees.problems.IsSubTree2;
import com.intprep.trees.problems.LevelWithMostNodes;
import com.intprep.trees.problems.ListAllPaths;
import com.intprep.trees.problems.ListAllPaths2;
import com.intprep.trees.problems.LongestLeafToLeafPath;
import com.intprep.trees.problems.LowestCommonAncestor;
import com.intprep.trees.problems.MergeTwoBSTs;
import com.intprep.trees.problems.SortedArrayToBST;

public class Executor 
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
	};
	
	public static void main (String[] args) {
		for (AbstractTreeProblem problem : problems) {
			System.out.println("-------- "+problem.getClass().getSimpleName()+" --------");
			problem.executeAllTestCases();
		}
	}
}