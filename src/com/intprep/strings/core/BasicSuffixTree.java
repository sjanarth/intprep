package com.intprep.strings.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSuffixTree extends BasicTrie
{
	private static final String TRIENODE_PROPERTY_SOURCE = "src";
	
	public BasicSuffixTree() {
		this (null);
	}
	
	public BasicSuffixTree(String input) {
		words = new HashMap<String,Integer>();
		addWord(input);
	}
	
	public void addWord (String word)	{
		if (word != null)	{
			words.put(word, words.size()+1);
			for (int i = 0; i < word.length(); i++)	{
				BasicTrieNode node = add(word.substring(i));
				List<String> sources = new ArrayList<String>();
				sources.add(word+":"+i);
				node.addProperty(TRIENODE_PROPERTY_SOURCE, sources);
			}
		}
	}

	private Map<String,Integer> words = null;
	
	public static void main(String[] args)	{
		BasicSuffixTree st = new BasicSuffixTree("banana");
		System.out.println(st.toString());
	}
}