package com.intprep.strings.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TrieNode 
{
	private static final int DEFAULT_TOP_K = 3;
	public TrieNode () { 
		this(null, null); 
	}

	public TrieNode (Character ch, TrieNode p) { 
		c = ch; 
		freq = 0;
		children = new TreeMap<Character,TrieNode>(new NullCharComparator());
		parentNode = p;	// a more clever implementation could do away with this
		topNodes = new TrieNode[DEFAULT_TOP_K];
		for (int i = 0; i < DEFAULT_TOP_K; i++)
			topNodes[i] = null;
	}
	
	public Map<Character,TrieNode> getChildMap()	{
		return children;
	}
	
	public Integer getFrequency ()	{
		return freq;
	}
	
	public Integer setFrequency (Integer f)	{
		Integer old = freq;
		freq = f;
		return old;
	}
	
	public boolean isWord () {
		return c == null && children.isEmpty();
	}
	
	public boolean isRoot () {
		return c == null && !children.isEmpty();
	}
	
	public TrieNode[] crawl ()	{
		if (isWord()) {
			topNodes[0] = this;
		} else {
			for (TrieNode child : children.values())	{
				for (TrieNode topK : child.crawl())	{
					if (topK == null) break;
					for (int i = 0; i < DEFAULT_TOP_K; i++)	{
						if (topNodes[i] == null) {
							topNodes[i] = topK;
							break;
						} else if (topNodes[i].freq < topK.freq)	{
							for (int j = DEFAULT_TOP_K-1; j > i; j--)
								topNodes[j] = topNodes[j-1];
							topNodes[i] = topK;
							break;
						}
					}
				}
			}
		}
		return topNodes;
	}
	
	public TrieNode add(Queue<Character> q)	{
		Character nextChar = null;
		if (!q.isEmpty()) 
			nextChar = q.poll();
		TrieNode child = children.get(nextChar);
		if (child == null)	{
			child = new TrieNode(nextChar,this);
			children.put(nextChar, child);
		}
		if (nextChar != null)
			child.add(q);
		return child;
	}
	
	public TrieNode findNode(Queue<Character> qPrefix)	{
		if (qPrefix.isEmpty()) 
			return this;// children.get(null);
		Character nextChar = qPrefix.poll();
		if(!children.containsKey(nextChar)) 
			return null;
		TrieNode nextNode = children.get(nextChar);
		return nextNode.findNode(qPrefix);
	}
	
	public String getString ()  {
		StringBuilder sb = new StringBuilder();
		TrieNode curr = this;
		while (curr != null) {
			if (curr.c != null)
				sb.append(curr.c);
			curr = curr.parentNode;
		}
		return sb.reverse().toString();
	}
	
	public List<String> getAllChildStrings ()	{
		List<String> allStrings = new ArrayList<String>();
		if (isWord()) { 
			allStrings.add(""); 
			return allStrings; 
		}
		for(TrieNode child : children.values())	
			for (String s : child.getAllChildStrings()) 	
				allStrings.add(c+s);
		return allStrings;
	}
	
	public List<String> getTopChildStrings ()	{
		List<String> topStrings = new ArrayList<String>();
		for (TrieNode topNode : topNodes)	{
			if (topNode != null)	{
				StringBuilder sb = new StringBuilder();
				sb.append(topNode.getString());
				sb.append("("); sb.append(topNode.freq); sb.append(")");
				topStrings.add(sb.toString());
			}
		}
		return topStrings;
	}
	
	public String toString (int level) {
		StringBuilder sb = new StringBuilder();
		if (isRoot()) {
			sb.append("/");
			for (Character ch : children.keySet()) {
				sb.append("\n");
				TrieNode child = children.get(ch);
				sb.append(child.toString(level+1));
			}
		} else {
			for (int i = 1; i < level; i++) sb.append(" ");
			sb.append("\\_");
			if (isWord()) {
				sb.append("."); 
				sb.append("("); sb.append(freq); sb.append(")");
			} else {
				sb.append(c);
				for (Character ch : children.keySet()) {
					sb.append("\n");
					TrieNode child = children.get(ch);
					sb.append(child.toString(level+2));
				}
			}
		}
		return sb.toString();
	}
	
	private Integer freq = null;
	private Character c = null;
	private Map<Character,TrieNode> children = null;
	private TrieNode parentNode = null;
	private TrieNode[] topNodes = null;
	
	private static class NullCharComparator implements Comparator<Character>	{
		@Override
		public int compare(Character o1, Character o2) {
			if (o1 == null && o2 == null) return 0;
			if (o1 == null) return -1;
			if (o2 == null) return 1;
			return o1.compareTo(o2);
		}
	}
}