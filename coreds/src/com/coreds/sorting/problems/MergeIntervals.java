package com.coreds.sorting.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * 	Input: [[1,3],[2,6],[8,10],[15,18]]
 * 	Output: [[1,6],[8,10],[15,18]]
 * 	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 	Input: [[1,4],[4,5]]	
 * 	Output: [[1,5]]
 * 	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals 
{
	private static class Interval	{
		int start, end;
		// Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }		
	}
	
	public static void main (String[] args) {
		List<Interval> intervals = initIntervals();
		print("Source", intervals);
		List<Interval> merged = merge (intervals);
		print("Merged", merged);
	}
	
	private static List<Interval> initIntervals () {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval (1,3));
		intervals.add(new Interval (2,6));
		intervals.add(new Interval (8,10));
		intervals.add(new Interval (15,18));
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
	
    private static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
            return new ArrayList<Interval>();        
        Collections.sort(intervals, new Comparator<Interval>() {
                public int compare (Interval i1, Interval i2)   {
                    return i1.start - i2.start;
                }
            });
        List<Interval> output = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (Interval curr : intervals)	{
            if(curr.start > prev.end){
                output.add(prev);
                prev = curr;
            } else {
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            }
        }
        output.add(prev);
        return output;
    }	
}	