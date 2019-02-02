package com.intprep.strings.search;

public class SubstringSearchExecutor 
{
	private static AbstractSubstringSearcher[] searchers = new AbstractSubstringSearcher[] {
		new NaiveSubstringSearcher(),
		new JavaSubstringSearcher(),
		new KMPSubstringSearcher(),
		new RabinKarpSubstringSearcher(),
		new ZSubstringSearcher(),
		new SuffixTrieSubstringSearcher(),
	};
	
	public static void main (String[] args)	{
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		for (AbstractSubstringSearcher searcher : searchers)	{
			searcher.searchMain(text, pattern);
		}
	}
}
