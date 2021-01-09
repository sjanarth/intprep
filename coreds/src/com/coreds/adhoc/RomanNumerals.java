package com.coreds.adhoc;

public class RomanNumerals 
{
	public static void main(String[] args) {
		int[] numbers = { 13, 54, 69, 129, 532, 1005, 3196	};
		String[] romans = { "XIII", "LIV", "LXIX", "CXXIX", "DXXXII", "MV", "MMMCXCVI" };
		for (int num : numbers) {
			System.out.println("Roman ("+num+") = "+getRoman(num));
		}
		for (String roman : romans)	{
			System.out.println("Decimanl ("+roman+") = "+getDecimal(roman));
		}
	}
	
	private static String getRoman (int num)	{
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length;)	{
			if (num >= values[i])	{
				sb.append(romans[i]);
				num = num - values[i];
			} else {
				i++;
			}
		}
		return sb.toString();
	}

	private static int getDecimal (String roman)	{
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int decimal = 0;
		for (int  i = 0; i < romans.length;)	{
			if (roman.startsWith(romans[i]))	{
				decimal += values[i];
				roman = roman.substring(romans[i].length());
			} else {
				i++;
			}
		}
		return decimal;
	}
}
