package com.intprep.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryTreeNode<T> extends BaseTreeNode<T>
{
	public BinaryTreeNode (T v)	{
		super(v);
	}
	
	public BinaryTreeNode (T v, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
		super (v);
		addChild (l);
		addChild (r);
	}
	
	@Override
	public void addChild (BaseTreeNode<T> child) throws UnsupportedOperationException {
		List<BaseTreeNode<T>> children = getChildren();
		if (children != null && children.size() > 1)
			throw new UnsupportedOperationException ("Binary tree cannot have more than 2 children");
		super.addChild(child);
	}
	
	@Override
	public void addChildren (Collection<BaseTreeNode<T>> nodes) {
		if (nodes != null && nodes.size() > 2)
			throw new UnsupportedOperationException ("Cannot add more than 2 children to a binary tree node");
		for (BaseTreeNode<T> node : nodes)
			addChild (node);
	}
	
	public BinaryTreeNode<T> getLeft()	{
		List<BaseTreeNode<T>> children = getChildren();
		if (children != null && children.size() > 0)
			return (BinaryTreeNode<T>) children.get(0);
		return null;
	}
	
	public BinaryTreeNode<T> setLeft (BinaryTreeNode<T> l){
		BinaryTreeNode<T> oldLeft = getLeft();
		addChild (l);	
		return oldLeft;
	}
	
	public BinaryTreeNode<T> getRight()	{
		List<BaseTreeNode<T>> children = getChildren();
		if (children != null && children.size() > 1)
			return (BinaryTreeNode<T>) children.get(1);
		return null;
	}

	public BinaryTreeNode<T> setRight (BinaryTreeNode<T> r){
		BinaryTreeNode<T> oldRight = getRight();
		addChild (r);	
		return oldRight;
	}
	
	public boolean isBalanced ()	{
		BinaryTreeNode<T> leftNode = getLeft();
		int hLeft = leftNode != null ? leftNode.getHeight() : 0;
		BinaryTreeNode<T> rightNode = getRight();
		int hRight = rightNode != null ? rightNode.getHeight() : 0;
		return Math.abs(hLeft - hRight) <= 1;
	}
	
	private static BinaryTreeNode<String> buildSampleTree()	{
		BinaryTreeNode<String> root = new BinaryTreeNode<String> ("root");
		BinaryTreeNode<String> left = new BinaryTreeNode<String> ("left");
		BinaryTreeNode<String> right = new BinaryTreeNode<String> ("right");
		root.setLeft(left);
		root.setRight(right);
		BinaryTreeNode<String> left1 = new BinaryTreeNode<String> ("left-1");
		BinaryTreeNode<String> right1 = new BinaryTreeNode<String> ("right-1");
		left.setLeft(left1);
		left.setRight(right1);
		BinaryTreeNode<String> left2 = new BinaryTreeNode<String> ("left-2");
		BinaryTreeNode<String> right2 = new BinaryTreeNode<String> ("right-2");
		right.setLeft(left2);
		right.setRight(right2);
		return root;
	}
	
	public static void main (String[] args) {
		BinaryTreeNode<String> root = buildSampleTree();
		System.out.println("Found: "+(root.findNode("lef")!=null));
	}
}