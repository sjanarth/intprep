package com.intprep.strings.problems;

public class SmallestNumberRemovingKDigits 
{
	public static void main (String[] args) {
		findSmallestNumberByRemovingKDigits("23194", 2);
		findSmallestNumberByRemovingKDigits("3194", 2);
		findSmallestNumberByRemovingKDigits("31910", 3);
	}
	
	private static String findSmallestNumberByRemovingKDigits (String input, int k) {
		StringBuilder sb = new StringBuilder();
		int msd = getSmallestDigit (input.substring(0, k+1));
		String lsds = input.substring(k+1);
		sb.append(msd);
		sb.append(lsds);
		System.out.println("findSmallestNumberByRemovingKDigits("+input+","+k+")="+sb.toString());
		return sb.toString();
	}
	
	private static int getSmallestDigit (String s)	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			int d = Integer.parseInt(s.substring(i,  i+1));
			if (min > d)
				min = d;
		}
		return min;
	}
}