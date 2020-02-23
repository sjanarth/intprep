package com.intprep.lists;

import com.intprep.lists.core.ListNode;

public class NthFromLast 
{
	public static void main (String[] args)	
	{
		ListNode<Integer> list = ListNode.getAsList(new Integer[] {3,3,23,54,67,89,89,98});
		ListNode.show("Original", list);
		System.out.println("4th from last: "+getNthFromLast(list, 4));
		ListNode<Integer> removed4th = removeNthFromLast(list, 4);; 
		ListNode.show("4th-Removed", removed4th);
	}
	
	public static<T> T getNthFromLast (ListNode<T> list, int n) {
		ListNode<T> p1 = list;
		ListNode<T> p2 = list;
		for (int i = 0; i < n; i++)	{
			p2 = p2.next;
			if (p2 == null)	{  // size < n
				System.out.println("List size smaller than "+n);
				return null;
			}
		}
		while (p2 != null)	{
			p1 = p1.next;
			p2 = p2.next;
		}		
		return p1.value;
	}
	
	public static<T> ListNode<T> removeNthFromLast (ListNode<T> list, int n)	{
		ListNode<T> dummy = new ListNode<T>(null);
		dummy.next = list;
		ListNode<T> p1 = dummy;
		ListNode<T> p2 = dummy;
		for (int i = 0; i <= n; i++)	{
			p2 = p2.next;
			if (p2 == null)	{  // size < n
				System.out.println("List size smaller than "+n);
				return dummy.next;
			}
		}
		while (p2 != null)	{
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return dummy.next;
	}
}