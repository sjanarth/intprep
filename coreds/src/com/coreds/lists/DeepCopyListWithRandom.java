package com.coreds.lists;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyListWithRandom 
{
	private static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	    
	    public String toString()	{
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(val + "/");
	    	if (random != null)
	    		sb.append(random.val);
	    	else
	    		sb.append("Null");
	    	return sb.toString();
	    }
	}
	
	public static void main (String[] args)	{
		Node head = createInitList();
		showList("Original", head);
		Node clone = cloneList(head);
		showList("Cloned", clone);
	}
	
	private static Node cloneList(Node head)	{
		Node head2 = head;
		Node dummy = new Node(0);
		Node curr = dummy;
		Map<Integer,Node> nodeMap = new HashMap<>();
		while (head != null)	{
			nodeMap.putIfAbsent(head.val, new Node(head.val));
			curr.next = nodeMap.get(head.val);
			curr = curr.next;
			head = head.next;
		}
		head = head2;
		curr = dummy.next;
		while (head != null)	{
			if (head.random != null)
				curr.random = nodeMap.get(head.random.val);
			head = head.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	
	private static Node createInitList()	{
		Node head = new Node (7);
		head.next = new Node(13);
		head.next.next = new Node (11);
		head.next.next.next = new Node (10);
		head.next.next.next.next = new Node (1);
		head.next.next.next.next.next = null;
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
 		head.next.next.next.next.random = head;
		return head;
	}
	
	private static void showList (String msg, Node head)	{
		System.out.print(msg + " = {");
		while (head != null)	{
			System.out.print(head.toString()+" -> ");
			head = head.next;
		}
		System.out.println("}");
	}
}

