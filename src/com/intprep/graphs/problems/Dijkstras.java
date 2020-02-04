package com.intprep.graphs.problems;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.intprep.graphs.core.Edge;

public class Dijkstras 
{
	public static void main (String[] args) {
		Collection<Edge<Integer>> edges = buildSampleGraph();
		findAllMinDistances (edges, 1);
		//findMinDistance (edges, 2, 6);
	}

	private static Collection<Edge<Integer>> buildSampleGraph() {
		Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
		edges.add(new Edge<Integer> (1, 2, 2));
		edges.add(new Edge<Integer> (1, 3, 12));
		edges.add(new Edge<Integer> (2, 3, 3));
		edges.add(new Edge<Integer> (2, 4, 8));
		edges.add(new Edge<Integer> (2, 5, 4));
		edges.add(new Edge<Integer> (3, 4, 4));
		edges.add(new Edge<Integer> (3, 5, 9));
		edges.add(new Edge<Integer> (4, 6, 4));
		edges.add(new Edge<Integer> (5, 6, 28));
		return edges;
	}
	
	private static void findAllMinDistances (Collection<Edge<Integer>> edges, int start) {
		PriorityQueue<Edge<Integer>> queue = new PriorityQueue<Edge<Integer>>(new EdgeComparator());
		Map<Integer,Integer> distances = new HashMap<Integer,Integer>();
		distances.put(start, 0);
		Map<Integer,Integer> backRefs = new HashMap<Integer,Integer>();
		for (Edge<Integer> e : edges) {
			if (!e.getTo().equals(start))	{
				distances.put(e.getTo(), Integer.MAX_VALUE);
				backRefs.put(e.getTo(), null);
			}
		}
	}
	
	private static class EdgeComparator implements Comparator<Edge<Integer>>	{
		@Override
		public int compare(Edge<Integer> o1, Edge<Integer> o2) {
			return -1;
		}
	}
}
