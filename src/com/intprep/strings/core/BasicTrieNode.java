package com.intprep.strings.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BasicTrieNode 
{
	public BasicTrieNode () { 
		this (null, null); 
	}

	public BasicTrieNode (Character ch, BasicTrieNode p) { 
		c = ch; 
		children = new TreeMap<Character,BasicTrieNode>(new NullCharComparator());
		parentNode = p;	// a more clever implementation could do away with this
	}
	
	public Map<Character,BasicTrieNode> getChildMap()	{
		return children;
	}
	
	public boolean isWord () {
		return c == null && children.isEmpty();
	}
	
	public boolean isRoot () {
		return c == null && !children.isEmpty();
	}
	
	public BasicTrieNode add(Queue<Character> q)	{
		Character nextChar = null;
		if (!q.isEmpty()) 
			nextChar = q.poll();
		BasicTrieNode child = children.get(nextChar);
		if (child == null)	{
			child = createNode (nextChar, this);
			children.put(nextChar, child);
		}
		if (nextChar != null)
			child.add(q);
		return child;
	}
	
	public BasicTrieNode findNode(Queue<Character> qPrefix)	{
		if (qPrefix.isEmpty()) 
			return this;// children.get(null);
		Character nextChar = qPrefix.poll();
		if(!children.containsKey(nextChar)) 
			return null;
		BasicTrieNode nextNode = children.get(nextChar);
		return nextNode.findNode(qPrefix);
	}
	
	public String getString ()  {
		StringBuilder sb = new StringBuilder();
		BasicTrieNode curr = this;
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
		for(BasicTrieNode child : children.values())	
			for (String s : child.getAllChildStrings()) 	
				allStrings.add(c+s);
		return allStrings;
	}
	
	public String toString (int level) {
		StringBuilder sb = new StringBuilder();
		if (isRoot()) {
			sb.append("/");
			for (Character ch : children.keySet()) {
				sb.append("\n");
				BasicTrieNode child = children.get(ch);
				sb.append(child.toString(level+1));
			}
		} else {
			for (int i = 1; i < level; i++) sb.append(" ");
			sb.append("\\_");
			if (isWord()) {
				sb.append("."); 
			} else {
				sb.append(c);
				for (Character ch : children.keySet()) {
					sb.append("\n");
					BasicTrieNode child = children.get(ch);
					sb.append(child.toString(level+2));
				}
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings("rawtypes")
	private BasicTrieNode createNode (Character ch, BasicTrieNode parent)	{
		Class<? extends BasicTrieNode> cls = parent.getClass();
		if (BasicTrieNode.class.isAssignableFrom(cls))	{
			Class[] paramTypes = { Character.class, cls };
			Object[] params = { ch, parent };
			try {
				Constructor<? extends BasicTrieNode> c = cls.getConstructor(paramTypes);
				return c.newInstance(params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else 
		{
			throw new IllegalStateException("Class " + cls + " not s subclass of BasicTrieNode");
		}
		return null;
	}
	
	protected Character c = null;
	protected Map<Character,BasicTrieNode> children = null;
	protected BasicTrieNode parentNode = null;
	
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