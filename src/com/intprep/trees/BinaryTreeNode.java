package com.intprep.trees;

import java.util.Collection;
import java.util.Iterator;

public class BinaryTreeNode<T> extends BaseTreeNode<T>
{
	public BinaryTreeNode (T v)	{
		this(v, null, null);
	}
	
	public BinaryTreeNode (T v, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
		super (v);
		super.addChild (l);
		super.addChild (r);
	}
	
	@Override
	public void addChild (BaseTreeNode<T> cild) throws UnsupportedOperationException {
		throw new UnsupportedOperationException ("BinaryTreeNode.addChild");
	}
	
	@Override
	public void addChildren (Collection<BaseTreeNode<T>> nodes) {
		throw new UnsupportedOperationException ("BinaryTreeNode.addChildren");
	}
	
	public BinaryTreeNode<T> getLeft()	{
		return (BinaryTreeNode<T>) getChildren().get(0);
	}
	
	public boolean hasLeft()	{
		return getLeft() != null;
	}
	
	public BinaryTreeNode<T> setLeft (BinaryTreeNode<T> l){
		BinaryTreeNode<T> oldLeft = getLeft();
		getChildren().set(0, l);
		l.setParent(this);
		return oldLeft;
	}
	
	public BinaryTreeNode<T> getRight()	{
		return (BinaryTreeNode<T>) getChildren().get(1);
	}
	
	public boolean hasRight()	{
		return getRight() != null;
	}

	public BinaryTreeNode<T> setRight (BinaryTreeNode<T> r){
		BinaryTreeNode<T> oldRight = getRight();
		getChildren().set(1, r);
		r.setParent(this);
		return oldRight;
	}
	
	@Override
	public boolean isLeaf ()	{
		return !hasLeft() && !hasRight();
	}
	
	public String getInOrderString()	{
		StringBuffer sb = new StringBuffer();
		if (getLeft() != null)
			sb.append(getLeft().getInOrderString());
		sb.append(getValue()+" ");
		if (getRight() != null)
			sb.append(getRight().getInOrderString());
		return sb.toString();
	}
	
	public String getPreOrderString()	{
		StringBuffer sb = new StringBuffer();
		sb.append(getValue()+" ");
		if (getLeft() != null)
			sb.append(getLeft().getPreOrderString());
		if (getRight() != null)
			sb.append(getRight().getPreOrderString());
		return sb.toString();
	}

	public String getPostOrderString()	{
		StringBuffer sb = new StringBuffer();
		if (getLeft() != null)
			sb.append(getLeft().getPostOrderString());
		if (getRight() != null)
			sb.append(getRight().getPostOrderString());
		sb.append(getValue()+" ");
		return sb.toString();
	}

	public Iterator<BinaryTreeNode<T>> getPreOrderIterator ()	{
		return new PreOrderIterator<T>(this);
	}

	public Iterator<BinaryTreeNode<T>> getInOrderIterator ()	{
		return new InOrderIterator<T>(this);
	}
	
	public Iterator<BinaryTreeNode<T>> getPostOrderIterator ()	{
		return new PostOrderIterator<T>(this);
	}

	public boolean isBalanced ()	{
		BinaryTreeNode<T> leftNode = getLeft();
		int hLeft = leftNode != null ? leftNode.getHeight() : 0;
		BinaryTreeNode<T> rightNode = getRight();
		int hRight = rightNode != null ? rightNode.getHeight() : 0;
		return Math.abs(hLeft - hRight) <= 1;
	}
	
	private static BinaryTreeNode<String> buildSampleTree()	{
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("a");
		BinaryTreeNode<String> left = new BinaryTreeNode<String>("b");
		left.setLeft(new BinaryTreeNode<String>("d"));
		left.setRight(new BinaryTreeNode<String>("e"));
		root.setLeft(left);
		BinaryTreeNode<String> right = new BinaryTreeNode<String>("c");
		right.setLeft(new BinaryTreeNode<String>("f"));
		right.setRight(new BinaryTreeNode<String>("g"));
		root.setRight(right);
		
		return root;
	}
	
	private static void printTree (String s, Iterator<BinaryTreeNode<String>> it)	{
		System.out.print("\n"+s+": ");
		while (it.hasNext())	{
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		BinaryTreeNode<String> root = buildSampleTree();
		//System.out.println("InOrder: "+root.getInOrderString());
		//printTree ("InOrder", root.getInOrderIterator());
		//System.out.println("PreOrder: "+root.getPreOrderString());
		//printTree ("PreOrder", root.getPreOrderIterator());
		System.out.println("PostOrder: "+root.getPostOrderString());
		printTree ("PostOrder", root.getPostOrderIterator());
	}
}