package com.intprep.lists;

import java.util.HashSet;
import java.util.Set;

import com.intprep.lists.core.ListNode;

public class RemoveDuplicates 
{
	public static void main (String[] args)	{
		ListNode<Integer> list = ListNode.getAsList(new Integer[] {3,3,5,6,9,9,13,21,23,54,67,89,89,98});
		ListNode.show("Original", list);
		ListNode.show("Unique", removeDups(list));
		System.out.println();
	}
	
	public static ListNode<Integer> removeDups (ListNode<Integer> head){
		Set<Integer> uniqueSet = new HashSet<Integer> ();
		Integer val = head.value;
		uniqueSet.add(val);
		ListNode<Integer> uniqueList = new ListNode<Integer> (val);
		ListNode<Integer> uniqueListTail = uniqueList;
		while (head.next != null)	{
			val = head.next.value;
			if (!uniqueSet.contains(val))	{
				uniqueSet.add(val);
				uniqueListTail.next = new ListNode<Integer>(val);
				uniqueListTail = uniqueListTail.next;
			}
			head = head.next;
		}
		return uniqueList;
	}

}
