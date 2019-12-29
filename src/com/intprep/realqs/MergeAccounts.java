package com.intprep.realqs;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

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

public class MergeAccounts 
{
	public static void main(String[] args) {
		List<String> accounts = buildSampleListOfAccounts();
		showAccounts("Initial", accounts);
		List<String> merged = mergeAccounts(accounts);
		showAccounts("Merged", merged);
	}
	
	private static List<String> buildSampleListOfAccounts()	{
		List<String> accounts = new ArrayList<String>();
		accounts.add("Satish");
		accounts.add("sjanarth@gmail.com");
		accounts.add("satish.janarthanan@gmail.com");
		accounts.add("Viji");
		accounts.add("viji.venkatesan@gmail.com");
		accounts.add("mummy@mial.com");
		accounts.add("Somebody");
		accounts.add("sjanarth@gmail.com");
		accounts.add("someone@somewhere.com");
		return accounts;
	}
	
	private static void showAccounts(String msg, List<String> accounts)	{
		System.out.println(msg);
		System.out.println("===================================================================");
		for (String a : accounts)	
			if (a.contains("@")) 
				System.out.println("    "+a);
			else
				System.out.println(a);
			
	}
	
	private static List<String> mergeAccounts (List<String> input)	{
		List<Person> persons = convertToPersons(input);
		System.out.println("Found "+persons.size()+" persons");
		for (int i = 0; i < persons.size() - 1; i++)	{
			Person pi = persons.get(i);
			for (int j = i+1; j < persons.size(); j++) {
				Person pj = persons.get(j);
				if (pi.equals(pj)) {
					System.out.println("Merging "+pi.name+" with "+pj.name);
					pi.emails.addAll(pj.emails);
					persons.remove(j);
				}
			}
		}
		return convertToAccounts(persons);
	}
	
	private static class Person	
	{
		private String name = null;
		private Set<String> emails = new TreeSet<String>();
		public Person(List<String> account)	{ 
			name = account.get(0);
			for (int i = 1; i < account.size();i++)	{
				emails.add(account.get(i));
			}
		}
		public boolean equals (Person p2) {
			if (p2 == null) return false;
			if (emails.size() < p2.emails.size())	{
				for (String e : emails)	{
					if (p2.emails.contains(e))
						return true;
				}
			} else {
				for (String e : p2.emails)	{
					if (emails.contains(e))
						return true;
				}
			}
			return false;
		}
	}
	
	private static List<Person> convertToPersons (List<String> accounts)	{
		System.out.println("Found "+accounts.size()+" accounts");
		List<Person> persons = new ArrayList<Person>();
		List<String> account = new ArrayList<String>();
		for (String a : accounts)	{
			if (!a.contains("@"))	{
				if (!account.isEmpty()) {
					persons.add(new Person(account));
				}
				account.clear();
				account.add(a);
			}
			else {
				account.add(a);
			}
		}
		if (!account.isEmpty()) {
			persons.add(new Person(account));
		}
		return persons;
	}
	
	private static List<String> convertToAccounts (List<Person> persons)	{
		List<String> accounts = new ArrayList<String>();
		for (Person p  : persons)	{
			accounts.add(p.name);
			accounts.addAll(p.emails);
		}
		return accounts;
	}
}
