package com.intprep.realqs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoreAndTest 
{
	public static void main (String[] args) {
		int[] given = new int[] {-5, 0, 3, 5, 7, 8};
		Matcher lm = new ListMatcher(); lm.store(given);
		Matcher lsm = new LinearSetMatcher(); lsm.store(given);
		Matcher csm = new ConstantSetMatcher(); csm.store(given);
		Matcher[] matchers = new Matcher[] {lm, lsm, csm};
		int[] tests = new int[] {-2, 0, 12, 6, 21};
		for (int i : tests) 	{
			for (Matcher m : matchers) 
				System.out.println(m.getClass().getSimpleName()+" matches("+i+"): "+m.match(i));
			System.out.println("-----");
		}
	}
	
	private static interface Matcher 
	{
		public void store (int[] values);
		public boolean match (int testVal);
	}
	
	private static class ListMatcher implements Matcher
	{
		List<Integer> values = new ArrayList<Integer>();
		@Override
		public void store(int[] vals) {
			for (int i : vals) values.add(i);
		}

		@Override
		public boolean match(int testVal) {
			for (int i = 0; i < values.size()-1; i++)
				for (int j = i; j < values.size(); j++)
					if (values.get(i) + values.get(j) == testVal)
						return true;
			return false;
		}
	}

	private static class LinearSetMatcher implements Matcher
	{
		Set<Integer> values = new HashSet<Integer>();
		@Override
		public void store(int[] vals) {
			for (int i : vals) values.add(i);
		}

		@Override
		public boolean match(int testVal) {
			for (int i : values)	
				if (values.contains(testVal+i) || 
					values.contains(testVal-i))
					return true;
			return false;
		}
	}

	private static class ConstantSetMatcher implements Matcher
	{
		Set<Integer> all = new HashSet<Integer>();
		@Override
		public void store(int[] vals) {
			Set<Integer> given = new HashSet<Integer>();
			for (int i : vals)	given.add(i);
			for (int i : vals)	
				for (int j : vals)
					all.add(i+j);
		}

		@Override
		public boolean match(int testVal) {
			return all.contains(testVal);
		}
	}
}
