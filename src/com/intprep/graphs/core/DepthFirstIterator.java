package com.intprep.graphs.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DepthFirstIterator<T> implements Iterator<Vertex<T>>
{
	public DepthFirstIterator (Vertex<T> v) {
		walkDepthFirst(v);
	}
	
	@Override
	public boolean hasNext ()	{
		return !stack.isEmpty();
	}
	
	@Override
	public Vertex<T> next ()	{
		Vertex<T> top = stack.pop();
		processed.add(top);
		return top;
	}
	
	private void walkDepthFirst (Vertex<T> v) {
		if (v != null && !stack.contains(v) && !processed.contains(v))	{
			stack.push(v);
			for (Vertex<T> n : v.getNeighbors())	{
				walkDepthFirst(n);
			}
		}
	}
	
	private Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
	private Set<Vertex<T>> processed = new HashSet<Vertex<T>>();
}