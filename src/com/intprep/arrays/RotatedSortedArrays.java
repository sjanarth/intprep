package com.intprep.arrays;

public class RotatedSortedArrays 
{
	public static void main(String[] args) {
		int[] arr =new int[] { 19, 2, 6, 7, 8, 10, 12, 15 };
		showArray("Given Array", arr);
		countRotations(arr);
		findMin (arr);
		findIndex (arr, 6);
		findIndex (arr, -6);
		reverseArray (arr);
		rotateLeft (arr, 2);
		rotateRight (arr, 2);
	}
	
	private static void showArray (String str, int[] arr) {
		System.out.print(str+" = {");
		for (int i : arr) System.out.print(i+", ");
		System.out.println("}");
	}	
	
	private static void countRotations (int[] arr) {
		int countRot = countRotations (arr, 0, arr.length-1);
		System.out.println("counRotations(): "+countRot);
	}
	
	private static int countRotations (int[] arr, int low, int high)	{
		if (high < low)
			return -1;
		if (high == low)
			return low;
		int mid = low + (high-low)/2;
		if (mid > low && arr[mid] < arr[mid-1])
			return mid;
		if (mid < high && arr[mid+1] < arr[mid])
			return mid+1;
		if (arr[high] > arr[mid])
			return countRotations (arr, low, mid-1);
		else
			return countRotations (arr, mid+1, high);
	}
	
	private static void findMin (int[] arr)	{
		int countRot = countRotations (arr, 0, arr.length-1);
		System.out.println("findMin(): index="+countRot+", value="+arr[countRot]);
	}
	
	private static void findIndex (int[] arr, int x)	{
		int low = 0, high = arr.length-1;
		while (low <= high)	{
			int mid = low + (high-low)/2;
			if (arr[mid] == x)	{
				System.out.println("findIndex("+x+"): "+mid);
				return;
			}
			if (arr[mid] <= arr[high])	{
				if (arr[mid] < x && x <= arr[high])
					low = mid+1;
				else
					high = mid-1;
			} else {
				if (arr[low] <= x && x < arr[mid])
					high = mid-1;
				else
					low = mid+1;
			}
		}
		System.out.println("findIndex("+x+"): Not found");
	}
	
	private static void rotateLeft (int[] arr, int d)	{
		int N = arr.length;
		int pv = (d % N);
		reverse(arr, 0, pv-1);
		reverse(arr, pv, N-1);
		reverse(arr, 0, N-1);
		showArray("rotateLeft("+d+") = ", arr);
	}
	
	private static void rotateRight (int[] arr, int d)	{
		int N = arr.length;
		int pv = N - (d % N);
		reverse(arr, 0, pv-1);
		reverse(arr, pv, N-1);
		reverse(arr, 0, N-1);
		showArray("rotateRight("+d+") = ", arr);
	}
	
	private static void reverseArray (int[] arr)	{
		reverse (arr, 0, arr.length-1);
		showArray("Reversed Array", arr);
	}

	private static void reverse (int[] arr, int start, int end)	{
		int N = end-start;
		for (int i = start; i <= start+N/2; i++)	{
			int tmp = arr[i];
			arr[i] = arr[start+end-i];
			arr[start+end-i] = tmp;
		}
	}
}
