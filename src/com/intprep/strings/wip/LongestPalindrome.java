package com.intprep.strings.wip;

public class LongestPalindrome 
{
	public static void main (String[] args) {
		showLongestPalindrome("abaabaabaaccc");
	}

	private static void showLongestPalindrome (String input) {
		String longest = "";
		for (int i = 0; i < input.length(); i++) {
			String longest2 = getLongestPalindrome(input, i);
			if (longest2.length() > longest.length())
				longest = longest2;
		}
		System.out.println("showLongestPalindrome("+input+")="+longest);
	}
	
	private static String getLongestPalindrome (String input, int i) {
		int left = i;
		int oddEven = (input.length() %2) == 0 ? 1 : 0;
		int right = i + oddEven;
		while (input.charAt(left) == input.charAt(right))	{
			System.out.println("left="+left+", right="+right+", char="+input.charAt(left));
			left--;
			if (left < 0) {
				left = 0;
				break;
			}
			right++;
			if (right > input.length())	{
				right = input.length();
				break;
			}
		}
		System.out.println("   getLongestPalindrome("+i+")="+input.substring (left, right+1));
		return input.substring (left, right+1);
	}
}
