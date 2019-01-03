package com.intprep.sorting.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * 	Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 	Output: [[1,5],[6,9]]
 * Example 2:
 * 	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 	Output: [[1,2],[3,10],[12,16]]
 * 	Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval 
{
	private static class Interval	{
		int start, end;
		// Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }		
	}
	
	public static void main (String[] args) {
		List<Interval> intervals = initIntervals();
		print("Source", intervals);
		List<Interval> sorted = insert (intervals, new Interval(4,8));
		print("Sorted", sorted);
	}
	
	private static List<Interval> initIntervals () {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval (1,2));
		intervals.add(new Interval (3,5));
		intervals.add(new Interval (6,7));
		intervals.add(new Interval (8,10));
		intervals.add(new Interval (12,16));
		return intervals;
	}
	
	private static void print (String s, List<Interval> ints) {
		StringBuilder sb = new StringBuilder(s+" [");
		for (Interval i : ints)	{
            sb.append("{"); 
			sb.append(i.start); sb.append(","); sb.append(i.end);
			sb.append("},"); 
		}
        sb.append("]");
		System.out.println(sb.toString());
	}
	
	private static List<Interval> insert(List<Interval> intervals, Interval newInterval) 	{
        if (intervals == null || intervals.contains(newInterval)) {
            return intervals;
        } else {
            List<Interval> output = new ArrayList<Interval>();
            for (Interval i: intervals)  {
                if (newInterval == null || i.end < newInterval.start)  {	// greater than i
                    output.add(i);
                } else if (i.start > newInterval.end)   {	// less than i			
                    output.add(newInterval);
                    output.add(i);
                    newInterval = null;
                } else {	// overlaps with i
                    newInterval.start = newInterval.start > i.start ? i.start : newInterval.start;
                    newInterval.end = newInterval.end < i.end ? i.end : newInterval.end; 
                }
            }
            if (newInterval != null)    {
                output.add(newInterval);
            }
            return output;
        }	
	}
}
