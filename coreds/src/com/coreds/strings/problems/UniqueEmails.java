package com.coreds.strings.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * 
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * 
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * 
 * If you add periods ('.') between some characters in the local name part of an email address, 
 * mail sent there will be forwarded to the same address without dots in the local name.  
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  
 * (Note that this rule does not apply for domain names.)
 * 
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. 
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  
 * (Again, this rule does not apply for domain names.)
 * 
 * It is possible to use both of these rules at the same time.
 * 
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
 * 
 * Example 1:
 * 
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2 
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * 
 */

public class UniqueEmails 
{
	public static void main (String[] args) {
		String[] emails = getEmails();
		showArray("Input", emails);
		String[] newEmails = getUniqueEmails (emails);
		showArray("Output", newEmails);
	}
	
    public static String[] getEmails() {
       return new String[] {
    		   "test.email+alex@leetcode.com", "test.email.leet+alex@code.com"
       };
    }	
    
    public static String[] getUniqueEmails(String[] emails) {
    	Set<String> uniq = new HashSet<>();
    	for (String e  : emails)	{
    		String ue = format(e); 
    		uniq.add(ue);
    	}
    	return uniq.toArray(new String[0]);
    }	
    
    private static String format (String email)	{
    	int ind = email.indexOf('@');
    	String domain = email.substring(ind);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < ind; i++)	{
    		char ch = email.charAt(i);
    		if (ch == '.') continue;
    		if (ch == '+') break;
    		sb.append(ch);
    	}
    	sb.append(domain);
    	return sb.toString();
    }

    private static void showArray(String msg, String[] arr)	{
    	System.out.println(msg);
    	for (String s : arr)
    		System.out.println("    "+s);
    }
}
