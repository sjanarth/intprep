package com.coreds.graphs.core;

import java.util.*;

public class TopologicalSortIterator<T> implements Iterator<Vertex<T>>
{
	public TopologicalSortIterator (Collection<Vertex<T>> graph)	{
		if (graph != null)	{
			for (Vertex<T> v : graph)	{
				topologicalSort(v);
			}
		}
	}
	
	public TopologicalSortIterator (Vertex<T> v) {
		topologicalSort (v);
	}
	
	private void topologicalSort (Vertex<T> v)	{
		if (v != null && !visited.contains(v))	{
			visited.add(v);
			if (v.hasNeighbors()) {
				for (Vertex<T> n : v.getNeighbors())	{
					if (!visited.contains(n))	{
						topologicalSort(n);
					}
				}
			}
			stack.push(v);
		}
	}
	
	@Override
	public boolean hasNext ()	{
		return !stack.isEmpty();
	}
	
	@Override
	public Vertex<T> next ()	{
		return stack.pop();
	}
	
	private Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
	private Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
}