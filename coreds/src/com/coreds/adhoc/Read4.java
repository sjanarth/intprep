package com.coreds.adhoc;

public class Read4 {

	public static void main(String[] args) {
		char[] buf = new char[20];
		read(buf, 2);
		System.out.println("Case-1 = "+String.copyValueOf(buf));
		buf = new char[20000];
		read(buf, 20000);
		System.out.println("Case-2 = "+String.copyValueOf(buf));
	}
	
	private static int read (char[] buf, int n) {
		int bufptr = 0;		// tracks the next free index within buf
		// do we have left over from prior calls?
		if (buf4cnt > 0)	{
			while (bufptr < n && buf4cnt > 0)	{
				buf[bufptr++] = buf4[buf4ptr++];
				buf4cnt--;
			}
			if (buf4cnt == 0) buf4ptr = 0;
		}
		while (bufptr < n)	{
			buf4cnt = read4(buf4);
			if (buf4cnt == 0) break;
			while (bufptr < n && buf4cnt > 0)	{
				buf[bufptr++] = buf4[buf4ptr++];
				buf4cnt--;
			}
			if (buf4cnt == 0) buf4ptr = 0;
		}
		return bufptr;
	}
	
	private static int buf4ptr = 0;
	private static int buf4cnt = 0;
	private static char[] buf4 = new char[4];
	
	private static int read4 (char[] buf)	{
		//System.out.println("-> read4, curr="+curr);
		int i = 0;
		while (i < 4 && curr+i < FILE.length)	{
			buf[i] = FILE[curr+i];
			i++;
		}
		curr = curr + i;
		System.out.println("<- read4, buf="+String.valueOf(buf)+", i="+i+", curr="+curr);
		return i;
	}
	
	private static int curr = 0;
	private static char[] FILE = "abc".toCharArray();/*
			("Opera refers to a dramatic art form, originating in Europe, in which the "  
			+ "emotional content is conveyed to the audience as much through music, both "
			+ "vocal and instrumental, as it is through the lyrics. By contrast, in musical "
			+ "theater an actor's dramatic performance is primary, and the music plays a "
			+ "lesser role. The drama in opera is presented using the primary elements of "
			+ "theater such as scenery, costumes, and acting. However, the words of the opera, "
			+ "or libretto, are sung rather than spoken. The singers are accompanied by a "
			+ "musical ensemble ranging from a small instrumental ensemble to a full symphonic orchestra.").toCharArray();*/
}
