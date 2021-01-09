package com.coreds.lists;

import com.coreds.lists.core.ListNode;

public class IsCyclic 
{
	public static void main (String[] args)	{
		ListNode<Integer> cyclic = getCyclicList();
		System.out.println("isCyclic (cyclic-list) = "+isCyclic(cyclic));
		ListNode<Integer> acyclic = getNonCyclicList();
		System.out.println("isCyclic (Non cyclic-list) = "+isCyclic(acyclic));
	}
	
	private static boolean isCyclic (ListNode<Integer> head) {
		ListNode<Integer> slow = head, fast = head.next;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	
	private static ListNode<Integer> getCyclicList()	{
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(6);
		head.next.next.next = new ListNode<>(3);
		head.next.next.next.next = new ListNode<>(4);
		head.next.next.next.next.next = head.next.next;
		//head.next.next.next.next.next.next = new ListNode<>(6);
		return head;
	}

	private static ListNode<Integer> getNonCyclicList()	{
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(6);
		head.next.next.next = new ListNode<>(3);
		head.next.next.next.next = new ListNode<>(4);
		head.next.next.next.next.next = new ListNode<>(5);
		head.next.next.next.next.next.next = new ListNode<>(6);
		return head;
	}
}
