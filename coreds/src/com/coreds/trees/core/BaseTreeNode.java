package com.coreds.trees.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseTreeNode<T> 
{
	public BaseTreeNode (T v)	{
		value = v;
		parent = null;
		children = new ArrayList<BaseTreeNode<T>>();
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T v) {
		value = v;
	}

	public BaseTreeNode<T> getParent() {
		return parent;
	}

	public BaseTreeNode<T> setParent(BaseTreeNode<T> p) {
		BaseTreeNode<T> oldParent = parent;
		parent = p;
		return oldParent;
	}
	
	public List<BaseTreeNode<T>> getChildren()	{
		return children;
	}
	
	public void addChild (BaseTreeNode<T> child) {
		children.add(child);
		if (child != null)	{
			child.setParent(this);
		}
	}
	
	public void addChildren (Collection<BaseTreeNode<T>> nodes) {
		if (nodes == null)
			return;
		for (BaseTreeNode<T> node : nodes)
			addChild (node);
	}
	
	public int getSize ()	{
		int size = 1;
		for (BaseTreeNode<T> child : children)
			size = size + child.getSize();
		return size;
	}
	
	public int getHeight ()	{
		int maxChildHeight = 0;
		for (BaseTreeNode<T> child : children)	{
			if (child != null)	{
				maxChildHeight = Math.max(maxChildHeight, child.getHeight());
			}
		}
		return maxChildHeight+1;
	}
	
	public int getLevel ()	{
		int level = 0;
		BaseTreeNode<T> curr = this;
		while (curr != null)	{
			level++;
			curr = curr.getParent();
		}
		return level;
	}
		
	public boolean isLeaf ()	{
		return children.isEmpty();
	}
	
	public boolean isRoot()	{
		return parent == null;
	}
	
	public boolean isComplete ()	{
		int childCount = children.size();
		for (BaseTreeNode<T> child : children)
			if (child.getChildren().size() != childCount)
				return false;
		return true;
	}
	
	public BaseTreeNode<T> findNode (T v)	{
		if (value != null && value.equals(v)) 
			return this;
		for (BaseTreeNode<T> child : children)	{
			BaseTreeNode<T> node = child.findNode(v);
			if (node != null)	
				return node;
		}
		return null;
	}
	
	@Override
	public String toString()	{
		return value != null ? value.toString() : "";
	}
	
	public String toString2()	{
		StringBuffer sb = new StringBuffer("[||");
		if (value != null)
			sb = new StringBuffer ("["+value.toString()+"|");
		String sep = "";
		for (BaseTreeNode<T> child : children)	{
			if (child != null)	{
				T v = child.getValue();
				sb.append(sep+(v != null ? v.toString() : " "));
				sep = ",";
			}
		}
			
		sb.append("]");
		return sb.toString();
	}

	private T value = null;
	private BaseTreeNode<T> parent = null;
	private List<BaseTreeNode<T>> children = null;

	private static char add3Children (BaseTreeNode<String> root, char start) {
		for (int i = 0; i < 3; i++, start++)
			root.addChild(new BaseTreeNode<String>(String.valueOf(start)));
		return start;
	}
	
	private static BaseTreeNode<String> buildSampleTree()	{
		BaseTreeNode<String> root = new BaseTreeNode<String>("a");
		char ch = add3Children (root, 'b');
		for (BaseTreeNode<String> child : root.getChildren())
			ch = add3Children (child, ch);
		return root;
	}
	
	public static void main (String[] args) {
		BaseTreeNode<String> root = buildSampleTree();
		System.out.println(root.toString());
		for (BaseTreeNode<String> child : root.getChildren())
			System.out.println(child.toString());
	}
}