package com.intprep.trees;

import java.util.HashSet;
import java.util.Set;

public class PostOrderIterator<T> extends AbstractIterator<T> 
{
	public PostOrderIterator(BinaryTreeNode<T> node) {
		pushLeft(node);
		processed = new HashSet<BinaryTreeNode<T>>();
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = stack.pop();
		processed.add(top);
		BinaryTreeNode<T> curr = top;
		while (curr != null) {
			BinaryTreeNode<T> left = curr.getLeft();
			BinaryTreeNode<T> right = curr.getRight();
			if (left != null && !processed.contains(left))	{
				pushLeft(left); break;
			} else if (right != null && !processed.contains(right))	{
				pushLeft(right); break;
			} else if (!processed.contains(curr))	{
				break;
			}
			curr = (BinaryTreeNode<T>) curr.getParent();
		}
		return top;
	}
	
	private Set<BinaryTreeNode<T>> processed = null;
}