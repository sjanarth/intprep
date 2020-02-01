package com.intprep.arrays;

public class ListNode<T> 
{
	T value = null;
	ListNode<T> next = null;
	
	public ListNode (T v, ListNode<T> n) {
		value = v;
		next = n;
	}
	
	public ListNode (T v){
		this (v, null);
	}
	
	public T getValue () { return value; }
	public ListNode<T> getNext () { return next; }
	public ListNode<T> setNext (ListNode<T> n) { 
		ListNode<T> n1 = next;
		next = n;
		return n1;
	}
}