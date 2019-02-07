package com.intprep.strings.core;

import java.util.HashMap;
import java.util.Map;

public class GenericTrieNode extends BasicTrieNode 
{
	public GenericTrieNode()	{
		this (null, null);
	}
	
	public GenericTrieNode (Character ch, GenericTrieNode p) {
		super (ch, p);
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
