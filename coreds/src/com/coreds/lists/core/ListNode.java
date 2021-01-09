package com.coreds.lists.core;

public class ListNode<T> 
{
	public T value = null;
	public ListNode<T> next = null;

	public ListNode (T v){
		value = v;
	}
	
	public static<T> void show (String msg, ListNode<T> head)	{
		System.out.print(msg+" = {");
		while (head != null)	{
			System.out.print(head.value);
			if (head.next != null)
				System.out.print(" -> ");
			head = head.next;
		}
		System.out.println("}");
	}
	
	public static ListNode<Integer> getNumberAsList (int num)	{
		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> curr = dummy;
		while (num > 0)	{
			curr.next = new ListNode<>(num%10);
			curr = curr.next;
			num = num / 10;
		}
		return dummy.next;
	}
	
	public static<T> ListNode<T> getAsList(T[] arr)	{
		if (arr == null || arr.length == 0)
			return null;
		ListNode<T> list = new ListNode<T> (arr[0]);
		ListNode<T> current = list;
		for (int i = 1; i < arr.length; i++) {
			current.next = new ListNode<T> (arr[i]);
			current = current.next;
		}
		return list;
	}
}