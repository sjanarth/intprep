package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.intprep.graphs.core.Vertex;

/*
 * You are given a dictionary of words and two strings named start and stop.
 * How can you convert string start to string stop, by changing only one character 
 * at a time and making sure that: 
 * 	  1) all the intermediate words are in the given dictionary of words and 
 * 	  2) minimum number of intermediate words are used?
 * Generally, dictionary does not contain duplicate values, but for the 
 * sake of this problem, assume that dictionary might have duplicate values.
 * 
 * Input Format:
 * 	  There are three arguments: 
 * 		(a) First is an array of strings denoting the dictionary of words
 * 		(b) Second is a string start and 
 * 		(c) Third is a string stop.
 * Output Format:
 * 	  Return an array of strings.
 * 		If transformation is possible then 
 * 			in returned array, first string should be start, last string should be stop 
 * 			and in between strings of given dictionary that you used for transformation, 
 * 			in the same order they are used in your transformation.
 *  	If transformation is not possible then 
 *  		returned array should contain only one string "-1".
 *  	If there are multiple valid transformations, you are free to return any one of them.
 */
public class WordLadder 
{
	public static void main (String[] args) {
		buildWordLadder (new String[] {"CAT", "CUT", "BAT", "BIT", "BOX", "BUT", "FAT", "FIT", "FIX", "FOX"}, "CAT", "BOX");
	}
	
	private static String[] buildWordLadder (String[] words, String start, String end) {
		Set<String> words2 = preProcessInputs (words, start, end);
		Map<String,Vertex<String>> graph = buildGraph(words2);
		Map<Vertex<String>, Vertex<String>> backRefs = new HashMap<Vertex<String>, Vertex<String>>();
		Queue<Vertex<String>> queue = new LinkedList<Vertex<String>>();
		backRefs.put(graph.get(start), null);
		queue.add(graph.get(start));
		while (!queue.isEmpty())	{
			Vertex<String> v = queue.poll();
			//System.out.println("Dequeued "+v.getLabel());
			boolean found = false;
			for (Vertex<String> n : v.getNeighbors())	{
				//System.out.println("   neighbor="+n.getLabel());
				if (!backRefs.containsKey(n))	{
					backRefs.put(n, v);
					if (n.equals(graph.get(end)))	{
						//System.out.println("Found "+end);
						found = true;
						break;
					}
					queue.add(n);
				}
			}
			if (found) break;
		}
		if (!backRefs.containsKey(graph.get(end)))	{
			System.out.println("No path exists from "+start+" to "+end);
			return new String[] { "-1" };
		} else {
			List<String> list = new ArrayList<String>();
			Vertex<String> curr = graph.get(end);
			list.add(curr.getLabel());
			while (curr != null)	{
				if (backRefs.get(curr) != null)	{
					list.add(backRefs.get(curr).getLabel());
				}
				curr = backRefs.get(curr);
			}
			Collections.reverse(list);
			String[] path = list.toArray(new String[0]);
			for (String p : path) 
				System.out.print(p+" ");
			return path;
		}
	}
	
	private static Set<String> preProcessInputs(String[] words, String start, String end){
		Set<String> set = new HashSet<String>();
		set.add(start);
		set.add(end);
		set.addAll(Arrays.asList(words));
		return set;
	}
	
	/*
	 * Reference:
	 * https://interactivepython.org/runestone/static/pythonds/Graphs/BuildingtheWordLadderGraph.html
	 */
	private static Map<String,Vertex<String>> buildGraph(Set<String> words)	{
		Map<String,Vertex<String>> allVs = createVertices (words);
		Map<String,Set<String>> buckets = groupWordsIntoBuckets (words);
		connectNeighboringVertices (allVs, buckets);
		return allVs;	
	}
	
	private static Map<String,Vertex<String>> createVertices (Set<String> words)	{
		Map<String,Vertex<String>> allVs = new HashMap<String,Vertex<String>>();
		for (String w : words)	{
			if (!allVs.containsKey(w))
				allVs.put(w, new Vertex<String>(w));
		}
		return allVs;
	}
	
	private static Map<String,Set<String>> groupWordsIntoBuckets (Set<String> words)	{
		Map<String,Set<String>> buckets = new HashMap<String,Set<String>>();
		for (String w : words) {
			for (int i = 0; i < w.length(); i++) {
				String b = w.substring(0, i) + "_" + w.substring(i+1);
				if (buckets.containsKey(b))	{
					buckets.get(b).add(w);
				} else {
					Set<String> s = new HashSet<String>();
					s.add(w);
					buckets.put(b,s);
				}
			}
		}
		return buckets;
	}
	
	private static void connectNeighboringVertices (Map<String,Vertex<String>> allVs, Map<String,Set<String>> buckets)	{
		for (String b : buckets.keySet()) {
			Set<String> neighbors = buckets.get(b);
			for (String n1 : neighbors) {
				for (String n2 : neighbors) {
					if (!n1.equals(n2))
						connectVertices (allVs.get(n1), allVs.get(n2));
				}
			}
		}
	}
	
	private static void connectVertices (Vertex<String> v1, Vertex<String> v2) {
		v1.addNeighbor(v2);
		v2.addNeighbor(v1);
	}
}
