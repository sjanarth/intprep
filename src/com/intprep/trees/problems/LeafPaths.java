package com.intprep.trees.problems;

import java.util.ArrayList;
import java.util.List;

public class LeafPaths extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new LeafPaths().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root) {
		List<String> allLeafPathsFromRoot = new ArrayList<String>();
		gatherAllLeafPathsFromRoot (allLeafPathsFromRoot, root, new String());
		System.out.println("Number of leaf nodes = "+allLeafPathsFromRoot.size());
		showPaths ("All paths to leaves from root", allLeafPathsFromRoot);
		
		List<String> allLeafPaths = new ArrayList<String>();
		deriveAllLeafPaths (allLeafPaths, allLeafPathsFromRoot);
		showPaths ("All paths to leaves from other leaves", allLeafPaths);
		
		List<String> allUniqLeafPaths = new ArrayList<String>();
		gatherUniqLeafPaths (allUniqLeafPaths, allLeafPaths);
		showPaths ("All uniq paths to leaves from other leaves", allUniqLeafPaths);
	}
	
	private void gatherAllLeafPathsFromRoot (List<String> allLeafPathsFromRoot, Node root, String pathSoFar) {
		if (root == null) return;
		String pathTillThis = pathSoFar.isEmpty() ? 
				new StringBuilder(pathSoFar).append(root.data).toString() : 
				new StringBuilder(pathSoFar).append(DELIM).append(root.data).toString();
		if (root.left == null && root.right == null)
			allLeafPathsFromRoot.add(pathTillThis);
		if (root.left != null)
			gatherAllLeafPathsFromRoot (allLeafPathsFromRoot, root.left, pathTillThis);
		if (root.right != null)
			gatherAllLeafPathsFromRoot (allLeafPathsFromRoot, root.right, pathTillThis);
	}
	
	private void deriveAllLeafPaths (List<String> allLeafPaths, List<String> allLeafPathsFromRoot)	{
		for (int i = 0; i < allLeafPathsFromRoot.size(); i++)	{
			for (int j = 0; j < allLeafPathsFromRoot.size(); j++)	{
				if (i == j) continue;
				addIfLCAExsists (allLeafPaths, allLeafPathsFromRoot.get(i), allLeafPathsFromRoot.get(j));
			}
		}
	}
	
	private void addIfLCAExsists (List<String> allLeafPaths, String path1, String path2)	{
		//System.out.println("addIfLCAExists, p1="+path1+", p2="+path2);
		String[] frags1 = path1.split(DELIM);
		String[] frags2 = path2.split(DELIM);
		int i = 0;
		while (i < frags1.length && 
			   i < frags2.length && 
			   frags1[i].equals(frags2[i])) { 
			i++; 
		}
		//System.out.println("i="+i+", frags1.length="+frags1.length+", frags2.length="+frags2.length+", frags1[i] = "+frags1[i]+", frags2[i]="+frags2[i]);
		if (i < frags1.length && i < frags2.length)	{
			StringBuilder pathBuilder = new StringBuilder(reverse (frags1, i));
			for (int j = i-1; j < frags2.length; j++)
				pathBuilder.append(DELIM).append(frags2[j]);
			//System.out.println("==> adding "+pathBuilder.toString());
			allLeafPaths.add(pathBuilder.toString());
		}
	}
	
	private String reverse (String[] frags, int k) {
		//System.out.print("Reverse-input=");
		//for (int i = 0; i < frags.length; i++) System.out.print(frags[i]+DELIM); System.out.println(" , k="+k);
		StringBuilder sb = new StringBuilder(frags[frags.length-1]);
		for (int i = frags.length-2; i >= k; i--)
			sb.append(DELIM).append(frags[i]);
		//System.out.println("Reverse-output="+sb.toString());
		return sb.toString();
	}
	
	private void gatherUniqLeafPaths (List<String> allUniqLeafPaths, List<String> allLeafPaths)	{
		allUniqLeafPaths.addAll(allLeafPaths);
		for (int i = 0; i < allLeafPaths.size()-1; i++)	{
			String[] frags1 = allLeafPaths.get(i).split(DELIM);
			for (int j = i+1; j < allLeafPaths.size(); j++)	{
				String[] frags2 = allLeafPaths.get(j).split(DELIM);
				if (frags1.length != frags2.length) continue;
				int N = frags1.length-1, k = 0;
				while (k < N && frags1[k].equals(frags2[N-k])) k++;
				if (k == N)
					allUniqLeafPaths.remove(allLeafPaths.get(j));
			}
		}
	}
	
	private void showPaths(String msg, List<String> paths) {
		System.out.println(msg+" (count="+paths.size()+")");
		for (String p : paths) 
			System.out.println(p);
	}
}
