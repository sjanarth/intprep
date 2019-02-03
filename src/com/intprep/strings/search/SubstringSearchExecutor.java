package com.intprep.strings.search;

public class SubstringSearchExecutor 
{
	private static AbstractSubstringSearcher[] searchers = new AbstractSubstringSearcher[] {
		new NaiveSubstringSearcher(),
		new JavaSubstringSearcher(),
		new HashBasedSubstringSearcher(),
		new KMPSubstringSearcher(),
		new ZSubstringSearcher(),
		new RabinKarpSubstringSearcher(),
		new SuffixArraySubstringSearcher(),
		//new SuffixTrieSubstringSearcher(),
		//new BoyerMooreSubstringSearcher(),
		//new AhoCorasikSubstringSearcher(),
		//new FiniteStateAutomataSubstringSearcher(),
	};
	
	public static void main (String[] args)	{
		String text = "abcxabcdabxabcdaabcdabcy";
		String pattern = "abcdabcy";
		System.out.println("Text = ["+text+"]");
		System.out.println("Pattern = ["+pattern+"]");
		for (AbstractSubstringSearcher searcher : searchers)	{
			searcher.searchMain(text, pattern);
		}
	}
}
