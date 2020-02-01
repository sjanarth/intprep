package com.intprep.adhoc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.intprep.strings.core.BasicTrie;

public class AutoCompleteTrie extends BasicTrie
{
	public AutoCompleteTrie() {
		super (AutoCompleteTrieNode.class);
	}
	
	public List<String> searchTopK (String prefix)	{
		System.out.println("searchTopK, prefix="+prefix);
		Queue<Character> q = toCharQueue(prefix);
		AutoCompleteTrieNode node = (AutoCompleteTrieNode) root.findNode(q);
		if (node != null)	{
			//System.out.println(node.toString(0));	
			return node.getTopChildStrings();
		}
		return new ArrayList<String>();
	}
	
	public Integer update (String s, int freq)	{
		Queue<Character> qPrefix = toCharQueue(s);
		AutoCompleteTrieNode node = (AutoCompleteTrieNode) root.findNode(qPrefix);
		if (node == null)
			node = (AutoCompleteTrieNode) add(s);
		return ((AutoCompleteTrieNode) node.getChildMap().get(null)).setFrequency(freq);
	}
	
	public void crawl ()	{
		((AutoCompleteTrieNode)root).crawl();
	}
}