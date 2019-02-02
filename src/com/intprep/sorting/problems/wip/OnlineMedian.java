package com.intprep.sorting.problems.wip;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 */

public class OnlineMedian 
{
	public static void main (String[] args)	{
		OnlineMedian om = new OnlineMedian();
		om.addNum(4);
        System.out.println(om.getMedian());
        om.addNum(8);
        System.out.println(om.getMedian());
        om.addNum(2);
        System.out.println(om.getMedian());
        om.addNum(11);
        System.out.println(om.getMedian());
        om.addNum(13);
        System.out.println(om.getMedian());
        om.addNum(14);
        System.out.println(om.getMedian());
        om.addNum(-1);
        System.out.println(om.getMedian());
	}
	public void addNum (Integer n) {
		maxQ.add(n);
		System.out.println("add "+n+", peek="+maxQ.peek());
	}
	
	public double getMedian ()	{
		if (minQ.size() == maxQ.size())
			return ((double)minQ.peek() + (double)maxQ.peek())/2;
		else
			return (double) maxQ.peek();
	}

	private PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(100, Collections.reverseOrder());
}