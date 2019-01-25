package com.intprep.strings.core;

import java.util.HashMap;
import java.util.Map;

public class TrieNode 
{
	public TrieNode getRoot() { return root; }
	public Map<Character, TrieNode> getChildren() { return children; }
	public boolean isEndOfWord() { return endOfWord; }

	public void add (String w)	{
		TrieNode current = root;
		for (int i = 0; i < w.length(); i++) {
			char ch = w.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null)	{
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	public boolean search (String w)	{
		TrieNode current = root;
		for (int i = 0; i < w.length(); i++) {
			char ch = w.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) return false;
			current = node;
		}
		return current.isEndOfWord();
	}
	
	private TrieNode root = null;
	private Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
	private boolean endOfWord = false;
}
