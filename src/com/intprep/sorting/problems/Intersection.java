package com.intprep.sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given two arrays, write a function to compute their intersection.
 * Example 1:
 * 	Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * 	Output: [2,2]
 * Example 2:
 * 	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 	Output: [4,9]
 * 	Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

public class Intersection 
{
	public static void main (String[] args) {
		int[] arr1 = initRandomArray();
		int[] arr2 = initRandomArray();
		print ("Array-1", arr1);
		print ("Array-2", arr2);
		int[] intersect = findIntersection (arr1, arr2);
		print ("Output", intersect);
	}
	
	private static int[] initRandomArray ()	{
		final int SIZE = 10;
		int[] arr = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		return arr;
	}
	
	private static void print (String s, int[] arr) {
		StringBuilder sb = new StringBuilder(s+": {");
		for (int i : arr) {
			sb.append(i+",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	private static int[] findIntersection (int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
        Arrays.sort(arr2);
        int np1 = 0;
        int np2 = 0;
        List<Integer> res = new ArrayList<>();
        while(np1 < arr1.length && np2 < arr2.length ){
            if(arr1[np1] < arr2[np2]){
                np1++;
            } else if(arr1[np1] > arr2[np2]){
                np2++;
            } else{
                res.add(arr1[np1]);
                np1++;
                np2++;
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;	
	}
}
