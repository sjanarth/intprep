package com.intprep.realqs;

public class NumberToEnglish 
{
	public static void main(String[] args) {
		int[] numbers = new int[] { 47, 233, 4917, 32569, 200020, 3540120, 1362082143 };
		for (int num : numbers)	{
			System.out.println("number2English("+num+") = "+number2English(num));
		}
	}
	
	private static String number2English (int num)	{
		final int BILLION = 1000000000;
		StringBuilder sb = new StringBuilder();
		int b = BILLION;
		for (int i = 0; i < 4; i++)	{
			int a = num / b;
			//System.out.println("=> i = "+i+", num = "+num+", a = "+a+", b = "+b+", sb = "+sb.toString());
			num = num % b;
			b = b / 1000;
			if (a > 0)	{
				sb.append(getString(a));
				switch (i)	{
					case 0: sb.append("Billion"); break;
					case 1: sb.append("Million"); break;
					case 2: sb.append("Thousand"); break;
					default: break;
				}
			}
			//System.out.println("<= i = "+i+", num = "+num+", a = "+a+", b = "+b+", sb = "+sb.toString());
		}
		return sb.toString();
	}
	
	private static String getString (int num)	{
		final String[] units = { " Zero ", " One ", " Two ", " Three ", " Four ", " Five ", " Six ", " Seven ", " Eight ", " Nine " };
		final String[] tens = { "", "", " Twenty ", " Thirty ", " Forty ", " Fifty ", " Sixty ", " Seventy ", " Eighty ", " Ninety " };
		final String[] teens = { " Ten ", " Eleven ", " Twelve ", " Thirteen ", " Fourteen ", " Fifteen ", " Sixteen ", " Seventeen ", " Eighteen ", " Nineteen " };
		StringBuilder sb = new StringBuilder();
		//System.out.println("getString("+num+")");
		int h = num / 100;
		if (h > 0)	{
			sb.append(units[h]);
			sb.append("Hundred");
			num = num % 100;
		}
		//System.out.println("getString, h="+h+", sb="+sb.toString()+", num = "+num);
		if (num > 0)	{
			if (num < 10)	{
				sb.append(units[num]);
			} else if (num < 20)	{
				sb.append(teens[num%10]);
			} else {
				sb.append(tens[num/10]);
				num = num % 10;
				if (num > 0)	{
					sb.append(units[num]);
				}
			}
		}
		return sb.toString();
	}
}
