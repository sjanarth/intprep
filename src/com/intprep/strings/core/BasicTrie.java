package com.intprep.strings.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BasicTrie
{
	public BasicTrie() {
		root = new BasicTrieNode();
		properties = new HashMap<Object,Object>(); 
	}
	
	public BasicTrie (Class<? extends BasicTrieNode> subClass) {
		if (BasicTrieNode.class.isAssignableFrom(subClass))	{
			try {
				Constructor<? extends BasicTrieNode> c = subClass.getConstructor(new Class[] {});
				root = c.newInstance(new Object[] {});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else 
		{
			throw new IllegalStateException("Class " + subClass + " not s subclass of BasicTrieNode");
		}
	}
	
	public BasicTrieNode add (String word) {
		//System.out.println("Trie.add, s="+s);
		word = word.toLowerCase();	// done typically to minimize the overall size of the trie
		Queue<Character> q = toCharQueue(word);
		return root.add(q);
	}
	
	public List<String> searchAlpha (String prefix)	{
		System.out.println("searchAlpha, prefix="+prefix);
		Queue<Character> q = toCharQueue(prefix);
		BasicTrieNode node = root.findNode(q);
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
	
	public Object getProperty (Object key)	{
		return properties.get(key);
	}
	
	public Object setProperty (Object key, Object value)	{
		Object oldValue = properties.get(key);
		properties.put(key, value);
		return oldValue;
	}
		
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append(root.toString(0));
		return sb.toString();
	}
	
	protected Queue<Character> toCharQueue(String s) {
		Queue<Character> q = new LinkedList<Character>();
		for (Character c : s.toCharArray())
			q.add(c);
		return q;
	}
	
	protected BasicTrieNode root = null;
	protected Map<Object,Object> properties = null;
}