package com.coreds.dsdesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Design a data structure that supports the following two operations: 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string 
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * Example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words  consist of lowercase letters a-z.
 */
public class WordDictionary 
{
	private Map<Integer,Set<String>> wordMap = new HashMap<Integer,Set<String>>();

    /** Initialize your data structure here. */
    public WordDictionary() {
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	System.out.println("Add "+word);
    	Set<String> words = wordMap.get(word.length());
    	if (words == null)	{
    		words = new HashSet<String>();
    	}
    	words.add(word);
    	wordMap.put(word.length(), words);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //System.out.println("search "+word);
    	boolean found = false;
    	/* cheap length match */
    	if (wordMap.containsKey(word.length()))	{
    		Set<String> words = wordMap.get(word.length());
    		/* try exact match */
    		if (words.contains(word))	{
    			found = true;
    		} else {
    			/* try wildcard match */
    			for (String w : words) {
    				if (wildCardSearch(w, word)) {
    					found = true;
    					break;
    				}
    			}
    		}
    	}
    	System.out.println("search("+word+") = "+found);
    	return found;
    }	
    
    private boolean wildCardSearch (String w, String pattern) {
        //System.out.println("    wildCardSearch "+pattern+", "+w);
    	for (int i = 0; i < w.length(); i++)	{
    		char pch = pattern.charAt(i);
            //System.out.println("        i="+i+", pch="+pch+", wch="+w.charAt(i));
    		if (pch != w.charAt(i) && pch != '.')   {
    			return false;
            }
    	}
    	return true;
    }
    
    public static void main (String[] args)	{
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("bad");
    	wd.addWord("dad");
    	wd.addWord("mad");
    	wd.search("pad");
    	wd.search("bad");
    	wd.search(".ad");
    	wd.search("b..");
    }
}
