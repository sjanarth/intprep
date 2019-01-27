package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

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

public class KnightsTour 	
{
	public static void main(String[] args)	{
		findAllPhoneNumbers (1,3);
	}
	
	protected static void findAllPhoneNumbers (int start, int len)	{
		long count = findAllPhoneNumbersNoMemo (new StringBuilder(String.valueOf(start)), len-1);
		System.out.println("findAllPhoneNumbersNoMemo("+start+","+len+") = "+count);
		long count2 = findAllPhoneNumbersWithMemo (new StringBuilder(String.valueOf(start)), len-1, new HashMap<String,Long>());
		System.out.println("findAllPhoneNumbersWithMemo("+start+","+len+") = "+count2);
	}
	
	private static long findAllPhoneNumbersNoMemo(StringBuilder sb, int len) {
		if (len == 0) return 1;
		String s = sb.toString();
		int lastNum = Integer.parseInt(s.substring(s.length()-1));
		Integer[] nextNums = validNexts.get(lastNum);
		long count = 0;
		for (int nn : nextNums) {
			StringBuilder sb2 = new StringBuilder(s);
			sb2.append(nn);
			count = count + findAllPhoneNumbersNoMemo(sb2, len-1);
		}
		return count;
	}
	
	private static long findAllPhoneNumbersWithMemo(StringBuilder sb, int len, Map<String,Long> memo) {
		if (len == 0) return 1;
		String s = sb.toString();
		int lastNum = Integer.parseInt(s.substring(s.length()-1));
		String key = makeKey(lastNum, len);
		if (memo.containsKey(key)) return memo.get(key);
		Integer[] nextNums = validNexts.get(lastNum);
		long count = 0;
		for (int nn : nextNums) {
			StringBuilder sb2 = new StringBuilder(s);
			sb2.append(nn);
			count = count + findAllPhoneNumbersWithMemo(sb2, len-1, memo);
		}
		memo.put(key, count);
		return count;
	}

	private static String makeKey (int start, int len) {
		return new StringBuilder(String.valueOf(start)+","+String.valueOf(len)).toString();
	}

	protected static Map<Integer,Integer[]> validNexts = new HashMap<Integer,Integer[]>();
	static	{
		validNexts.put(1, new Integer[] {6,8});
		validNexts.put(2, new Integer[] {7,9});
		validNexts.put(3, new Integer[] {4,8});
		validNexts.put(4, new Integer[] {3,9,0});
		validNexts.put(5, new Integer[] {});
		validNexts.put(6, new Integer[] {1,7,0});
		validNexts.put(7, new Integer[] {2,6});
		validNexts.put(8, new Integer[] {1,3});
		validNexts.put(9, new Integer[] {2,4});
		validNexts.put(0, new Integer[] {4,6});
	}
}