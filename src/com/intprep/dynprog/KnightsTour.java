package com.intprep.dynprog;

/*
 * Given a phone keypad as shown below:
 * 		1 2 3
 * 		4 5 6
 * 		7 8 9
 * 		  0
 * How many different phone numbers of given length can be formed 
 * starting from the given digit? The constraint is that the movement 
 * from one digit to the next is similar to the movement of the Knight in a chess game.
 * 
 * For eg. if we are at 1 then the next digit can be either 6 or 8 
 * if we are at 6 then the next digit can be 1, 7 or 0.
 * Repetition of digits are allowed - 1616161616 is a valid number.
 */

public class KnightsTour extends com.intprep.recursion.problems.KnightsTour
{
	public static void main (String[] args) {
		findAllPhoneNumbers (1,3);
	}
	
	protected static void findAllPhoneNumbers (int start, int len) {
		com.intprep.recursion.problems.KnightsTour.findAllPhoneNumbers(start, len);
		long count = findAllPhoneNumbersUsingDP (start, len);
		System.out.println("findAllPhoneNumbersUsingDP("+start+","+len+") = "+count);
		System.out.println("------------------------------------------------------------------");
	}

	private static long findAllPhoneNumbersUsingDP(int start, int len) {
		// 1. Initialize
		int[][] dpt = new int[len][validNexts.size()];
		// 2. Prepopulate
		dpt[0][start] = 1;
		// 3. Populate
		for (int l = 1; l < len; l++)	{
			for (int s = 0; s < validNexts.size(); s++)	{
				for (int next : validNexts.get(s))	{
					dpt[l][s] = dpt[l][s] + dpt[l-1][next];
				}
			}
		}
		// 4. Return
		long count = 0;
		for (int i = 0; i < validNexts.size(); i++)
			count = count + dpt[len-1][i];
		return count;
	}
}
