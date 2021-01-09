package com.coreds.arrays;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3080/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 */
public class MedianOf2SortedArrays 
{
	public static void main(String[] args) {
		double median = findMedian (new int[]{1,3}, new int[]{2});
		System.out.println("Median = "+median);
		median = findMedian (new int[]{0,0}, new int[]{0,0});
		System.out.println("Median = "+median);
	}
	
	private static double findMedian (int[] arr1, int[] arr2)	{
		int sumLen = arr1.length + arr2.length;
		boolean isEven = (sumLen % 2) == 0;
		if (isEven)	{
			int mid = sumLen / 2;	
			int i = 0, j = 0;
			double median = 0;
			while (mid >= 0 && i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) { median = arr1[i]; i++; mid--;}
				else if (arr1[i] > arr2[j]) { median = arr2[j]; j++; mid--; }
				else { median = arr1[i]; i++; j++; mid-=2; }
			}
			while (mid >= 0 && i < arr1.length && j >= arr2.length) { median = arr1[i]; i++; }
			while (mid >= 0 && i > arr1.length && j < arr2.length) { median = arr2[j]; j++; }
			System.out.println("mid="+mid+", i="+i+", j="+j+", median="+median);
			if (i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) median = median + arr1[i];
				else median = median + arr2[j];
			} else if (i < arr1.length) {
				median = median + arr1[i];
			} else {
				median = median + arr2[j];
			}
			return median / 2;
		} else {
			int mid = (int) Math.floor(sumLen/2);
			int i = 0, j = 0;
			double median = 0;
			while (mid >= 0 && i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) { median = arr1[i]; i++; mid--;}
				else if (arr1[i] > arr2[j]) { median = arr2[j]; j++; mid--; }
				else { median = arr1[i]; i++; j++; mid-=2; }
			}
			while (mid >= 0 && i < arr1.length && j >= arr2.length) { median = arr1[i]; i++; }
			while (mid >= 0 && i > arr1.length && j < arr2.length) { median = arr2[j]; j++; } 
			return median;
		}
	}
}
