package com.intprep.strings.core;

public class SuffixTree extends BasicTrie
{
	public SuffixTree(String w) {
		construct(w);
	}
	
	protected void construct(String w)	{
		text = w;
		for (int i = 0; i < w.length(); i++)
			add(w.substring(i));
	}
	
	private String text = null;
	
	public static void main(String[] args)	{
		SuffixTree st = new SuffixTree("banana");
		System.out.println(st.toString());
	}
}
