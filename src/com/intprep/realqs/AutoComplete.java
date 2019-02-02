package com.intprep.realqs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * Great Reference:
 * https://www.youtube.com/watch?v=YGnOGcqaE2A
 */

public class AutoComplete 
{
	public static void main (String[] args)	{
		Trie trie = buildSampleTrie();
		
		List<String> results = trie.searchAlpha("bu");
		for (String s : results) System.out.println("  "+s);
		
		/*
		 * There seem to be at least two approaches to updating the frequency of occurrences.
		 * 
		 * Approach-1: Bubble up
		 * 
		 * 		Every time, updateFreq is called, pass a list of topNodes to the immediate parent.
		 * 		The parents recursively pass up their top used words, eventually leading to the most 
		 * 		used words "bubbling up" to the top. While this approach is efficient for small volumes, 
		 * 		it quickly gets out of control when there are a large number of updateFreq calls.
		 * 
		 * Approach-2: Trickle down
		 * 
		 * 		After doing all updateFreq calls, call crawl on the root which cascades that recursively
		 * 		through the entire tree, effectively decoupling the updates to the frequency counters
		 * 		from the code that determines the top most used words.
		 * 
		 * Typically, updates to the trie occur a set period of time. When they do occur, we expect a
		 * large volume of updates and hence this implementation takes the second (trickle down) approach.
		 * 
		 * There are further optimizations possible here. For instance, updateFreq could mark the node as "dirty"
		 * and the crawl calls could limit themselves to only the dirty nodes. When applied recursively, this
		 * effectively limits the crawl to only those subtrees of the root that have at least one descendant
		 * whose frequency has just been updated. 
		 * 		
		 */
		
		trie.update("ball", 8);
		trie.update("bath", 4);
		trie.update("beet", 11);
		//System.out.println(trie.toString());
		trie.crawl();

		List<String> results2 = trie.searchTopK("b");
		for (String s : results2) System.out.println("  "+s);
	}
	
	private static Trie buildSampleTrie() 	{
		Trie root = new Trie();
		root.add("ball");
		root.add("barley");
		root.add("bat");
		root.add("battle");
		root.add("batch");
		root.add("bath");
		root.add("beast");
		root.add("beet");
		root.add("bell");
		root.add("best");
		root.add("book");
		root.add("boot");
		root.add("botch");
		root.add("box");
		root.add("broad");
		root.add("bull");
		root.add("bust");
		root.add("but");
		root.add("butt");
		root.add("butler");
		root.add("butter");
		root.add("button");
		//System.out.println(root.toString());
		return root;
	}
	
	private static class Trie
	{
		public Trie() {
			root = new TrieNode();
		}
		public TrieNode add (String word) {
			//System.out.println("Trie.add, s="+s);
			word = word.toLowerCase();	// done typically to minimize the overall size of the trie
			Queue<Character> q = toCharQueue(word);
			return root.add(q);
		}
		public List<String> searchAlpha (String prefix)	{
			System.out.println("searchAlpha, prefix="+prefix);
			Queue<Character> q = toCharQueue(prefix);
			TrieNode node = root.findNode(q);
			if (node != null)	{
				//System.out.println(node.toString(0));
				/*
				prefix = prefix.substring(0, prefix.length()-1);
				List<String> results = new ArrayList<String>();
				for (String s : node.getAllChildStrings())
					results.add(prefix+s);
				*/
				return node.getAllChildStrings();
			}
			return new ArrayList<String>();
		}
		public List<String> searchTopK (String prefix)	{
			System.out.println("searchTopK, prefix="+prefix);
			Queue<Character> q = toCharQueue(prefix);
			TrieNode node = root.findNode(q);
			if (node != null)	{
				//System.out.println(node.toString(0));	
				return node.getTopChildStrings();
			}
			return new ArrayList<String>();
		}
		public Integer update (String s, int freq)	{
			Queue<Character> qPrefix = toCharQueue(s);
			TrieNode node = root.findNode(qPrefix);
			if (node == null)
				node = add(s);
			return node.children.get(null).setFrequency(freq);
		}
		public void crawl ()	{
			root.crawl();
		}
		public String toString () {
			StringBuilder sb = new StringBuilder();
			sb.append(root.toString(0));
			return sb.toString();
		}
		private Queue<Character> toCharQueue(String s) {
			Queue<Character> q = new LinkedList<Character>();
			for (Character c : s.toCharArray())
				q.add(c);
			return q;
		}
		
		private TrieNode root = null;
	}
	
	private static class TrieNode 
	{
		private static final int DEFAULT_TOP_K = 3;
		public TrieNode () { 
			this(null, null); 
		}
		public TrieNode (Character ch, TrieNode p) { 
			c = ch; 
			freq = 0;
			children = new TreeMap<Character,TrieNode>(new NullCharComparator());
			parentNode = p;	// a more clever implementation could do away with this
			topNodes = new TrieNode[DEFAULT_TOP_K];
			for (int i = 0; i < DEFAULT_TOP_K; i++)
				topNodes[i] = null;
		}
		public Integer setFrequency (Integer f)	{
			Integer old = freq;
			freq = f;
			return old;
		}
		public boolean isWord () {
			return c == null && children.isEmpty();
		}
		public boolean isRoot () {
			return c == null && !children.isEmpty();
		}
		public TrieNode[] crawl ()	{
			if (isWord()) {
				topNodes[0] = this;
			} else {
				for (TrieNode child : children.values())	{
					for (TrieNode topK : child.crawl())	{
						if (topK == null) break;
						for (int i = 0; i < DEFAULT_TOP_K; i++)	{
							if (topNodes[i] == null) {
								topNodes[i] = topK;
								break;
							} else if (topNodes[i].freq < topK.freq)	{
								for (int j = DEFAULT_TOP_K-1; j > i; j--)
									topNodes[j] = topNodes[j-1];
								topNodes[i] = topK;
								break;
							}
						}
					}
				}
			}
			return topNodes;
		}
		public TrieNode add(Queue<Character> q)	{
			Character nextChar = null;
			if (!q.isEmpty()) 
				nextChar = q.poll();
			TrieNode child = children.get(nextChar);
			if (child == null)	{
				child = new TrieNode(nextChar,this);
				children.put(nextChar, child);
			}
			if (nextChar != null)
				child.add(q);
			return child;
		}
		public TrieNode findNode(Queue<Character> qPrefix)	{
			if (qPrefix.isEmpty()) 
				return this;// children.get(null);
			Character nextChar = qPrefix.poll();
			if(!children.containsKey(nextChar)) 
				return null;
			TrieNode nextNode = children.get(nextChar);
			return nextNode.findNode(qPrefix);
		}
		public String getString ()  {
			StringBuilder sb = new StringBuilder();
			TrieNode curr = this;
			while (curr != null) {
				if (curr.c != null)
					sb.append(curr.c);
				curr = curr.parentNode;
			}
			return sb.reverse().toString();
		}
		public List<String> getAllChildStrings ()	{
			List<String> allStrings = new ArrayList<String>();
			if (isWord()) { 
				allStrings.add(""); 
				return allStrings; 
			}
			for(TrieNode child : children.values())	
				for (String s : child.getAllChildStrings()) 	
					allStrings.add(c+s);
			return allStrings;
		}
		public List<String> getTopChildStrings ()	{
			List<String> topStrings = new ArrayList<String>();
			for (TrieNode topNode : topNodes)	{
				if (topNode != null)	{
					StringBuilder sb = new StringBuilder();
					sb.append(topNode.getString());
					sb.append("("); sb.append(topNode.freq); sb.append(")");
					topStrings.add(sb.toString());
				}
			}
			return topStrings;
		}
		public String toString (int level) {
			StringBuilder sb = new StringBuilder();
			if (isRoot()) {
				sb.append("/");
				for (Character ch : children.keySet()) {
					sb.append("\n");
					TrieNode child = children.get(ch);
					sb.append(child.toString(level+1));
				}
			} else {
				for (int i = 1; i < level; i++) sb.append(" ");
				sb.append("\\_");
				if (isWord()) {
					sb.append("."); 
					sb.append("("); sb.append(freq); sb.append(")");
				} else {
					sb.append(c);
					for (Character ch : children.keySet()) {
						sb.append("\n");
						TrieNode child = children.get(ch);
						sb.append(child.toString(level+2));
					}
				}
			}
			return sb.toString();
		}
		
		private Integer freq = null;
		private Character c = null;
		private Map<Character,TrieNode> children = null;
		private TrieNode parentNode = null;
		private TrieNode[] topNodes = null;
	}
	
	private static class NullCharComparator implements Comparator<Character>	{
		@Override
		public int compare(Character o1, Character o2) {
			if (o1 == null && o2 == null) return 0;
			if (o1 == null) return -1;
			if (o2 == null) return 1;
			return o1.compareTo(o2);
		}
	}
}