package com.intprep.strings.problems;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstring 
{
	private static int getLength (Map<Character,Integer> lastPos, char thisSym, int pos)	{
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (Character ch : lastPos.keySet()) {
			if (lastPos.get(ch) < min) {
				min = lastPos.get(ch);
			} else if (lastPos.get(ch) > max) {
				max = lastPos.get(ch);
			}
		}
		return 0;
	}
	
	private static int getMin (Map<Character,Integer> lastPos)	{
		int min = Integer.MAX_VALUE;
		for (Character symbol : lastPos.keySet()) {
			if (lastPos.get(symbol) < min) {
				min = lastPos.get(symbol);
			}
		}
		return min;
	}
	
	private static void shortestSubstring(String input, char[] symbols) {
		Map<Character,Integer> lastPos = new HashMap<Character,Integer>();
		char[] inputChars = input.toCharArray();
		int minLen = Integer.MAX_VALUE;
		int left = -1, right = 0;
		while (right < inputChars.length) {
			System.out.println("Candidate="+inputChars[right]);
			for (Character symbol : symbols) {
				if (inputChars[right] == symbol) {
					System.out.println("  matches with "+symbol);
					if (left == -1) {
						System.out.println("  adjusting left to "+right);
						left = right;
					}
					System.out.println("  lastPos="+lastPos.get(symbol)+", lastPos.size="+lastPos.size());	
					if (!lastPos.containsKey(symbol) || lastPos.size() < symbols.length)	{
						System.out.println("  adding to map");
						lastPos.put(symbol,  right);
					} else {
						int thisLen = 0;//getLength (lastPos, symbols, symbol, right);
						System.out.println("  minLen="+minLen+", thisLen="+thisLen);
						if (thisLen < minLen)	{
							minLen = thisLen;
							lastPos.put(symbol, right);
							left = getMin (lastPos);
						}
					}
				}
			}
			right++;
		}
		System.out.println(input.substring(left, right));
	}
	
	public static void main (String[] args) {
		shortestSubstring(String.valueOf("helloworld"), new char[] {'l','w','r'});
	}
}
