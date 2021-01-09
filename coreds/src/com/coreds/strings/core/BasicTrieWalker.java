package com.coreds.strings.core;

import java.util.ArrayDeque;
import java.util.Queue;

public class BasicTrieWalker 
{
	public void walkDfs (BasicTrieNode node)	{
		if (node == null) return;
		for (BasicTrieNode child : node.getChildMap().values())	
			walkDfs(child);
		processNode (node);
	}
	
	public void walkBfs (BasicTrieNode node)	{
		if (node == null) return;
		Queue<BasicTrieNode> qNodes = new ArrayDeque<BasicTrieNode>();
		qNodes.add(node);
		while (!qNodes.isEmpty())	{
			BasicTrieNode curr = qNodes.poll();
			processNode (curr);
			qNodes.addAll(curr.getChildMap().values());
		}
	}
	
	public void processNode (BasicTrieNode node)	{
		System.out.println(node.getString());
	}
}
