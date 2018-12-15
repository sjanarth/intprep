package com.intprep.graphs.problems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.intprep.graphs.core.Vertex;

/*
 * Given a sorted dictionary of an alien language. 
 * You have to find the order of characters in that language.
 * 
 *  Input:
 *  	There is only one argument, array of strings 
 *  	which denotes sorted dictionary of an alien language. 
 * 	Output:
 * 		Return a string denoting order of characters in the alien language. 
 */
public class AlienDictionary 
{
	public static void main (String[] args) {
		findAlienAlphabet (new String[] {
				"dca", "dbc", "dab", "dfb", "cba", "cac", "caa", "bb"
			});
	}
	
	private static void findAlienAlphabet (String[] words)	{
		Collection<Vertex<Character>> graph = buildGraph (words);
		topologicalSort (graph);
	}
	
	private static Collection<Vertex<Character>> buildGraph (String[] words)	{
		Map<Character,Vertex<Character>> allVs = new HashMap<Character,Vertex<Character>>();
		for (int i = 0; i < words.length-1; i++) {
			if (!words[i].equals(words[i+1])) {
				processWordPair (words[i], words[i+1], allVs);
			}
		}
		return allVs.values();
	}
	
	private static void processWordPair (String w1, String w2, Map<Character,Vertex<Character>> allVs) {
		int i = 0, j = 0;
		while (i < w1.length() && j < w2.length())	{
			if (w1.charAt(i) != w2.charAt(j))	{
				Vertex<Character> v1 = findOrCreateVertex(w1.charAt(i), allVs);
				Vertex<Character> v2 = findOrCreateVertex(w2.charAt(j), allVs);
				v1.addNeighbor(v2);
				return;
			}
			i++;
			j++;
		}
	}
	
	private static Vertex<Character> findOrCreateVertex (Character ch, Map<Character,Vertex<Character>> allVs)	{
		if (allVs.keySet().contains(ch)) {
			return allVs.get(ch);
		} else {
			Vertex<Character> v = new Vertex<Character>(ch);
			allVs.put(ch, v);
			return v;
		}
	}
	
	private static void topologicalSort (Collection<Vertex<Character>> allVs)	{
		Stack<Vertex<Character>> stack = new Stack<Vertex<Character>>();
		for (Vertex<Character> v : allVs) {
			topologicalSort (v, stack);
		}
		System.out.print("Alient alphabet is { "); 
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getLabel()+" ");
		}
		System.out.println("}");
	}
	
	private static void topologicalSort (Vertex<Character> v, Stack<Vertex<Character>> stack) {
		for (Vertex<Character> n : v.getNeighbors()) {
			if (!stack.contains(n))
				topologicalSort(n, stack); 
		}
		if (!stack.contains(v))
			stack.push(v);
	}
}