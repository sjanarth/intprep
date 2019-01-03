package com.intprep.recursion.wip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string and a dictionary of words, the problem asks to 
 * add single whitespaces between two characters in the string such 
 * that every word exists in the given dictionary. 
 * 
 * Same word from the dictionary can be used multiple times when 
 * splitting the given string. 
 *
 * Example:
 * 	Input: {kick,start,kickstart,is,awe,some,awesome} kickstartisawesome
 * 	Output: 
 * 		kick start is awe some 
 * 		kick start is awesome 
 * 		kickstart is awe some 
 * 		kickstart is awesome
 */

public class WordBreak 
{
	public static void main (String[] args) {
		breakWords (new String[] {"kick","start","kickstart","is","awe","some","awesome"}, "kickstartisawesome");
	}
	
	protected static void breakWords(String[] dic, String text)	{
		Set<String> dict = new HashSet<String>();
		for (String w : dic) dict.add(w);
		List<List<String>> choices = new ArrayList<List<String>>();
		breakWords (dict, text, choices);
		for (List<String> choice : choices) {
			for (String c : choice) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	
	private static void breakWords (Set<String> dict, String text, List<List<String>> choices)	{
		for (int i = 0; i <= text.length(); i++) {
			String s = text.substring(0, i);
			if (dict.contains(s))	{
				List<String> choice = new ArrayList<String>();
				choice.add(s);
				choice.add(text.substring(i));
				choices.add(choice);
				//breakWords (dict, text.substring(i+1), choice);
			}
		}
	}
	
	private static String[] getAllSubstrings (String s) {
		char[] chars = s.toCharArray();
		char[] output = new char[chars.length];
		List<String> subs = new ArrayList<String>();
		gatherAllSubstrings (chars, 0, output, 0, subs);
		return subs.toArray(new String[0]);
	}
	
	private static void gatherAllSubstrings (char[] input, int i, char[] output, int k, List<String> subs)	{
		if (i == input.length) {
			subs.add(String.valueOf(output).substring(0,k));
		} else {
			gatherAllSubstrings (input, i+1, output, k, subs);
			output[k] = input[i];
			gatherAllSubstrings (input, i+1, output, k+1, subs);
		}
	}
}
