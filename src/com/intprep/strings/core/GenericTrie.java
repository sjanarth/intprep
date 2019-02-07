package com.intprep.strings.core;

import java.util.HashMap;
import java.util.Map;

public class GenericTrie extends BasicTrie 
{
	public GenericTrie()	{
		this (GenericTrieNode.class);
	}
	
	public GenericTrie(Class<? extends BasicTrieNode> nodeClass)	{
		super (nodeClass);
		properties = new HashMap<Object,Object>();
	}

	public Object getProperty (Object key)	{
		return properties.get(key);
	}
	
	public Object setProperty (Object key, Object value)	{
		Object oldValue = properties.get(key);
		properties.put(key, value);
		return oldValue;
	}
	
	protected Map<Object,Object> properties = null;
}
