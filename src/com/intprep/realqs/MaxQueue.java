package com.intprep.realqs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Design a queue data structure that also keeps track of the current maximum.
 * 
 * Two naive approaches come to mind:
 * 
 * 1. Maintain a shadow sorted data structure (linked list or heap) to keep 
 *    track of the maximum values and update it as the queue expands and contracts.
 *    Space: o(n)
 *    Offer: o(n)
 *     Poll: o(1)
 *      Max: o(1)
 *      
 * 2. Maintain a single variable to track the current maximum and update it
 *    as the queue expands and contracts.
 *    Space: o(1)
 *    Offer: o(n)
 *     Poll: o(n) // need to peek through the rest of the queue
 *      Max: o(1)
 * 
 * A more optimal approach involves maintaining a list and updating it
 * 		if a new element < current max, add it to the end of the list
 * 		if a new element > current max, clear the list and add this element 
 * 		Example:
 * 			5,7,3,1,9
 * 			offer(5):   Q: 5 			MQ:	5
 * 			offer(7):	Q: 5,7			MQ: 7		// max can only change after polling 5
 * 			offer(3): 	Q: 5,7,3		MQ: 7,3
 * 			offer(1):	Q: 5,7,3,1		MQ: 7,3,1
 * 			offer(9):	Q: 5,7,3,1,9	MQ: 9		
 * 		
 * 		=> We only need to track the current maximum and any elements following that.
 * 		=> The max queue must also be maintained in a sorted (descending) order.	 
 */

public class MaxQueue 
{
	public static void main (String[] args)	{
		MQueue mq = new MQueue();
        mq.offer(5);
        mq.offer(7);
        mq.poll();
        mq.offer(3);
        mq.offer(1);
        mq.offer(9);
        mq.offer(4);
        mq.poll();
        mq.poll();
        mq.poll();
        mq.poll();
        mq.poll();
	}
	
	private static class MQueue extends LinkedList<Integer> 
	{
		List<Integer> maxList = new ArrayList<Integer>();
		MQueue() {}
		public boolean offer (Integer n)	{
			System.out.print("offer("+n+"): ");
			super.offer(n);
			if (maxList.size() > 0)	{
                for (int i = 0; i < maxList.size(); i++) {
                    if (n > maxList.get(i)) {
                    	for (int j = i; j < maxList.size();)	
                    		maxList.remove(j);
                        break;
                    }
                }
			}
			maxList.add(n);
			System.out.println(toString());
			return true;
		}
		public Integer poll () 	{
			Integer i = super.poll();
			if (i == maxList.get(0))	{
				maxList.remove(0);
			}
			System.out.println("poll():   "+toString());
			return i;
		}
		public Integer max ()	{
			return maxList.size() > 0 ? maxList.get(0) : Integer.MIN_VALUE;
		}
		public String toString()	{
			StringBuilder sb = new StringBuilder();
			sb.append("q="); sb.append(super.toString()); 
			sb.append(",ml="); sb.append(maxList.toString());
			return sb.toString().
						replaceAll(" ", "").
						replaceAll("\\[", "\\{").
						replaceAll("\\]", "\\}");
		}
	}
}
