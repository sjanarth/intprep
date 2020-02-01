package com.intprep.adhoc;

public class BinaryAddition 
{
	public static void main(String[] args) {
		String[][] binaries = new String[][] {
			{"1001", "1000"},
			{"100", "11"},
			{"1110", "100"} 
		};
		for (String[] bin : binaries)	{
			System.out.println("addBinary("+bin[0]+","+bin[1]+") = "+addBinary(bin[0], bin[1]));
		}
	}

	private static String addBinary (String bin1, String bin2)	{
		System.out.println(bin1+", "+bin2);
		StringBuilder sb = new StringBuilder();
		boolean carry = false;
		int i = bin1.length() - 1;
		int j = bin2.length() - 1;
		while (i >=0 || j >= 0)	{
			char ch1 = i >= 0 ? bin1.charAt(i) : '0';
			char ch2 = j >= 0 ? bin2.charAt(j) : '0';
			System.out.println("i="+i+", j="+j+", ch1="+ch1+", ch2="+ch2+", carry="+carry);
			if (ch1 == '1' && ch2 == '1')	{
				if (carry)	{
					sb.insert(0, "1");
				} else {
					sb.insert(0, "0");
					carry = true;
				}
			} else if (ch1 == '1' || ch2 == '1')	{
				if (carry)	{
					sb.insert(0, "0");
				} else {
					sb.insert(0, "1");
				}
			} else if (carry)	{
				sb.insert(0, "1");
			} else {
				sb.insert(0,  "0");
			}
			i--; j--;
		}
		if (carry)
			sb.insert(0, "1");
		return sb.toString();
	}
}
