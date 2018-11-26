package com.intprep.trees;

public class PostOrderIterator<T> extends AbstractIterator<T> 
{
	public PostOrderIterator(BinaryTreeNode<T> node) {
		pushLeft(node);
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = popStack();
		BinaryTreeNode<T> curr = top;
		while (curr != null) {
			BinaryTreeNode<T> left = curr.getLeft();
			BinaryTreeNode<T> right = curr.getRight();
			if (left != null && !isProcessed(left))	{
				pushLeft(left); break;
			} else if (right != null && !isProcessed(right))	{
				pushLeft(right); break;
			} else if (!isProcessed(curr))	{
				break;
			}
			curr = (BinaryTreeNode<T>) curr.getParent();
		}
		return top;
	}
}