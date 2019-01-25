package com.intprep.strings.problems;

public class ReverseWords 
{
	public static void main(String[] args) {
		reverseWords ("hello world");
		reverseWords ("bonvoyage!");
	}
	
	private static void reverseWords (String s) {
		String s2 = reverseSentence (s.toCharArray());
		String s3 = reverseWordsInPlace (s2.toCharArray());
		System.out.println(s+" => "+s3);
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
		//System.out.println("reverse="+String.valueOf(input));
		int start = 0;
		while (start < input.length) {
			while (start < input.length && input[start] == ' ') start++;
			int end = start;
			while (end < input.length && input[end] != ' ') end++;
			end--;
			int end2 = end+1;
			//System.out.println("start="+start+",end="+end+",end2="+end2);
			while (start < end && end < input.length) {
				//System.out.println("swapping "+start+", "+end);
				swap(input, start, end);
				start++;
				end--;
			}
			start = end = end2;
		}
		return String.valueOf(input);
	}
}