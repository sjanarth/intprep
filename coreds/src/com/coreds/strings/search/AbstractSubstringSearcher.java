package com.coreds.strings.search;

public abstract class AbstractSubstringSearcher 
{
	public void searchMain(String text, String pattern) {
		System.out.println(this.getClass().getSimpleName());
		long start = System.nanoTime() / 1000;
		Integer[] indices = searchSubstring(text, pattern);
		long end = System.nanoTime() / 1000;
		if (indices.length == 0)	{
			System.out.println("    No matches found ("+(end-start)+"us)");
		} else {
			System.out.print("    Matching indices: { ");
			for (Integer i : indices) System.out.print(i+" ");
			System.out.println("} ");
			System.out.println("    Runtime: "+(end-start)+" us");
		}
	}
	
	protected abstract Integer[] searchSubstring (String text, String pattern);
}
