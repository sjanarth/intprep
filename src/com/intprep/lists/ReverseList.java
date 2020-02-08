package com.intprep.lists;

public class ReverseList 
{
	public static void main (String[] args)	{
		ListNode<Integer> head = getInitList();
		printList("Input", head);
		head = reverseList(head);
		printList("Output", head);
	}
	
	private static ListNode<Integer> reverseList(ListNode<Integer> head)	{
		ListNode<Integer> prev = null, cur = head;
		while (cur != null)	{
			ListNode<Integer> saved = cur.next;
			cur.next = prev;
			prev = cur;
			cur = saved;
		}
		return prev;
	}
	
	private static ListNode<Integer> getInitList()	{
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(6);
		head.next.next.next = new ListNode<>(3);
		head.next.next.next.next = new ListNode<>(4);
		head.next.next.next.next.next = new ListNode<>(5);
		head.next.next.next.next.next.next = new ListNode<>(6);
		return head;
	}
	
	private static void printList(String s, ListNode<Integer> head) {
		System.out.print(s+": {"+head.value);
		ListNode<Integer> cur = head.next;
		while(cur != null) {
			System.out.print("->"+cur.value);
			cur = cur.next;
		}
		System.out.println("}");
	}
}
