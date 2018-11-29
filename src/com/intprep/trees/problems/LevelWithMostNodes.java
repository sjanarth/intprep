package com.intprep.trees.problems;

import java.util.HashMap;
import java.util.Map;

public class LevelWithMostNodes extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new LevelWithMostNodes().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root)	{
		printLevelsAndCounts(root);
    }
	
    private static void addLevelsAndCounts (int level, Node node, Map<Integer,Integer> counts) {
    	if (node != null)	{
    		Integer count = counts.get(level);
    		if (count == null)	count = 1;
    		else count++;
    		counts.put(level, count);
    		addLevelsAndCounts(level+1, node.left, counts);
    		addLevelsAndCounts(level+1, node.right, counts);
    	}
    }
    
    private static void printLevelsAndCounts (Node root) {
    	Map<Integer, Integer> counts = new HashMap<Integer,Integer>();
    	if (root != null)	{
    		counts.put(1, 1);
			addLevelsAndCounts(2, root.left, counts);
			addLevelsAndCounts(2, root.right, counts);
    	}
    	Integer maxLevel = 0, maxCount = 0;
    	for (Integer level : counts.keySet())	{
    		Integer count = counts.get(level);
    		System.out.println("Level="+level+", count="+counts.get(level));
    		if (maxCount < count)	{
    			maxLevel = level;
    			maxCount = count;
    		}
    	}
    	System.out.println("Level with max nodes="+maxLevel+", count="+maxCount);
    }
}