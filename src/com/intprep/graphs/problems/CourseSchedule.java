package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3070/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
 * 		course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
 * 		courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
 * 		So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * 
 * Note:
 * 
 * 		The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * 		You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {

	public static void main(String[] args) {
		//int[] order = findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
		int[] order = findOrder(2, new int[][] {{1,0},{0,1}});
		System.out.println("Ordering = "+Arrays.toString(order));
	}

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	Map<Integer,Set<Integer>> graph = buildGraph(numCourses, prerequisites);
    	List<Integer> order = new ArrayList<>();
    	Set<Integer> visited = new HashSet<>();
    	Set<Integer> visiting = new HashSet<>();
    	Stack<Integer> stack = new Stack<Integer>();
    	for (Integer v : graph.keySet()) {
    		boolean cyclic = topologicalSort(graph, v, stack, visited, visiting);
    		if (cyclic)	{
    			return new int[] {};
    		}
    	}
    	while (!stack.isEmpty())
    		order.add(stack.pop());
    	int[] orderArray = new int[order.size()];
    	for (int i = 0; i < orderArray.length; i++)
    		orderArray[i] = order.get(i);
    	return orderArray;
    }
    
    private static boolean topologicalSort (Map<Integer,Set<Integer>> graph, Integer v, Stack<Integer> stack, Set<Integer> visited, Set<Integer> visiting) {
    	if (visited.contains(v)) return false;
    	visiting.add(v);
    	for (Integer i : graph.get(v))	{
    		if (visiting.contains(i))
    			return true;
    		boolean cyclic = topologicalSort(graph, i, stack, visited, visiting);
    		if (cyclic) return true;
    	}
    	stack.push(v);
    	visiting.remove(v);
    	visited.add(v);
    	return false;
    }
    
    private static Map<Integer,Set<Integer>> buildGraph(int numCourses, int[][] prerequisites)	{
    	Map<Integer,Set<Integer>> graph = new HashMap<>();
    	for (int i = 0; i < numCourses; i++)
    		graph.put(i, new HashSet<>());
    	for (int i = 0; i < prerequisites.length; i++)	{
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    	return graph;
    }
}
