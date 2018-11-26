package com.intprep.trees;

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
		BinaryTreeNode<T> top = popStack();
		currentNode = (BinaryTreeNode<T>) currentNode.getParent();
		currentLevel--;
		pullNext();
		return top;
	}
	
	private void pullNext ()	{
		if (populate())
			return;
		while (currentNode != null) {
			BinaryTreeNode<T> left = currentNode.getLeft();
			BinaryTreeNode<T> right = currentNode.getRight();
			if (left != null && !isProcessed(left))	{
				currentNode = left;
				currentLevel++;
				if (populate()) break;
				continue;
			}
			if (right != null && !isProcessed(right))	{
				currentNode = right;
				currentLevel++;
				if (populate()) break;
				continue;
			}
			process(currentNode);
			currentNode = (BinaryTreeNode<T>) currentNode.getParent();
			currentLevel--;
		}
	}
	
	private boolean populate()	{
		if (currentLevel == targetLevel && !isProcessed(currentNode))	{
			stack.push(currentNode);
			return true;
		}
		return false;
	}
	
	private int targetLevel = 0;
	private int currentLevel = 0;
	private BinaryTreeNode<T> currentNode = null;
}