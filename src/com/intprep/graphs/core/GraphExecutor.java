package com.intprep.graphs.core;

public class GraphExecutor 
{
	public static void main (String[] args) {
		Vertex<Integer> graph = buildSampleGraph();
		DepthFirstIterator<Integer> it = new DepthFirstIterator<Integer>(graph);
		while (it.hasNext())	{
			System.out.print(it.next().getLabel()+" ");
		}
	}
	
	private static Vertex<Integer> buildSampleGraph ()	{
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
