package com.intprep.sorting.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * A disorganized carpenter has a mixed pile of bolts and nuts and 
 * would like to find the corresponding pairs of bolts and nuts. 
 * Each nut matches exactly one bolt and vice versa. By trying to 
 * match a bolt and a nut the carpenter can see which one is bigger, 
 * but she cannot compare two bolts or two nuts directly. 
 * Can you help the carpenter match the nuts and bolts quickly?
 * 
 * You can make the following assumptions:
 * 1. There are equal number of nuts and bolts
 * 2. A given nut uniquely matches a bolt
 * 3. There are no extra unmatched nuts or extra bolts. 
 * 	  i.e. every nut has one and only one matching bolt and vice-versa.
 * 
 * Example:
 * Input:
 * 	NUTS = [4, 32, 5, 7]
 * 	BOLTS = [32, 7, 5, 4]
 * Output:
 * 	4 4
 * 	32 32
 * 	5 5
 * 	7 7
 */

public class NutsAndBolts
{
	private static void swap(int[] arr, int i, int j)	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static void groupNutsAndBolts(int[] nuts, int[] bolts) {
		Map<Integer,Integer> positions = new HashMap<Integer,Integer>();
		for (int i = 0; i < nuts.length; i++)
			positions.put(nuts[i], i);
		int nut_ind = 0;
		for (int i = 0; i < bolts.length; i++) {
			if (nuts[i] == bolts[i]) continue;
			int pos = positions.get(bolts[i]);
			swap(nuts, pos, nut_ind++);
		}
	}
	
	public static void main (String[] args) {
		int[] NUTS = new int[] {4, 32, 5, 7};
		int[] BOLTS = new int[] {32, 7, 5, 4};
		groupNutsAndBolts (NUTS, BOLTS);
		for (int i = 0; i < NUTS.length; i++)
			System.out.println(NUTS[i]+" => "+BOLTS[i]);
	}
}
