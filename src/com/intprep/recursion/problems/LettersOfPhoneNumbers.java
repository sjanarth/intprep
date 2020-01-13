package com.intprep.recursion.problems;

import java.util.LinkedHashSet;
import java.util.Set;

public class LettersOfPhoneNumbers 
{
	public static void main(String[] args) {
		Set<String> all = new LinkedHashSet<>();
		genCombos (all, "", "23", 0);
		int i = 0;
		for (String s : all)	
			System.out.println(i+++ ": {"+s+"}");
	}
	
	private static void genCombos (Set<String> all, String current, String input, int start) {
		if (current.length() == input.length()) {
			all.add(current);
			return;
		}
		int ind = input.charAt(start) - '0';
		for (int i = 0; i < MAPPINGS[ind].length(); i++)	{
			current = current + MAPPINGS[ind].charAt(i);
			genCombos (all, current, input, start+1);
			current = current.substring(0, current.length()-1);
		}
	}
	
	private static final String[] MAPPINGS = {
		"", 
		"", 
		"abc",
		"def",
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz"
	};
}
