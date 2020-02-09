package com.intprep.sorting.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		canAttendAllMeetings (scheduleMeetings3());
		canAttendAllMeetings (scheduleMeetings4());
		findMinMeetingRooms (scheduleMeetings1());
		findMinMeetingRooms (scheduleMeetings2());
		findMinMeetingRooms (scheduleMeetings3());
		findMinMeetingRooms (scheduleMeetings4());
		findMinMeetingRooms (new Interval[] {new Interval(13,15), new Interval(1,13)});
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
	
	private static Interval[] scheduleMeetings3()	{
		// [[4,9],[4,17],[9,10]]
		Interval[] meetings = new Interval[3];
		meetings[0] = new Interval(4,9);
		meetings[1] = new Interval(4,17);
		meetings[2] = new Interval(9,10);
		return meetings;
	}

	private static Interval[] scheduleMeetings4()	{
		// [[2,11],[11,16],[6,16]]
		Interval[] meetings = new Interval[3];
		meetings[0] = new Interval(2,11);
		meetings[1] = new Interval(11,16);
		meetings[2] = new Interval(6,16);
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
	
	private static int findMinMeetingRooms (Interval[] meetings)	{
		printMeetings ("Input", meetings);
		Arrays.sort(meetings, new Comparator<Interval>() {
				public int compare(Interval a, Interval b) { return a.start - b.start; }
			});
		printMeetings ("Sorted", meetings);
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(meetings.length, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) { return o1.end - o2.end; }
			});
		for (int i = 0; i < meetings.length; i++)	{
			if (queue.isEmpty()) {
				queue.offer(meetings[i]);
			} else	{
				Interval earliestFinishing = queue.poll();
				if (earliestFinishing.end <= meetings[i].start)	{
					earliestFinishing.end = meetings[i].end;
				} else {
					queue.offer(meetings[i]);
				}
				queue.offer(earliestFinishing);
			}
		}
		int minRooms = queue.size();
		System.out.println("Minimum meeting rooms needed = "+minRooms+"\n");
		return minRooms;
	}
	
	private static void printMeetings (String s, Interval[] meetings) {
		System.out.print(s+": ");
		for (Interval i : meetings)
			System.out.print(i.toString()+",");
		System.out.println();
	}
}
