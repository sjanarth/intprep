package com.intprep.graphs.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DepthFirstIterator<T> implements Iterator<Vertex<T>>
{
	public DepthFirstIterator (Vertex<T> graph) {
		pushDepthFirst(graph);
	}
	
	@Override
	public boolean hasNext ()	{
		return !stack.isEmpty();
	}
	
	@Override
	public Vertex<T> next ()	{
		Vertex<T> top = stack.pop();
		if (!stack.isEmpty()) {
			Vertex<T> second = stack.peek();
			for (Vertex<T> n : second.getNeighbors())	{
				if (!processed.contains(n))	{
					pushDepthFirst(n);
					break;
				}
			}
		}
		return top;
	}
	
	private void pushDepthFirst (Vertex<T> graph) {
		Vertex<T> v = graph;
		while (v != null)	{
			stack.push(v);
			processed.add(v);
			Vertex<T> v_prev = v;
			v = null;
			for (Vertex<T> n : v_prev.getNeighbors())	{
				if (!processed.contains(n))	{
					v = n; 
					break;
				}
			}
		}
	}
	
	private Set<Vertex<T>> processed = new HashSet<Vertex<T>>();
	private Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
}