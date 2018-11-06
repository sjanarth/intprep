package com.intprep.real;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoreAndTest 
{
	private List<Integer> listItems = new ArrayList<Integer> ();
	private Set<Integer> setOrigItems = new HashSet<Integer> ();
	private Set<Integer> setAllItems = new HashSet<Integer> ();
	
	public void storeListO1 (Integer[] vals) {
		for (Integer val : vals)
			listItems.add(val);
	}
	
	public boolean matchListOn2 (Integer testVal)	{
		for (int i = 0; i < listItems.size()-1; i++)	{
			for (int j = i; j < listItems.size(); j++)	{
				if (listItems.get(i) + listItems.get(j) == testVal)	{
					return true;
				}
			}
		}
		return false;
	}
	
	public void storeSetO1 (Integer[] vals) {
		for (Integer val : vals)
			setAllItems.add(val);
	}
	
	public boolean matchSetOn (Integer testVal)	{
		for (Integer val : setAllItems) {
			if (setAllItems.contains(val+testVal) || setAllItems.contains(val-testVal))
				return true;
		}
		return false;
	}
	
	public void storeSetON (Integer[] vals)	{
		for (Integer val : vals)	{
			for (Integer valI : setOrigItems)	{
				setAllItems.add(valI+val);
			}
			setAllItems.add(val+val);
			setOrigItems.add(val);
		}
	}
	
	public boolean matchSetO1 (Integer testVal) {
		return setAllItems.contains(testVal);
	}
	
	public static void sop (String s) {
		System.out.println (s);
	}
	
	public static void main (String[] args) {
		StoreAndTest st = new StoreAndTest ();
		st.storeListO1(new Integer[] { -5, 0, 3, 5, 7, 8});
		sop ("Match-1(-2): "+st.matchListOn2(-2));
		sop ("Match-1(0): "+st.matchListOn2(0));
		sop ("Match-1(12): "+st.matchListOn2(12));
		sop ("Match-1(6): "+st.matchListOn2(6));
		sop ("Match-1(21): "+st.matchListOn2(21));
		sop ("-------");
		
		st.storeSetO1(new Integer[] { -5, 0, 3, 5, 7, 8});
		sop ("Match-2(-2): "+st.matchSetOn(-2));
		sop ("Match-2(0): "+st.matchSetOn(0));
		sop ("Match-2(12): "+st.matchSetOn(12));
		sop ("Match-2(6): "+st.matchSetOn(6));
		sop ("Match-2(21): "+st.matchSetOn(21));
		sop ("-------");
		
		st.storeSetON(new Integer[] { -5, 0, 3, 5, 7, 8});
		sop ("Match-3(-2): "+st.matchSetO1(-2));
		sop ("Match-3(0): "+st.matchSetO1(0));
		sop ("Match-3(12): "+st.matchSetO1(12));
		sop ("Match-3(6): "+st.matchSetO1(6));
		sop ("Match-3(21): "+st.matchSetO1(21));
		sop ("-------");
	}
}