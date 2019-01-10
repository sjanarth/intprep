package com.intprep.realqs;

import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache 
{
	public static void main (String args[])	{
		String[] values = new String[] {"cat", "dog", "squirrel", "cat", "parrot", "dog", "cat"};
		LRUCacheOrderN lc = new LRUCacheOrderN();
		for (String s : values)	{
			System.out.print(s+": "+lc.check(s)); 
			lc.print();
			System.out.println();
		}
	}
}

class LRUCacheOrderN	{
	private LinkedList<String> cache = new LinkedList<String>();
	public boolean check (String input)	{
		if (cache.contains(input))	{
			cache.remove(input);
			cache.addFirst(input);
			return true;
		} else {
			cache.addFirst(input);
			if (cache.size() > 3)
				cache.removeLast();
			return false;
		}
	}
	public void print ()	{
		StringBuilder sb = new StringBuilder("    [");
		for (Iterator<String> it = cache.listIterator(); it.hasNext();)
			sb.append(" => "+it.next());
		sb.append("]");
		System.out.print(sb.toString());
	}
}