package com.intprep.realqs;

import java.util.ArrayList;
import java.util.List;

import com.intprep.strings.core.BasicTrieNode;
import com.intprep.strings.core.GenericTrieNode;

public class AutoCompleteTrieNode extends GenericTrieNode
{
	private static final int DEFAULT_TOP_K = 3;
	private static final String TRIENODE_PROPERTY_FREQUENCY = "freq";
	private static final String TRIENODE_PROPERTY_TOPK = "topK";
	
	public AutoCompleteTrieNode () { 
		this (null, null); 
	}
	
	public AutoCompleteTrieNode (Character ch, AutoCompleteTrieNode p) {
		super (ch, p);
		setDefaultProps();
	}
	
	public Integer getFrequency ()	{
		return (Integer) getProperty (TRIENODE_PROPERTY_FREQUENCY);
	}
	
	public Integer setFrequency (Integer f)	{
		return (Integer) setProperty (TRIENODE_PROPERTY_FREQUENCY, f);
	}
	
	public AutoCompleteTrieNode[] crawl ()	{
		AutoCompleteTrieNode[] topNodes = (AutoCompleteTrieNode[]) properties.get(TRIENODE_PROPERTY_TOPK);
		if (isWord()) {
			topNodes[0] = this;
		} else {
			for (BasicTrieNode child : children.values())	{
				AutoCompleteTrieNode achild = (AutoCompleteTrieNode) child;
				for (AutoCompleteTrieNode topK : achild.crawl())	{
					if (topK == null) break;
					for (int i = 0; i < DEFAULT_TOP_K; i++)	{
						if (topNodes[i] == null) {
							topNodes[i] = topK;
							break;
						} else if (topNodes[i].getFrequency() < topK.getFrequency())	{
							for (int j = DEFAULT_TOP_K-1; j > i; j--)
								topNodes[j] = topNodes[j-1];
							topNodes[i] = topK;
							break;
						}
					}
				}
			}
		}
		properties.put(TRIENODE_PROPERTY_TOPK, topNodes);
		return topNodes;
	}
	
	public List<String> getTopChildStrings ()	{
		List<String> topStrings = new ArrayList<String>();
		AutoCompleteTrieNode[] topNodes = (AutoCompleteTrieNode[]) getProperty (TRIENODE_PROPERTY_TOPK);
		for (AutoCompleteTrieNode topNode : topNodes)	{
			if (topNode != null)	{
				StringBuilder sb = new StringBuilder();
				sb.append(topNode.getString());
				sb.append("("); sb.append(topNode.getFrequency()); sb.append(")");
				topStrings.add(sb.toString());
			}
		}
		return topStrings;
	}
	
	@Override
	public String toString (int level) {
		StringBuilder sb = new StringBuilder();
		if (isRoot()) {
			sb.append("/");
			for (Character ch : children.keySet()) {
				sb.append("\n");
				AutoCompleteTrieNode child = (AutoCompleteTrieNode) children.get(ch);
				sb.append(child.toString(level+1));
			}
		} else {
			for (int i = 1; i < level; i++) sb.append(" ");
			sb.append("\\_");
			if (isWord()) {
				sb.append("."); 
				sb.append("("); sb.append(getFrequency()); sb.append(")");
			} else {
				sb.append(c);
				for (Character ch : children.keySet()) {
					sb.append("\n");
					AutoCompleteTrieNode child = (AutoCompleteTrieNode) children.get(ch);
					sb.append(child.toString(level+2));
				}
			}
		}
		return sb.toString();
	}
	
	protected void setDefaultProps ()	{
		// frequency
		properties.put(TRIENODE_PROPERTY_FREQUENCY, Integer.valueOf(0));
		// top K nodes
		AutoCompleteTrieNode[] topNodes = new AutoCompleteTrieNode[DEFAULT_TOP_K];
		for (int i = 0; i < DEFAULT_TOP_K; i++)
			topNodes[i] = null;
		properties.put(TRIENODE_PROPERTY_TOPK, topNodes);
	}
}