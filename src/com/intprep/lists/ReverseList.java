package com.intprep.lists;

import com.intprep.lists.core.ListNode;

public class ReverseList 
{
	public static void main (String[] args)	{
		ListNode<Integer> head = ListNode.getAsList(new Integer[] {1,2,6,3,4,5,6});
		ListNode.show("Input", head);
		ListNode.show("Output-Iterative", reverseIterative(head));
		head = ListNode.getAsList(new Integer[] {1,2,6,3,4,5,6});
		ListNode.show("Output-Recursive", reverseRecursive(head));
	}
	
	private static ListNode<Integer> reverseIterative(ListNode<Integer> head)	{
		ListNode<Integer> prev = null, cur = head;
		while (cur != null)	{
			ListNode<Integer> saved = cur.next;
			cur.next = prev;
			prev = cur;
			cur = saved;
		}
		return prev;
	}
	
	public static ListNode<Integer> reverseRecursive (ListNode<Integer> list)	{
		if (list == null || list.next == null) return list;
		ListNode<Integer> node = reverseRecursive(list.next);
		list.next.next = list;
		list.next = null;
		return node;
	}
}
