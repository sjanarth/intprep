package com.intprep.graphs.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphUtils 
{
	public static void showGraph (Vertex<Integer> graph) 
	{
		//Vertex<Integer> graph = buildSampleGraph();
		Iterator<Vertex<Integer>> it = new DepthFirstIterator<Integer>(graph);
		System.out.print("Depth first:    ");
		while (it.hasNext())	System.out.print(it.next().getLabel()+" ");
		System.out.println();
		System.out.print("Breadth first:  ");
		it = new BreadthFirstIterator<Integer>(graph);
		while (it.hasNext())	System.out.print(it.next().getLabel()+" ");
		System.out.println();
		System.out.println("Adjacency List: ");
		printAdjacencyList(graph, new HashSet<Vertex<Integer>>(), new HashSet<String>());
	}
	
	private static void printAdjacencyList(Vertex<Integer> v, Set<Vertex<Integer>> verticesDone, Set<String> edgesDone) {
		if (verticesDone.contains(v))
			return;
		StringBuilder sb = new StringBuilder(String.valueOf(v.getLabel()+": "));
		for (Vertex<Integer> n : v.getNeighbors())	{
			String edge = getEdgeAsString(v, n);
			if (!edgesDone.contains(edge))	{
				sb.append(edge+" ");
			}
		}
		System.out.println(sb.toString());
		verticesDone.add(v);
		for (Vertex<Integer> n : v.getNeighbors())	{
			String edge = getEdgeAsString(v, n);
			if (!edgesDone.contains(edge))	{
				edgesDone.add(edge);
				printAdjacencyList(n, verticesDone, edgesDone);
			}
		}
	}
	
	private static String getEdgeAsString(Vertex<Integer> v, Vertex<Integer> n) {
		StringBuilder sb = new StringBuilder("{"+String.valueOf(v.getLabel()));
		sb.append(",");
		sb.append(String.valueOf(n.getLabel())+"}");
		return sb.toString();
	}
	
	public static Vertex<Integer> buildSampleGraph ()	
	{
		Vertex<Integer> v1 = new Vertex<Integer>(1);
		Vertex<Integer> v2 = new Vertex<Integer>(2);
		v1.addNeighbor(v2);
		Vertex<Integer> v3 = new Vertex<Integer>(3);
		v2.addNeighbor(v3);
		v2.addNeighbor(new Vertex<Integer>(4));
		Vertex<Integer> v5 = new Vertex<Integer>(5);
		v3.addNeighbor(v5);
		Vertex<Integer> v6 = new Vertex<Integer>(6);
		v3.addNeighbor(v6);
		v5.addNeighbor(v6);
		v6.addNeighbor(v3);
		v6.addNeighbor(v5);
		return v1;
	}
}