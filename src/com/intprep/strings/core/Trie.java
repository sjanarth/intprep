package com.intprep.strings.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trie
{
	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode add (String word) {
		//System.out.println("Trie.add, s="+s);
		word = word.toLowerCase();	// done typically to minimize the overall size of the trie
		Queue<Character> q = toCharQueue(word);
		return root.add(q);
	}
	
	public List<String> searchAlpha (String prefix)	{
		System.out.println("searchAlpha, prefix="+prefix);
		Queue<Character> q = toCharQueue(prefix);
		TrieNode node = root.findNode(q);
		if (node != null)	{
			//System.out.println(node.toString(0));
			/*
			prefix = prefix.substring(0, prefix.length()-1);
			List<String> results = new ArrayList<String>();
			for (String s : node.getAllChildStrings())
				results.add(prefix+s);
			*/
			return node.getAllChildStrings();
		}
		return new ArrayList<String>();
	}
	
	public List<String> searchTopK (String prefix)	{
		System.out.println("searchTopK, prefix="+prefix);
		Queue<Character> q = toCharQueue(prefix);
		TrieNode node = root.findNode(q);
		if (node != null)	{
			//System.out.println(node.toString(0));	
			return node.getTopChildStrings();
		}
		return new ArrayList<String>();
	}
	
	public Integer update (String s, int freq)	{
		Queue<Character> qPrefix = toCharQueue(s);
		TrieNode node = root.findNode(qPrefix);
		if (node == null)
			node = add(s);
		return node.getChildMap().get(null).setFrequency(freq);
	}
	
	public void crawl ()	{
		root.crawl();
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append(root.toString(0));
		return sb.toString();
	}
	
	private Queue<Character> toCharQueue(String s) {
		Queue<Character> q = new LinkedList<Character>();
		for (Character c : s.toCharArray())
			q.add(c);
		return q;
	}
	
	private TrieNode root = null;
}