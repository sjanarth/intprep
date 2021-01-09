package com.coreds.graphs.problems;

import java.util.*;

/*
 * Leetcode, 721: Accounts Merge
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, 
 * where the first element accounts[i][0] is a name, and the rest of the 
 * elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. 
 * 
 * Two accounts definitely belong to the same person if there is some email 
 * that is common to both accounts. Note that even if two accounts have the 
 * same name, they may belong to different people as people could have the same name. 
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: 
 * 		the first element of each account is the name, and 
 * 		the rest of the elements are emails in sorted order. 
 * 	The accounts themselves can be returned in any order.
 * 
 * Example 1:
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], 
 * 				["John", "johnnybravo@mail.com"], 
 * 				["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
 * 				["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
 * 			["John", "johnnybravo@mail.com"], 
 * 			["Mary", "mary@mail.com"]]
 * 
 * Explanation: 
 * 
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * 
 * Note:
 * 
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 * Reference: http://www.youtube.com/watch?v=J5YnlxbG3hw (happygirlzt)
 */

public class AccountsMerge 
{
	public static void main(String[] args) {
		System.out.println("Showing given acounts");
		System.out.println("-----------------------------------------");
		List<List<String>> accounts = setupAccounts();
		showAccounts(accounts);
		List<List<String>> merged = mergeAccounts(accounts);
		System.out.println("\nShowing merged acounts");
		System.out.println("-----------------------------------------");
		showAccounts(merged);
	}
	
	private static List<List<String>> mergeAccounts (List<List<String>> accounts){
		Map<String,Set<String>> graph = new HashMap<>();
		Map<String,String> emailToNames = new HashMap<>();
		buildGraph (graph, emailToNames, accounts);
		List<List<String>> mergedAccounts = new ArrayList<>();
		Set<String> visited = new HashSet<String>();
		for (String email : graph.keySet()) {
			String name = emailToNames.get(email);
			List<String> mergedAccount = new ArrayList<>();
			dfs(graph, email, mergedAccount, visited);
			if (mergedAccount.size() > 0)	{
				Collections.sort(mergedAccount);
				mergedAccount.add(0, name);
				mergedAccounts.add(mergedAccount);
			}		
		}
		return mergedAccounts;
	}
	
	private static void buildGraph (Map<String,Set<String>> graph, Map<String,String> emailToNames, List<List<String>> accounts) {
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++)	{
				String email = account.get(i);
				emailToNames.put(email, name);
				graph.putIfAbsent(email, new HashSet<>());
				if (i == 1) continue;
				String prev = account.get(i-1);
				graph.get(prev).add(email);
				graph.get(email).add(prev);
			}
		}
	}
	
	private static void dfs(Map<String, Set<String>> graph, String email, List<String> mergedAccount, Set<String> visited) {
		if (!visited.contains(email))	{
			mergedAccount.add(email);
			visited.add(email);
			for (String n : graph.get(email))	{
				dfs (graph, n, mergedAccount, visited);
			}
		}
	}
	
	private static List<List<String>> setupAccounts ()	{
		List<List<String>> accounts = new ArrayList<>();
		List<String> a1 = new ArrayList<>();
		a1.add("John");
		a1.add("johnsmith@mail.com");
		a1.add("john_newyork@mail.com");
		accounts.add(a1);
		List<String> a2 = new ArrayList<>();
		a2.add("John");
		a2.add("johnsmith@mail.com");
		a2.add("john00@mail.com");
		accounts.add(a2);
		List<String> a3 = new ArrayList<>();
		a3.add("Mary");
		a3.add("mary@mail.com");
		accounts.add(a3);
		List<String> a4 = new ArrayList<>();
		a4.add("John");
		a4.add("johnnybravo@mail.com");
		accounts.add(a4);
		return accounts;
	}
	
	private static void showAccounts (List<List<String>> accounts) {
		for (List<String> account : accounts) {
			System.out.println(account.get(0));
			for (int i = 1; i < account.size(); i++)
				System.out.println("    "+account.get(i));
				
		}
	}
}
