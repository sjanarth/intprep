package com.intprep.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayInteresection extends AbstractArraysProblem
{
	public static void main(String[] args) {
		int[] arr1 = initRandomNumericArray(10); //new int[] {3,4,7,11,14,17,19,23,27};
		int[] arr2 = initRandomNumericArray(15); //new int[] {2,6,14,23,29, 31, 36, 27, 48};
		printArray("arr1", arr1);
		printArray("arr2", arr2);
		printArray("Intersection", intersection(arr1, arr2));
	}
	
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> out = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0, ind2 = 0;
        while (ind1 < nums1.length && ind2 < nums2.length) {
        	if (nums1[ind1] < nums2[ind2]) { 
        		ind1++;
        	} else if (nums1[ind1] == nums2[ind2])	{
        		out.add(nums1[ind1]);
        		ind1++; ind2++;
        	} else	{ 
        		ind2++;
        	}
        }
        int[] outArr = new int[out.size()];
        int i = 0;
        for (Integer k : out)
        	outArr[i++] = k;
        return outArr;
    }
}