package com.coreds.adhoc;

import java.util.ArrayList;
import java.util.List;

public class UnionAndIntersection 
{
	public List<Integer> getUnion (int[] a, int[] b)	{
		List<Integer> union = new ArrayList<Integer> ();
		int aind = 0;
		int bind = 0;
		while (aind < a.length && bind < b.length)	{
			if (a[aind] < b[bind])	{
				union.add(a[aind++]);
			} else if (a[aind] > b[bind]) {
				union.add(b[bind++]);
			} else {
				union.add(a[aind++]);
				bind++;
			}
		}

		while (aind < a.length)	
			union.add(a[aind++]);
		
		while (bind < b.length)
			union.add(b[bind++]);
			
		return union;
	}
	
	public List<Integer> getIntersection (int[] a, int[] b)	{
		List<Integer> intersect = new ArrayList<Integer> ();
		int aind = 0;
		int bind = 0;
		while (aind < a.length && bind < b.length)	{
			if (a[aind] < b[bind])	{
				aind++;
			} else if (a[aind] > b[bind])	{
				bind++;
			} else if (a[aind] == b[bind])	{
				intersect.add(a[aind]);
				aind++;
				bind++;
			}
		}
		return intersect;
	}
	
	public static void main (String[] args) {
		UnionAndIntersection ui = new UnionAndIntersection();
		List<Integer> union = ui.getUnion (new int[] {-3,0,2,5,9,17}, new int[] {-8,1,5,7,12,18,23,29});
		for (int i : union)
			System.out.print(i+" ");
		System.out.println();
		List<Integer> intersect = ui.getIntersection (new int[] {-3,0,2,5,7,9,17}, new int[] {-8,1,5,7,12,18,23,29});
		for (int i : intersect)
			System.out.print(i+" ");

	}

}
