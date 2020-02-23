package com.intprep.lists;

import com.intprep.lists.core.ListNode;

public class RemoveValue 
{
	public static void main (String[] args)	{
		ListNode<Integer> head = ListNode.getAsList(new Integer[] {1,2,6,3,4,5,6});
		ListNode.show("Input", head);
		head = removeValue (head, 6);
		ListNode.show("Input", head);
	}
	
	private static ListNode<Integer> removeValue (ListNode<Integer> head, int val)	{
		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> prev = dummy, cur = head;
		while (cur != null)	{
			if (cur.value == val) {
				prev.next = cur.next;
			} else {
				prev.next = cur; prev = cur;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
