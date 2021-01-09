package com.coreds.lists;

import com.coreds.lists.core.ListNode;

/*
 * Leetcode -- add 2 numbers represented by lists. https://leetcode.com/explore/interview/card/google/60/linked-list-5/3063/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 */

public class Add2Numbers 
{
	public static void main(String[] args) {
		ListNode<Integer> num1 = ListNode.getNumberAsList(342);
		ListNode.show("num1", num1);
		ListNode<Integer> num2 = ListNode.getNumberAsList(465);
		ListNode.show("num2", num2);
		ListNode<Integer> sum = addNumbers (num1, num2);
		ListNode.show("Sum", sum);
	}
	
	private static ListNode<Integer> addNumbers (ListNode<Integer> num1, ListNode<Integer> num2)	{
		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> curr = head;
		int sum = 0, carry = 0; 
		while (num1 != null & num2 != null)	{
			sum = num1.value + num2.value + carry;
			carry = sum / 10;
			curr.next = new ListNode<Integer> (sum%10);
			curr = curr.next;
			num1 = num1.next;
			num2 = num2.next;
		}
		while (num1 != null) { 
			sum = num1.value + carry;
			carry = sum / 10;
			curr.next = new ListNode<Integer> (sum%10);
			curr = curr.next;
			num1 = num1.next;
		}
		while (num2 != null) { 
			sum = num2.value + carry;
			carry = sum / 10;
			curr.next = new ListNode<Integer> (sum%10);
			curr = curr.next;
			num2 = num2.next;
		}
		if (carry != 0)	{
			curr.next = new ListNode<>(carry);
		}
		return head.next;
	}
}