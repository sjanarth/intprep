package com.intprep.graphs.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DepthFirstIterator<T> implements Iterator<Vertex<T>>
{
	public DepthFirstIterator (Vertex<T> v) {
		if (v != null)	{
			visited.add(v);
			stack.push(v);
		}
	}
	
	@Override
	public boolean hasNext ()	{
		return !stack.isEmpty();
	}
	
	@Override
	public Vertex<T> next ()	{
		Vertex<T> top = stack.pop();
		if (top.hasNeighbors())	{
			for (Vertex<T> n : top.getNeighbors())	{
				if (!visited.contains(n))	{
					visited.add(n);
					stack.push(n);
				}
			}
		}
		return top;
	}
	
	private Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
	private Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
}