package com.intprep.lists;

public class RemoveValue 
{
	public static void main (String[] args)	{
		ListNode<Integer> head = getInitList();
		printList("Input", head);
		head = removeValue (head, 6);
		printList("Input", head);
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
