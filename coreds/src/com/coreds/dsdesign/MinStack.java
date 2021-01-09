package com.coreds.dsdesign;

import java.util.LinkedList;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/65/design-4/3091/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 */

public class MinStack 
{
	public static void main(String[] args) {
		 MinStack minStack = new MinStack();
		 minStack.push(-2);
		 minStack.push(0);
		 minStack.push(-3);
		 minStack.getMin();
		 minStack.pop();
		 minStack.top();
		 minStack.getMin();
	}
	
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        debug("push, "+x);
        listStack.add(x);
        if (listMin.size() > 0) {
            int curMin = listMin.getLast();
            if (curMin >= x)    {
                listMin.add(x);
            }
        } else {
            listMin.add(x);
        }
    }
    
    public void pop() {
        debug("pop");
        int top = listStack.removeLast();
        int curMin = listMin.getLast();
        if (top == curMin)  {
            listMin.removeLast();
        }
    }
    
    public int top() {
        debug("top");
        return listStack.getLast();
    }
    
    public int getMin() {
        debug("getMin");
        return listMin.getLast();
    }
    
    private void debug(String msg)    {
       System.out.println(msg+", "+listStack.toString()+", "+listMin.toString());
    }
    
    LinkedList<Integer> listStack = new LinkedList<>();
    LinkedList<Integer> listMin = new LinkedList<>();
}