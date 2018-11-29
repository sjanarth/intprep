package com.intprep.trees.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractTreeProblem 
{
	protected static final String DELIM = ",";

	protected static class Node {
		int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
	
	public void executeAllTestCases ()	{
		Map<String,Node> trees = buildSampleTrees();
		for (String key : trees.keySet()) {
			System.out.println("        **** "+key+" ****");
			Node tree = trees.get(key);
			showTree(tree);
			mainLogic(tree);
			System.out.println();
			System.out.println();
		}
	}
    
	protected Map<String,Node> buildSampleTrees()	{
		Map<String, Node> trees = new LinkedHashMap<String, Node>();
		trees.put("Null tree", null);
		trees.put("Single node tree", new Node(1));
		trees.put("Simple 3 node tree", buildSimpleTree());
		trees.put("Left skewed tree", buildLeftOnlyTree());
		trees.put("Right skewed tree", buildRightOnlyTree());
		trees.put("Large tree", buildLargeTree());
		trees.put("Small Subtree of Large tree", buildSmallSubOfLargeTree());
		trees.put("Bigger Subtree of Large tree", buildBiggerSubOfLargeTree());
		trees.put("Deep tree", buildDeepTree());
		trees.put("Large BST", buildLargeBSTTree());
		trees.put("Wide tree", buildWideTree());
		trees.put("Incomplete tree", buildInCompleteTree());
		trees.put("Duplicates tree", buildDuplicatesTree());
		Node custTree = buildCustomTree();
		if (custTree != null)	{
			trees.put("Custom tree", custTree);
		}
		return trees;
	}

	protected Node buildCustomTree()	{
		return null;
	}
	
	protected Node buildDuplicatesTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);	n1.left = n2;
		Node n3 = new Node(3);	n1.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n22 = new Node(2);	n3.left = n22;
		return n1;
	}

	protected Node buildInCompleteTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);		n1.left = n2;
		Node n3 = new Node(3);		n1.right = n3;
		Node n4 = new Node(4);		n2.left = n4;
		Node n5 = new Node(5);		n2.right = n5;
		Node n6 = new Node(6);		n3.left = n6;
		Node n7 = new Node(7);		n3.right = n7;
		Node n8 = new Node(8);		n4.left = n8;
		Node n9 = new Node(9);		n4.right = n9;
		Node n10 = new Node(10);	n5.left = n10;
		Node n11 = new Node(11);	n5.right = n11;
		Node n16 = new Node(16);	n8.left = n16;
		Node n17 = new Node(17);	n8.right = n17;
		Node n18 = new Node(18);	n9.left = n18;
		Node n19 = new Node(19);	n9.right = n19;
		Node n20 = new Node(20);	n10.left = n20;
		Node n21 = new Node(21);	n10.right = n21;
		Node n22 = new Node(22);	n11.left = n22;
		Node n23 = new Node(23);	n11.right = n23;
		return n1;
	}

	protected Node buildWideTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);		n1.left = n2;
		Node n3 = new Node(3);		n1.right = n3;
		Node n4 = new Node(4);		n2.left = n4;
		Node n7 = new Node(7);		n3.right = n7;
		Node n8 = new Node(8);		n4.left = n8;
		Node n9 = new Node(9);		n4.right = n9;
		Node n14 = new Node(14);	n7.left = n14;
		Node n15 = new Node(15);	n7.right = n15;
		Node n16 = new Node(16);	n8.left = n16;
		Node n17 = new Node(17);	n8.right = n17;
		Node n18 = new Node(18);	n9.left = n18;
		Node n19 = new Node(19);	n9.right = n19;
		Node n28 = new Node(28);	n14.left = n28;
		Node n29 = new Node(29);	n14.right = n29;
		Node n30 = new Node(30);	n15.left = n30;
		Node n31 = new Node(31);	n15.right = n31;
		return n1;
	}

	protected Node buildLargeBSTTree() {
		Node n50 = new Node(50);
		Node n40 = new Node(40); n50.left = n40;
		Node n90 = new Node(90); n50.right = n90;
		Node n30 = new Node(30); n40.left = n30;
		Node n45 = new Node(45); n40.right = n45;
		Node n80 = new Node(80); n90.left = n80;
		Node n95 = new Node(95); n90.right = n95;
		return n50;
	}

	protected Node buildDeepTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);		n1.left = n2;
		Node n3 = new Node(3);		n1.right = n3;
		Node n4 = new Node(4);		n2.left = n4;
		Node n5 = new Node(5);		n2.right = n5;
		Node n6 = new Node(6);		n3.left = n6;
		Node n7 = new Node(7);		n3.right = n7;
		Node n10 = new Node(10);	n5.left = n10;
		Node n11 = new Node(11);	n5.right = n11;
		Node n12 = new Node(12);	n6.left = n12;
		Node n13 = new Node(13);	n6.right = n13;
		Node n22 = new Node(22);	n11.left = n22;
		return n1;
	}

	protected Node buildSmallSubOfLargeTree() {
		Node n4 = new Node(4);		
		Node n8 = new Node(8);		n4.left = n8;
		Node n9 = new Node(9);		n4.right = n9;
		return n4;
	}

	protected Node buildBiggerSubOfLargeTree() {
		Node n4 = new Node(4);		
		Node n8 = new Node(8);		n4.left = n8;
		Node n9 = new Node(9);		n4.right = n9;
		Node n16 = new Node(16);	n8.left = n16;
		Node n17 = new Node(17);	n8.right = n17;
		Node n18 = new Node(18);	n9.left = n18;
		Node n19 = new Node(19);	n9.right = n19;
		return n4;
	}

	protected Node buildLargeTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);		n1.left = n2;
		Node n3 = new Node(3);		n1.right = n3;
		Node n4 = new Node(4);		n2.left = n4;
		Node n5 = new Node(5);		n2.right = n5;
		Node n6 = new Node(6);		n3.left = n6;
		Node n7 = new Node(7);		n3.right = n7;
		Node n8 = new Node(8);		n4.left = n8;
		Node n9 = new Node(9);		n4.right = n9;
		Node n10 = new Node(10);	n5.left = n10;
		Node n11 = new Node(11);	n5.right = n11;
		Node n12 = new Node(12);	n6.left = n12;
		Node n13 = new Node(13);	n6.right = n13;
		Node n14 = new Node(14);	n7.left = n14;
		Node n15 = new Node(15);	n7.right = n15;
		Node n16 = new Node(16);	n8.left = n16;
		Node n17 = new Node(17);	n8.right = n17;
		Node n18 = new Node(18);	n9.left = n18;
		Node n19 = new Node(19);	n9.right = n19;
		Node n20 = new Node(20);	n10.left = n20;
		Node n21 = new Node(21);	n10.right = n21;
		Node n22 = new Node(22);	n11.left = n22;
		Node n23 = new Node(23);	n11.right = n23;
		Node n24 = new Node(24);	n12.left = n24;
		Node n25 = new Node(25);	n12.right = n25;
		Node n26 = new Node(26);	n13.left = n26;
		Node n27 = new Node(27);	n13.right = n27;
		Node n28 = new Node(28);	n14.left = n28;
		Node n29 = new Node(29);	n14.right = n29;
		Node n30 = new Node(30);	n15.left = n30;
		Node n31 = new Node(31);	n15.right = n31;
		return n1;
	}

	protected Node buildRightOnlyTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);	n1.right = n2;
		Node n3 = new Node(3);	n2.right = n3;
		Node n4 = new Node(4);	n3.right = n4;
		Node n5 = new Node(5);	n4.right = n5;
		return n1;
	}

	protected Node buildLeftOnlyTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);	n1.left = n2;
		Node n3 = new Node(3);	n2.left = n3;
		Node n4 = new Node(4);	n3.left = n4;
		Node n5 = new Node(5);	n4.left = n5;
		return n1;
	}

	protected Node buildSimpleTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);	n1.left = n2;
		Node n3 = new Node(3);	n1.right = n3;
		return n1;
	}
	
	protected void showTree (Node root) {
		System.out.println("InOrder: "+traverseInOrder(root));
		System.out.println("PreOrder: "+traversePreOrder(root));
	}
	    
	protected String traverseInOrder(Node node) {
		if (node == null) return "";
		StringBuilder sb = new StringBuilder();
		if (node.left != null)
			sb.append(traverseInOrder(node.left));
		if (sb.length() > 0) sb.append(DELIM);
		sb.append(node.data);
		if (node.right != null)
			sb.append(DELIM+traverseInOrder(node.right));
		return sb.toString();
	}
	
	protected String traversePreOrder(Node node)	{
		if (node == null) return "";
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		if (node.left != null)
			sb.append(DELIM+traversePreOrder(node.left));
		if (node.right != null)
			sb.append(DELIM+traversePreOrder(node.right));
		return sb.toString();
	}
	
	protected abstract void mainLogic(Node root);
}