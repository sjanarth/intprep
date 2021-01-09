package com.coreds.sorting.problems;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example 1:
 * 		Input: 4->2->1->3
 * 		Output: 1->2->3->4
 * Example 2:
 * 		Input: -1->5->3->4->0
 * 		Output: -1->0->3->4->5
 */
public class LinkedListSort 
{
	private static class Node	{
		int value;
		Node next;
		Node(int v) { value = v; }
	}
	
	public static void main (String[] args) {
		Node list = buildSampleList();
		printList("Input", list);
		list = listSort (list);
		printList("Output", list);
	}
	
	private static Node buildSampleList()	{
		int[] values = initRandomArray();
		Node head = new Node(values[0]);
		Node curr = head;
		for (int i = 1; i < values.length; i++) {
			curr.next = new Node(values[i]);
			curr = curr.next;
		}
		return head;
	}
	
	private static int[] initRandomArray()	{
		final int SIZE = 10;
		int[] arr = new int[SIZE];
		for (int i = 0; i < SIZE; i++)	{
			arr[i] = (int) (Math.random()*100);
		}
		return arr;
	}	
	
	private static void printList(String s, Node head) {
		StringBuilder sb = new StringBuilder(s+": {");
		while (head != null)	{
			sb.append(head.value+" => ");
			head = head.next;
		}
		sb.append("}");
		System.out.println(sb.toString());
	}

	private static Node listSort (Node head) {
		if (head == null || head.next == null) return head;
		Node mid = getMiddle (head);
		Node head2 = mid.next;
		mid.next = null;
		//printList("head-1", head);
		//printList("head-2", head2);
		return merge (listSort(head), listSort(head2));
	}
	
	private static Node getMiddle (Node head) {
		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static Node merge (Node head, Node head2)	{
		Node dummy = new Node (0);
		Node curr = dummy;
		while (head != null && head2 != null)	{
			if (head.value < head2.value)	{
				curr.next = head;
				head = head.next;
			} else {
				curr.next = head2;
				head2 = head2.next;
			}
			curr = curr.next;
		}
		if (head != null) curr.next = head;
		if (head2 != null) curr.next = head2;
		return dummy.next;
	}
}