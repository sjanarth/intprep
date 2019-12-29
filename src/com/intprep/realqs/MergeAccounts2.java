package com.intprep.realqs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * Given a list accounts, each element accounts[i] is a list of strings, 
 * where the first element accounts[i][0] is a name, and the rest of the 
 * elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to 
 * the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to different 
 * people as people could have the same name. A person can have any number of 
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: 
 * the first element of each account is the name, and the rest of the elements 
 * are emails in sorted order. The accounts themselves can be returned in any order.
 * Example 1:
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], 
 *             ["John", "johnnybravo@mail.com"], 
 *             ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
 *             ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
 * 			["John", "johnnybravo@mail.com"], 
 * 			["Mary", "mary@mail.com"]]
 * 
 * Explanation: 
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */

public class MergeAccounts2 
{
	public static void main(String[] args) {
		/*
		Set<String> emails = new TreeSet<String>();
		emails.add("john_newyork@mail.com");
		emails.add("john000@mail.com");
		emails.add("johnsmith@mail.com");
		for (String e : emails)	{
			System.out.println(e);
		}
		*/
		List<List<String>> accounts = buildSampleListOfAccounts();
		showAccounts("Initial", accounts);
		List<List<String>> merged = mergeAccounts(accounts);
		showAccounts("Merged", merged);
	}
	
	private static List<List<String>> buildSampleListOfAccounts()	{
		/*
		List<String> satish = new ArrayList<String>();
		satish.add("Satish");
		satish.add("sjanarth@gmail.com");
		satish.add("satish.janarthanan@gmail.com");
		List<String> viji = new ArrayList<String>();
		viji.add("Viji");
		viji.add("viji.venkatesan@gmail.com");
		viji.add("mummy@mial.com");
		List<String> somebody = new ArrayList<String>();
		somebody.add("Somebody");
		somebody.add("sjanarth@gmail.com");
		somebody.add("someone@somewhere.com");
		*/
		List<String> john = new ArrayList<String>();
		john.add("John");
		john.add("johnsmith@mail.com");
		john.add("john_newyork@mail.com");
		List<String> john2 = new ArrayList<String>();
		john2.add("John");
		john2.add("johnsmith@mail.com");
		john2.add("john00@mail.com");
		List<String> mary = new ArrayList<String>();
		mary.add("Mary");
		mary.add("mary@mail.com");
		List<String> john3 = new ArrayList<String>();		
		john3.add("John");
		john3.add("johnnybravo@mail.com");
		List<List<String>> accounts = new ArrayList<List<String>>();
		accounts.add(john);
		accounts.add(john2);
		accounts.add(mary);
		accounts.add(john3);
		return accounts;
	}
	
	private static List<List<String>> mergeAccounts (List<List<String>> accounts)	{
		boolean foundAtleastOneMerge = false;
		do {
			foundAtleastOneMerge = false;
			for (int i = 0; i < accounts.size() - 1; i++)	{
				List<String> ai = accounts.get(i);
				for (int j = i+1; j < accounts.size(); j++)	{
					List<String> aj = accounts.get(j);
					if (areSameAccounts(ai, aj)) {
						for (int k = 1; k < aj.size(); k++) ai.add(aj.get(k));
						accounts.remove(aj);
						foundAtleastOneMerge = true;
					}
				}
			}
			for (List<String> ai : accounts)	{
				String name = ai.remove(0);
				Set<String> emails = new TreeSet<String>();
				emails.addAll(ai);
				ai.clear();
				ai.add(name);
				ai.addAll(emails);
			}
		} while (foundAtleastOneMerge);
		return accounts;
	}
	
	private static boolean areSameAccounts (List<String> ai, List<String> aj)	{
		if (ai == null || aj == null) return false;
		for (int i = 1; i < ai.size(); i++)	{
			String e1 = ai.get(i);
			for (int j = 1; j < aj.size(); j++)	{
				String e2 = aj.get(j);
				if (e1.equals(e2))
					return true;
			}
		}
		return false;
	}
	
	private static void showAccounts(String msg, List<List<String>> accounts)	{
		System.out.println(msg);
		System.out.println("===================================================================");
		for (List<String> a : accounts)	{	
			showAccount("", a);
		}
	}
	
	private static void showAccount(String msg, List<String> a) {
		System.out.println(msg);
		System.out.println(a.get(0));
		for (int i = 1; i < a.size(); i++)
			System.out.println("    "+a.get(i));
	}
}
