package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AccountsMerge 
{
	public static void main(String[] args) {
		List<List<String>> accounts = setupAccounts();
		showAccounts(accounts);
		List<List<String>> merged = mergeAccounts(accounts);
		System.out.println("Showing merged acounts");
		System.out.println("-----------------------------------------");
		showAccounts(merged);
	}
	
	private static List<List<String>> mergeAccounts (List<List<String>> accounts){
		Map<String,List<List<String>>> emails = new HashMap<>();
		for (List<String> account : accounts) {
			for (int i = 1; i < account.size(); i++)	{
				String email = account.get(i);
				List<List<String>> names = emails.get(email);
				if (names == null) names = new ArrayList<>();
				names.add(account);
				emails.put(email, names);
			}
		}
		System.out.println("Showing combined list");
		System.out.println("-------------------------");
		for (String email : emails.keySet()) {
			System.out.println(email);
			for (List<String> account : emails.get(email))	{
				for (String e : account)
					System.out.println("  "+e);
			}
		}
		List<List<String>> mergedAccounts = new ArrayList<>();
		for (String email : emails.keySet()) {
			List<String> mergedAccount = getMergedEmails (emails.get(email));
			mergedAccounts.add(mergedAccount);
		}
		return mergedAccounts;
	}
	
	private static List<String> getMergedEmails (List<List<String>> accounts){
		String name = accounts.get(0).get(0);
		Set<String> mergedEmails = new TreeSet<String>();
		for (int i = 0; i < accounts.size(); i++)	{
			List<String> emails = accounts.get(i);
			for (int j = 1; j < emails.size(); j++)
				mergedEmails.add(emails.get(j));
		}
		List<String> mergedEmailsList = new ArrayList<>();
		mergedEmailsList.add(name);
		mergedEmailsList.addAll(mergedEmails);
		return mergedEmailsList;
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
