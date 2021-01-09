package com.coreds.trees.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterator<T> implements Iterator<BinaryTreeNode<T>>
{
	public LevelOrderIterator(BinaryTreeNode<T> node) {
		queue.add(node);
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> head = queue.poll();
		if (head.hasLeft()) queue.add(head.getLeft());
		if (head.hasRight()) queue.add(head.getRight());
		return head;
	}

	private Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
}