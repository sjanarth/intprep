package com.intprep.strings.problems;

public class ReverseWords 
{
	public static void main(String[] args) {
		reverseWords ("hello world");
		reverseWords ("bon voyage!");
	}
	
	private static void reverseWords (String s) {
		String s2 = reverseSentence (s.toCharArray());
		s2 = reverseWordsInPlace (s.toCharArray());
		System.out.println(s+" => "+s2);
	}
	
	private static String reverseSentence (char[] input) {
		int start = 0, end = input.length-1;
		while (start < end)	{
			swap(input, start, end);
			start++;
			end--;
		}
		return String.valueOf(input);
	}
	
	private static void swap (char[] input, int i, int j)	{
		char ch = input[i];
		input[i] = input[j];
		input[j] = ch;
	}
	
	private static String reverseWordsInPlace(char[] input) {
		int start = 0;
		while (start < input.length) {
			while (start < input.length && input[start] == ' ') start++;
			int end = start;
			while (end < input.length && input[end] != ' ') end++;
			end--;
			int end2 = end+1;
			while (start < end && end < input.length) {
				swap(input, start, end);
				start++;
				end--;
			}
			start = end = end2;
		}
		return String.valueOf(input);
	}
}