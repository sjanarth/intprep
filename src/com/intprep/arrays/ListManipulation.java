package com.intprep.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListManipulation 
{
	public static ListNode<Integer> removeDups (ListNode<Integer> head){
		Set<Integer> uniqueSet = new HashSet<Integer> ();
		Integer val = head.getValue();
		uniqueSet.add(val);
		ListNode<Integer> uniqueList = new ListNode<Integer> (val);
		ListNode<Integer> uniqueListTail = uniqueList;
		while (head.getNext() != null)	{
			val = head.getNext().getValue();
			if (!uniqueSet.contains(val))	{
				uniqueSet.add(val);
				uniqueListTail.setNext(new ListNode<Integer>(val));
				uniqueListTail = uniqueListTail.getNext();
			}
			head = head.getNext();
		}
		return uniqueList;
	}
	
	public static ListNode<Integer> reverseIterative (ListNode<Integer> list){
		ListNode<Integer> revList = list;
		ListNode<Integer> next = list.getNext();
		revList.setNext(null);
		while (next != null)	{
			ListNode<Integer> temp = next.getNext();
			next.setNext(revList);
			revList = next;	
			next = temp;
		}
		return revList;
	}
	
	public static ListNode<Integer> reverseRecursive (ListNode<Integer> list)	{
		if (list == null || list.getNext() == null) return list;
		ListNode<Integer> node = reverseRecursive(list.getNext());
		list.getNext().setNext(list);
		list.setNext(null);
		return node;
	}
	
	public static Integer getNthFromLast (ListNode<Integer> list, Integer n) {
		ListNode<Integer> p1 = list;
		ListNode<Integer> p2 = list;
		for (int i = 0; i < n; i++)	{
			p2 = p2.getNext();
			if (p2 == null)	{  // size < n
				System.out.println("List size smaller than "+n);
				return null;
			}
		}
		
		while (p2 != null)	{
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		return p1.getValue();
	}
	
	public static ListNode<Integer> createList (int[] items)	{
		if (items == null || items.length == 0)
			return null;
		ListNode<Integer> list = new ListNode<Integer> (items[0]);
		ListNode<Integer> current = list;
		for (int i = 1; i < items.length; i++) {
			current.setNext(new ListNode<Integer> (items[i]));
			current = current.getNext();
		}
		return list;
	}
	
	public static void printList(String tag, ListNode<Integer> list)	{
		System.out.print(tag+": "+list.getValue());
		while (list.getNext() != null)	{
			System.out.print(" => "+list.getNext().getValue());
			list = list.getNext();
		}
		System.out.println();
	}
	
	public static void main (String[] args)	{
		
		ListNode<Integer> list = createList(new int[] {3,3,5,6,9,9,13,21,23,54,67,89,89,98});
		printList("Original", list);
		printList("ReverseIterative", reverseIterative(list));
		System.out.println();	
		
		list = createList(new int[] {3,3,5,6,9,9,13,21,23,54,67,89,89,98});
		printList("Original", list);
		printList("ReverseRecursive", reverseRecursive(list));
		System.out.println();
		
		list = createList(new int[] {3,3,5,6,9,9,13,21,23,54,67,89,89,98});
		printList("Original", list);
		printList("Unique", removeDups(list));
		System.out.println();
		
		list = createList(new int[] {3,3,5,6,9,9,13,21,23,54,67,89,89,98});
		printList("Original", list);
		System.out.println("4th from last: "+getNthFromLast(list, 4));
		System.out.println();
	}
}