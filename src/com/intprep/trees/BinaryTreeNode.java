package com.intprep.trees;

import java.util.List;

public class BinaryTreeNode<T> 
{
	public BinaryTreeNode (T v)	{
		value = v;
	}
	
	public BinaryTreeNode (T v, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
		this (v);
		left = l; left.setParent(this);
		right = r; right.setParent(this);
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T v) {
		value = v;
	}
	
	public BinaryTreeNode<T> getLeft()	{
		return left;
	}
	
	public BinaryTreeNode<T> setLeft (BinaryTreeNode<T> l){
		BinaryTreeNode<T> oldLeft = left;
		left = l; left.setParent(this);
		return oldLeft;
	}
	
	public BinaryTreeNode<T> getRight()	{
		return right;
	}

	public BinaryTreeNode<T> setRight (BinaryTreeNode<T> r){
		BinaryTreeNode<T> oldRight = right;
		right = r; right.setParent(this);
		return oldRight;
	}
	
	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public BinaryTreeNode<T> setParent(BinaryTreeNode<T> p) {
		BinaryTreeNode<T> oldParent = parent;
		parent = p;
		return oldParent;
	}

	public int getSize ()	{
		return 1 + 
			(left == null ? 0 : left.getSize()) +
			(right == null ? 0 : right.getSize());
	}
	
	public int getHeight ()	{
		int hLeft = (left == null ? 0 : left.getHeight());
		int hRight = (right == null ? 0 : right.getHeight());
		int max = Math.max (hLeft, hRight);
		return max+1;
	}
	
	public BinaryTreeNode<T> findNode (T v)	{
		if (value != null && value.equals(v))
			return this;
		if (left != null)	{
			BinaryTreeNode<T> node = left.findNode(v);
			if (node != null)
				return node;
		}
		if (right != null)	{
			BinaryTreeNode<T> node = right.findNode(v);
			if (node != null)
				return node;
		}
		return null;
	}
	
	public List<BinaryTreeNode<T>> traverseBfs ()	{
		// TODO:
		return null;
	}
	
	public List<BinaryTreeNode<T>> traverseDfs ()	{
		// TODO:
		return null;
	}

	public List<BinaryTreeNode<T>> traverseInOrder ()	{
		// TODO:
		return null;
	}

	public List<BinaryTreeNode<T>> traversePreOrder ()	{
		// TODO:
		return null;
	}

	public List<BinaryTreeNode<T>> traversePostOrder ()	{
		// TODO:
		return null;
	}
	
	public boolean isBalanced ()	{
		// TODO:
		return false;
	}
	
	public boolean isComplete ()	{
		// TODO:
		return false;
	}
	
	public boolean isBST ()	{
		// TODO:
		return false;
	}
	
	private T value = null;
	private BinaryTreeNode<T> left = null;
	private BinaryTreeNode<T> right = null;
	private BinaryTreeNode<T> parent = null;
	
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
	
	private static void main (String[] args) {
		BinaryTreeNode<String> root = buildSampleTree();
		System.out.println("Found: "+root.findNode("left")!=null);
	}
}