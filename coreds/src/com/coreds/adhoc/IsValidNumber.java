package com.coreds.adhoc;

public class IsValidNumber 
{
	public static void main(String[] args) {
		String[] nums = new String[] {
			// valid
			"1234",
			"+1234",
			"-1234",
			"0.10405",
			"-0.10405",
			"1234E10",
			// invalid
			"123+4",
			"1-234",
			"1.2.3.4",
			"E12345",
			"."
		};
		for (String s : nums)	{
			System.out.println("isValidNumber("+s+") = "+isValidNumber(s));
		}
	}
	
	private static boolean isValidNumber (String s)	{
		s = s.trim();
        if (s.length() == 0)
            return false;
		char ch = s.charAt(0);
		if (ch != '+' && ch != '-' && ch != '.' && !isDigit(ch))	{
			System.out.println("First char = "+ch);
			return false;
		}
		if (s.length() == 1 && !isDigit(s.charAt(0)))	{
			System.out.println("Length=1, but first char is not a digit");
			return false;
		}
		if (s.length() > 1) {
			String s2 = s.substring(1);
			if (s2.indexOf('+') > -1 || s2.indexOf('-') > -1)	{
				System.out.println("+/- can only be at the first position");
				return false;
			}
			if (hasInvalidChars (s2)) {
				System.out.println("has invalid chars");
				return false;
			}
			if (hasMoreThanOne (s, '+') || hasMoreThanOne (s, '-') || hasMoreThanOne (s, '.') || hasMoreThanOne (s, 'E') || hasMoreThanOne (s, 'e'))	{
				System.out.println("+/-/./E/e ocurs more than once");
				return false;
			}
			if (s.endsWith("e") || s.endsWith("E"))	{
				System.out.println("Cannot end with e/E");
				return false;
			}
            if (s.indexOf(".e") > -1 || s.indexOf(".E") > -1)   {
                System.out.println(".e and .E are invalid");
                return false;
            }
		}
		return true;
	}
	
	private static boolean isDigit (char ch)	{
		return (ch >= '0' && ch <= '9');
	}
	
	private static boolean hasMoreThanOne (String s, char ch)	{
		int ind = s.indexOf(ch);
		if (ind > -1)	{
			ind = s.indexOf(ch, ind+1);
			if (ind > -1)
				return true;
		}
		return false;
	}
	
	private static boolean hasInvalidChars (String s)	{
		for (int i = 0; i < s.length(); i++)	{
			char ch = s.charAt(i);
			if (ch != '.' && ch != 'E' && ch != 'e' && !isDigit(ch))
				return true;
		}
		return false;
	}
}
