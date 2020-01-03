package com.intprep.graphs.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GraphUtils 
{
	public static void main (String[] args) {
		Vertex<Integer> graph = buildSampleIntGraph();
		showComponent (graph);
	}
	
	public static <T> void showComponent (Vertex<T> comp)
	{
		Iterator<Vertex<T>> it = new DepthFirstIterator<T>(comp);
		System.out.print("Depth first:    ");
		while (it.hasNext())	System.out.print(it.next().getLabel()+" ");
		System.out.println();
		System.out.print("Breadth first:  ");
		it = new BreadthFirstIterator<T>(comp);
		while (it.hasNext())	System.out.print(it.next().getLabel()+" ");
		System.out.println();
		System.out.print("Topological Sort:  ");
		it = new TopologicalSortIterator<T>(comp);
		while (it.hasNext())	System.out.print(it.next().getLabel()+" ");
		System.out.println();
		System.out.println("Adjacency list: ");
		printAdjacencyList(comp, new HashSet<Vertex<T>>(), new HashSet<String>());
	}

	private static <T> void printAdjacencyList(Vertex<T> v, Set<Vertex<T>> verticesDone, Set<String> edgesDone) {
		if (verticesDone.contains(v))
			return;
		StringBuilder sb = new StringBuilder(String.valueOf(v.getLabel()+": "));
		for (Vertex<T> n : v.getNeighbors())	{
			String edge = getEdgeAsString(v, n);
			if (!edgesDone.contains(edge))	{
				sb.append(edge+" ");
			}
		}
		System.out.println(sb.toString());
		verticesDone.add(v);
		for (Vertex<T> n : v.getNeighbors())	{
			String edge = getEdgeAsString(v, n);
			if (!edgesDone.contains(edge))	{
				edgesDone.add(edge);
				printAdjacencyList(n, verticesDone, edgesDone);
			}
		}
	}

	private static <T> String getEdgeAsString(Vertex<T> v, Vertex<T> n) {
		StringBuilder sb = new StringBuilder("{"+String.valueOf(v.getLabel()));
		sb.append(",");
		sb.append(String.valueOf(n.getLabel())+"}");
		return sb.toString();
	}
	
	public static Vertex<Integer> buildSampleIntGraph ()	
	{
		Vertex<Integer> v1 = null;
		Map<Integer, Vertex<Integer>> allVs = new HashMap<Integer, Vertex<Integer>>();
		for (int i = 1; i < 8; i++)	{
			Vertex<Integer> vi = new Vertex<Integer>(i); 
			allVs.put(i, vi);
			if (i == 1)
				v1 = vi;
		}
		connectVertices (allVs.get(1), allVs.get(2));
		connectVertices (allVs.get(1), allVs.get(3));
		connectVertices (allVs.get(2), allVs.get(4));
		connectVertices (allVs.get(3), allVs.get(4));
		connectVertices (allVs.get(4), allVs.get(5));
		connectVertices (allVs.get(4), allVs.get(6));
		connectVertices (allVs.get(5), allVs.get(7));
		connectVertices (allVs.get(6), allVs.get(7));
		return v1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void connectVertices (Vertex vi, Vertex vj) {
		vi.addNeighbor(vj);
		vj.addNeighbor(vi);
	}

	public static Vertex<String> buildSampleStringGraph ()	
	{
		String[] words = new String[] { "One", "Two", "Three", "Four", "Five", "Six", "Seven" }; 
		Vertex<String> v1 = null;
		Map<String, Vertex<String>> allVs = new HashMap<String, Vertex<String>>();
		for (int i = 1; i < 8; i++)	{
			Vertex<String> vi = new Vertex<String>(words[i-1]); 
			allVs.put(words[i-1], vi);
			if (i == 1)
				v1 = vi;
		}
		connectVertices (allVs.get("One"), allVs.get("Two"));
		connectVertices (allVs.get("One"), allVs.get("Three"));
		connectVertices (allVs.get("Two"), allVs.get("Four"));
		connectVertices (allVs.get("Three"), allVs.get("Four"));
		connectVertices (allVs.get("Four"), allVs.get("Five"));
		connectVertices (allVs.get("Four"), allVs.get("Six"));
		connectVertices (allVs.get("Five"), allVs.get("Seven"));
		connectVertices (allVs.get("Six"), allVs.get("Seven"));
		return v1;
	}
}