package com.intprep.trees.core;

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
		if (!stack.isEmpty()) {
			BinaryTreeNode<T> next = stack.peek();
			BinaryTreeNode<T> right = next.getRight();
			if (right != null && !isProcessed(right))	{
				pushLeft(right);
			}
		}
		return top;
	}
}