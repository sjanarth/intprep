package com.intprep.sorting.problems;

/*
 * Given balls of three colors (Red, Green and Blue) arranged randomly in a line. 
 * The task is to arrange them such that all balls of the same color are together 
 * and their collective color groups are in the correct order (Red balls 
 * first, Green balls next and Blue balls last).These are the colors similar 
 * to the Dutch National Flag, hence the problem name. 
 * 
 * Example:
 * Input:	GBGGRBRG
 * Output:	RRGGGGBB	
 */

public class DutchFlag 
{
	private static void swap (char[] input, int i, int j) {
		char t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
    private static String dutch_flag_sort(char[] input) {
    	int lo = 0;	// next place for R
    	int hi = input.length-1;	// next place for B
    	for (int i = 0; i < input.length; i++) {
    		System.out.print(String.copyValueOf(input).substring(0,lo)+".");
    		System.out.print(String.copyValueOf(input).substring(lo,hi+1)+".");
    		System.out.println(String.copyValueOf(input).substring(hi+1,input.length));
    		switch (input[i]) {
    			case 'R': 
    				swap (input, i, lo); lo++; //i--;
    				break;
    			case 'G': 
    				break;
    			case 'B':
    				swap(input, i, hi); hi--; i--;
    				break;
    		}
    		if (hi <= i)
    			break;
    	}
    	return String.valueOf(input);
    }

	public static void main (String[] args) {
		//System.out.println(dutch_flag_sort(String.valueOf("GBGGRBRGRGBBRGBGRBBBGGGRRR").toCharArray()));
		//System.out.println(dutch_flag_sort(String.valueOf("GBGRGRBRGRGBRBRGBGRBBBGGGRRBR").toCharArray()));
		System.out.println(dutch_flag_sort(String.valueOf("RGBGRGRBRGRGBRBRGBGRBBBGGGRRBR").toCharArray()));
	}
}