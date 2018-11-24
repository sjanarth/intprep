package com.intprep.trees;

import java.util.HashSet;
import java.util.Set;

public class PreOrderIterator<T> extends AbstractIterator<T> 
{
	public PreOrderIterator(BinaryTreeNode<T> node) {
		if (node != null)	
			stack.push(node);
		processed = new HashSet<BinaryTreeNode<T>>();
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = stack.pop();
		if (top.hasRight())
			stack.push(top.getRight());
		if (top.hasLeft())
			stack.push(top.getLeft());
		return top;
	}
	
	public BinaryTreeNode<T> nextOld() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = stack.pop();
		processed.add(top);
		BinaryTreeNode<T> curr = top;
		while (curr != null) {
			if (!processed.contains(curr))	{
				stack.push(curr); break;
			} else {
				BinaryTreeNode<T> left = curr.getLeft();
				BinaryTreeNode<T> right = curr.getRight();
				if (left != null && !processed.contains(left))	{
					stack.push(left); break;
				} else if (right != null && !processed.contains(right))	{
					stack.push(right); break;
				}
			}
			curr = (BinaryTreeNode<T>) curr.getParent();
		}
		return top;
	}
	
	private Set<BinaryTreeNode<T>> processed = null;
}
