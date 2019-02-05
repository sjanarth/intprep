package com.intprep.strings.core;

import java.util.Arrays;
import java.util.Comparator;

/*
 * References:
 * 	 https://github.com/williamfiset/data-structures/tree/master/com/williamfiset/datastructures/suffixarray
 */
public class SuffixArray 
{
	public SuffixArray (String t) {
		construct(t);
	}

	public int[] getSuffixArray()	{
		return sa;
	}
	
	public int[] getLCPArray()	{
		return lcp;
	}
	
	public String getSuffix (int i)	{
		return text.substring(sa[i]);
	}
	
	@Override
	public String toString ()	{
		StringBuilder sb = new StringBuilder();
		sb.append("text=["); sb.append(text); sb.append("], ");
		sb.append("sa="); sb.append(toString(sa)); sb.append(", ");
		sb.append("lcp="); sb.append(toString(lcp));
		return sb.toString();
	}
	
	protected String toString(int[] arr) {
		return Arrays.toString(arr).
					replaceAll(" ", "").
					replaceAll("\\[", "\\{").
					replaceAll("\\]", "\\}");
	}
	
	/*
	 * This is basic o(n^2) algorithm to construct a Suffix Array.
	 * There are faster o(nlog^2n), o(nlogn) and o(n) variants available on the web.
	 */
	protected void construct (String t)	{
		text = t;
		sa = new int[t.length()];
		lcp = new int[t.length()];
		// temporary space, will get freed up
		Suffix[] suffixes = new Suffix[t.length()];
		// gather all suffixes
		for (int i = 0; i < text.length(); i++)	
			suffixes[i] = new Suffix(text.substring(i), i);
		// sort them
		Arrays.sort(suffixes, Suffix.getComparator());
		//System.out.println("Showing sorted suffixes");
		//for (int i = 0; i < suffixes.length; i++)
			//System.out.println(i+": "+suffixes[i]);
		// build the suffix and lcp arrays
		lcp[0] = 0;
		for (int i = 1; i < t.length(); i++)	{
			sa[i-1] = suffixes[i-1].position;
			lcp[i] = StringUtils.lcp(suffixes[i-1].suffix, suffixes[i].suffix).length();
			suffixes[i-1] = null;	// free up
		}
		sa[t.length()-1] = suffixes[t.length()-1].position;
		suffixes[t.length()-1] = null;	// free up
	}
	
	private String text = null;
	private int[] sa = null;
	private int[] lcp = null;
	
	protected static class Suffix  
	{
		public Suffix (String s, int pos) { suffix = s; position = pos; }
		public String toString() { return "{"+suffix+","+position+"}"; }
		public static Comparator<Suffix> getComparator () { return comp; }
		
		protected String suffix = null;
		protected Integer position = -1;
		protected static Comparator<Suffix> comp = 
			new java.util.Comparator<Suffix> () {
						@Override
						public int compare(Suffix o1, Suffix o2) {
							return o1.suffix.compareTo(o2.suffix);
						}
					};
	}
	
	public static void main (String[] args)	{
		System.out.println(new SuffixArray("banana".toString()));
	}
}
