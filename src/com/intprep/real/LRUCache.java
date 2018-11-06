package com.intprep.real;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache 
{
	public static void main (String args[])	{
		LRUCacheOrderN lc = new LRUCacheOrderN();
		System.out.print("cat: "+lc.isDuplicate("cat")); lc.print();
		System.out.print("dog: "+lc.isDuplicate("dog")); lc.print();
		System.out.print("squirrel: "+lc.isDuplicate("squirrel")); lc.print();
		System.out.print("cat: "+lc.isDuplicate("cat")); lc.print();
		System.out.print("squirrel: "+lc.isDuplicate("squirrel")); lc.print();
		System.out.print("parrot: "+lc.isDuplicate("parrot")); lc.print();
		System.out.print("dog: "+lc.isDuplicate("dog")); lc.print();
		System.out.print("cat: "+lc.isDuplicate("cat")); lc.print();
	}
}

class LRUCacheOrderN	{
	private LinkedList<String> cache = new LinkedList<String>();
	public boolean isDuplicate (String input)	{
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
		System.out.print("    [");
		for (Iterator<String> it = cache.listIterator(); it.hasNext();)
			System.out.print(" => "+it.next());
		System.out.println("]");
	}
}