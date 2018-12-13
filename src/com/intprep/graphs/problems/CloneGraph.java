package com.intprep.graphs.problems;

import java.util.HashMap;
import java.util.Map;

import com.intprep.graphs.core.GraphUtils;
import com.intprep.graphs.core.Vertex;

public class CloneGraph 
{
	public static void main (String[] args) {
		Vertex<Integer> graph = GraphUtils.buildSampleIntGraph();
		System.out.println("Showing origianl graph: ");
		GraphUtils.showComponent(graph);
		System.out.println();
		System.out.println("Showing cloned graph: ");
		GraphUtils.showComponent(cloneGraph(graph, new HashMap<Vertex<Integer>, Vertex<Integer>>()));
	}
	
	private static Vertex<Integer> cloneGraph (Vertex<Integer> v, Map<Vertex<Integer>, Vertex<Integer>> clones)	{
		if (clones.containsKey(v))
			return clones.get(v);
		Vertex<Integer> clone = new Vertex<Integer>(v.getLabel());
		clones.put(v, clone);
		for (Vertex<Integer> n : v.getNeighbors()) {
			clone.addNeighbor(cloneGraph(n, clones));
		}
		return clone;
	}
}
