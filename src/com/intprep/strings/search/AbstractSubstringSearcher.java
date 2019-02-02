package com.intprep.strings.search;

public abstract class AbstractSubstringSearcher 
{
	public void searchMain(String text, String pattern) {
		System.out.println("Text = ["+text+"]");
		System.out.println("Pattern = ["+pattern+"]");
		Integer[] indices = searchSubstring(text, pattern);
		if (indices.length == 0)	{
			System.out.println(this.getClass().getSimpleName()+": No matches found ");
			System.out.println();
		} else {
			System.out.print(this.getClass().getSimpleName()+": Matching indices = { ");
			for (Integer i : indices) System.out.print(i+" ");
			System.out.println("}");
			System.out.println();
		}
	}
	
	protected abstract Integer[] searchSubstring (String text, String pattern);
}
