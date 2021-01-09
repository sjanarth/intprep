package com.coreds.adhoc;

public class SquareRoot 
{
	public static void main(String[] args) {
		findSquareRoot (9);
		findSquareRoot (16);
		findSquareRoot (30);
	}

	private static int findSquareRoot (int x) {
		int start = 0, end = x, sr = 1;
		while (start <= end)	{
			int mid = start + (end-start)/2;
			if (mid*mid <= x) {
				start = mid + 1;
				sr = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println("findSquareRoot("+x+") = "+sr);
		return sr;
	}
}
