package com.intprep.sort.problems;

public class DutchFlag 
{
    static String dutch_flag_sort(String balls) {
    	char[] ballsArr = balls.toCharArray();
    	quickSort (ballsArr, 0, ballsArr.length-1);
    	StringBuffer sb = new StringBuffer(String.valueOf(ballsArr[0]));
    	for (int i = 1; i < ballsArr.length; i++)	
    		sb.append(ballsArr[i]);
    	return sb.toString();
    }

	static void quickSort (char[] arr, int left, int right) {
		int p = partition (arr, left, right);
		if (left < p-1)
			quickSort (arr, left, p-1);
		if (p < right)
			quickSort (arr, p, right);
	}
    
	static int partition (char[] arr, int left, int right)	{
		int p = (left+right)/2;
		int pv = map(arr[p]);
		int i = left, j = right;
		while (i <= j)	{
			while (map(arr[i]) < pv) i++;
			while (map(arr[j]) > pv) j--;
			if (i <= j)	{
				char t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j--;
			}
		}
		return i;
	}
	
    static int map (char ch) {
    	switch (ch)	{
    		case 'R': return 0;
    		case 'G': return 1;
    		case 'B': return 2;
    	}
    	return 0;
    }

	public static void main (String[] args) {
		System.out.println(dutch_flag_sort("GBGGRBRG"));
	}
}
