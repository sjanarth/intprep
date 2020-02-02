package com.intprep.adhoc;

public class MinRemoveToMakeValid 
{
	public static void main (String[] args)	{
		minRemoveToMakeValid ("lee(t(c)o)de)");
		minRemoveToMakeValid ("a)b(c)d");
		minRemoveToMakeValid("))((");
		minRemoveToMakeValid("(a(b(c)d)");
	}
		
    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++)	{
        	char ch = s.charAt(i);
        	if (ch == '(')	{
        		open++;
        	} else if (ch == ')')	{
        		if (open == 0) continue;
        		open--;
        	}
        	sb.append(ch);
        }
        StringBuilder sb2 = new StringBuilder();
        int close = 0;
        for (int i = sb.toString().length()-1; i >= 0; i--) {
        	char ch = sb.toString().charAt(i);
        	if (ch == ')')	{
        		close++;
        	} else if (ch == '(')	{
        		if (close == 0) continue;
        		close--;
        	}
        	sb2.append(ch);
        }
        System.out.println("minRemoveToMakeValid{ "+s+" } = { "+sb2.reverse().toString()+" }");
        return sb2.reverse().toString();
    }
}
