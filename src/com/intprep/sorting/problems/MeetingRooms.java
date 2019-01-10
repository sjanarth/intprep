package com.intprep.sorting.problems;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of meeting time intervals consisting of start and 
 * end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person 
 * could attend all meetings.
 * 
 * Example 1:
 * 	Input: [[0,30],[5,10],[15,20]]
 * 	Output: false
 * Example 2:
 * 	Input: [[7,10],[2,4]]
 * 	Output: true
 */
public class MeetingRooms 
{
	private static class Interval	{
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
		 public String toString() { return "["+start+","+end+"]"; }
	}
	
	public static void main (String[] args) {
		canAttendAllMeetings (scheduleMeetings1());
		canAttendAllMeetings (scheduleMeetings2());
	}
	
	private static Interval[] scheduleMeetings1()	{
		// [[0,30],[5,10],[15,20]]
		Interval[] meetings = new Interval[3];
		meetings[0] = new Interval(0,30);
		meetings[1] = new Interval(5,10);
		meetings[2] = new Interval(15,20);
		return meetings;
	}

	private static Interval[] scheduleMeetings2()	{
		// [[7,10],[2,4],[5,6]]
		Interval[] meetings = new Interval[3];
		meetings[0] = new Interval(7,10);
		meetings[1] = new Interval(2,4);
		meetings[2] = new Interval(5,6);
		return meetings;
	}
	
	private static boolean canAttendAllMeetings (Interval[] meetings) {
		printMeetings ("Input", meetings);
		Arrays.sort(meetings, new Comparator<Interval>() {
				public int compare(Interval a, Interval b) { return a.start - b.start; }
			});
		printMeetings ("Sorted", meetings);
		for (int i = 1; i < meetings.length; i++) {
			if (meetings[i].start < meetings[i-1].end)	{
				System.out.println("Meeting "+meetings[i]+" overlaps with "+meetings[i-1]+"\n");
				return false;
			}
		}
		System.out.println("No overlaps, all meetings can be attended\n");
		return true;
	}
	
	private static void printMeetings (String s, Interval[] meetings) {
		System.out.print(s+": ");
		for (Interval i : meetings)
			System.out.print(i.toString()+",");
		System.out.println();
	}
}
