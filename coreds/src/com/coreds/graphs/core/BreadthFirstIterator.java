package com.coreds.graphs.core;

import java.util.*;

public class BreadthFirstIterator<T> implements Iterator<Vertex<T>>
{
	public BreadthFirstIterator (Vertex<T> v) {
		if (v != null)	{
			visited.add(v);
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
		if (head.hasNeighbors())	{
			for (Vertex<T> n : head.getNeighbors())	{	
				if (!visited.contains(n))	{
					visited.add(n);
					queue.offer(n);
				}
			}
		}
		return head;
	}
	
	private Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
	private Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
}