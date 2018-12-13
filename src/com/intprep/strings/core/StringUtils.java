package com.intprep.strings.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils 
{
	public static String getBinary(int x)	{
		StringBuilder sb = new StringBuilder();
		int mask = 0x40000000;
		while (mask > 0) {
			//System.out.println("   "+(x&mask));
			sb.append( (x&mask) > 0 ? "1" : "0");
			mask = mask >> 1;
		}
		return sb.toString();
	}
	
	public static boolean isAllUniqueChars (String s) {
		Set<Character> uniq = new HashSet<Character> ();
		for (int i = 0; i < s.length(); i++)	{
			char ch = s.charAt(i);
			if (uniq.contains(ch))	{
				return false;
			}
			uniq.add(ch);
		}
		return true;
	}
	
	public static int getCountOfUniqChars (String s) {
		Set<Character> uniq = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++)	{
			uniq.add(s.charAt(i));
		}
		return uniq.size();
	}
	
	public static Map<Character,Integer> getCountOfEachChar (String s)	{
		Map<Character,Integer> uniq = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (uniq.containsKey(ch))	{
				uniq.put(ch, uniq.get(ch)+1);
			} else {
				uniq.put(ch, 1);
			}
		}
		return uniq;
	}
	
	public static String reverse (String s) {
		char[] chars = s.toCharArray();
		int mid = chars.length / 2;
		for (int i = 0; i < mid; i++)	{
			char tmp = chars[i];
			chars[i] = chars[chars.length-1-i];
			chars[chars.length-1-i] = tmp;
		}
		return String.valueOf(chars);
	}
	
	public static String removeDups (String s) {
		Set<Character> uniq = new HashSet<Character> ();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)	{
			char ch = s.charAt(i);
			if (!uniq.contains(ch))	{
				sb.append(ch);
				uniq.add(ch);
			}
		}
		return sb.toString();
	}
	
	public static boolean isAnagram (String s1, String s2)	{
		// sort(s1) == sort(s2)
		Map<Character, Integer> counts1 = new HashMap<Character,Integer> ();
		for (int i = 0; i < s1.length(); i++)	{
			Character ch = s1.charAt(i);
			if (counts1.containsKey(ch))	{
				int c = counts1.get(ch);
				counts1.put(ch,  c+1);
			} else {
				counts1.put(ch,  0);
			}
		}
		//System.out.println("   counts1="+counts1.toString());
		Map<Character, Integer> counts2 = new HashMap<Character,Integer> ();
		for (int i = 0; i < s2.length(); i++)	{
			Character ch = s2.charAt(i);
			if (counts2.containsKey(ch))	{
				int c = counts2.get(ch);
				counts2.put(ch,  c+1);
			} else {
				counts2.put(ch,  0);
			}
		}
		//System.out.println("   counts2="+counts2.toString());
		return counts1.equals(counts2);	
	}
	
	public static boolean isRotation (String s1, String s2)	{
		return (s1.length() == s1.length()) && 
				((s1+s1).indexOf(s2) > -1);

	}
	
	public static Set<String> getAllSubstrings (String input)	{
		Set<String> substrs = new LinkedHashSet<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = 1; j <= input.length() - i; j++)	{
				substrs.add(input.substring(i, i+j));
			}
		}
		return substrs;
	}
	
	public static void main (String[] args)	{
		String[] strings = new String[] { "yellow", "blue", "green", "water", "test", "tomato", "harbor"};
		String[] strings2 = new String[] { "llyeow", "ue", "eenrg", "tewar", "tets", "totmato", "hartbor"};
		//for (String s : strings)
			//System.out.println("reverse("+s+"): "+reverse(s));
			//System.out.println("removeDups("+s+"): "+removeDups(s));
		for (int i = 0; i < strings.length; i++) {
			System.out.println("isAnagram("+strings[i]+","+strings2[i]+"): "+isAnagram(strings[i], strings2[i]));
		}

		int x = 1;
		while (x < Integer.MAX_VALUE && x > 0)	{
			System.out.println(("binary("+x+"):          "+getBinary(x)));
			x = x << 1;
		}
		System.out.println(Integer.MAX_VALUE);
	}
}