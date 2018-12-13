package com.intprep.graphs.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstIterator<T> implements Iterator<Vertex<T>>
{
	public BreadthFirstIterator (Vertex<T> v) {
		if (v != null)	{
			queue.add(v);
		}
	}
	
	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public Vertex<T> next() {
		Vertex<T> head = queue.poll();
		processed.add(head);
		queueChildren(head);
		return head;
	}
	
	protected void queueChildren(Vertex<T> v) {
		for (Vertex<T> n : v.getNeighbors())	
			if (!queue.contains(n) && !processed.contains(n))
				queue.add(n);
	}

	private Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
	private Set<Vertex<T>> processed = new HashSet<Vertex<T>>();
}