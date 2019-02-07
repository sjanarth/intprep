package com.intprep.strings.core;

public class GeneralizedSuffixTree extends BasicSuffixTree 
{
	public GeneralizedSuffixTree(String[] inputs) {
		super();
		for (int i = 0; i < inputs.length; i++)	{
			addWord(inputs[i]);
		}
	}
	
	public static void main (String[] args)	{
		String[] words = new String[] { "ball", "call", "fall", "hall", "mall", "tall", "wall"};
		GeneralizedSuffixTree gst = new GeneralizedSuffixTree(words);
		System.out.println(gst.toString());
	}
}
