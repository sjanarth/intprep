package com.intprep.trees;

import java.util.HashSet;
import java.util.Set;

public class LevelOrderIterator<T> extends AbstractIterator<T>
{
	public LevelOrderIterator(BinaryTreeNode<T> node, int tgtlevel) {
		targetLevel = tgtlevel;
		currentNode = node;
		currentLevel = 1;
		pullNext();
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = stack.pop();
		processed.add(top);
		currentNode = (BinaryTreeNode<T>) currentNode.getParent();
		currentLevel--;
		pullNext();
		return top;
	}
	
	private void pullNext ()	{
		if (populate())
			return;
		while (currentNode != null) {
			if (currentNode.hasLeft() && !processed.contains(currentNode.getLeft()))	{
				currentNode = currentNode.getLeft();
				currentLevel++;
				if (populate()) break;
				continue;
			}
			if (currentNode.hasRight() && !processed.contains(currentNode.getRight()))	{
				currentNode = currentNode.getRight();
				currentLevel++;
				if (populate()) break;
				continue;
			}
			processed.add(currentNode);
			currentNode = (BinaryTreeNode<T>) currentNode.getParent();
			currentLevel--;
		}
	}
	
	private boolean populate()	{
		if (currentLevel == targetLevel && !processed.contains(currentNode))	{
			stack.push(currentNode);
			return true;
		}
		return false;
	}
	
	private void pullNextWorking ()	{
		if (currentLevel == targetLevel && !processed.contains(currentNode))	{
			stack.push(currentNode);
		} else	{
			while (currentNode != null) {
				if (currentNode.hasLeft() && !processed.contains(currentNode.getLeft()))	{
					currentNode = currentNode.getLeft();
					currentLevel++;
					pullNext();
					if (!stack.isEmpty() || currentNode == null) break;
				}
				if (currentNode.hasRight() && !processed.contains(currentNode.getRight()))	{
					currentNode = currentNode.getRight();
					currentLevel++;
					pullNext();
					if (!stack.isEmpty() || currentNode == null) break;
				}
				processed.add(currentNode);
				currentNode = (BinaryTreeNode<T>) currentNode.getParent();
				currentLevel--;
			}
		}
	}

	private int targetLevel = 0;
	private int currentLevel = 0;
	private BinaryTreeNode<T> currentNode = null;
	private Set<BinaryTreeNode<T>> processed = new HashSet<BinaryTreeNode<T>>();
}
