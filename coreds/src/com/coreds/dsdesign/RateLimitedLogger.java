package com.coreds.dsdesign;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/65/design-4/3093/ 
 * 
 * Design a logger system that receive stream of messages along with its timestamps, 
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * Example:
 * 
 * Logger logger = new Logger();
 * 
 * // logging string "foo" at timestamp 
 * logger.shouldPrintMessage(1, "foo"); returns true; 
 * 
 * // logging string "bar" at timestamp 
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * 
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * 
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * 
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * 
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class RateLimitedLogger 
{
	public static void main(String[] args) {
		RateLimitedLogger logger = new RateLimitedLogger();
		// logging string "foo" at timestamp 
		logger.shouldPrintMessage(1, "foo"); 
		// logging string "bar" at timestamp 
		logger.shouldPrintMessage(2,"bar"); 
		// logging string "foo" at timestamp 3
		logger.shouldPrintMessage(3,"foo"); 
		// logging string "bar" at timestamp 8
		logger.shouldPrintMessage(8,"bar"); 
		// logging string "foo" at timestamp 10
		logger.shouldPrintMessage(10,"foo");
		// logging string "foo" at timestamp 11
		logger.shouldPrintMessage(11,"foo");
	}
	
    /** Initialize your data structure here. */
    public RateLimitedLogger() {
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	sop("shouldPrintMessage("+timestamp+","+message+") = ");
    	boolean retVal = false;
    	if (msgs.containsKey(message))	{
    		int lastTs = msgs.get(message);
    		if (timestamp - lastTs >= 10)	{
    			msgs.put(message, timestamp);
    			retVal = true;
    		} else {
    			retVal = false;
    		}
    	} else {
    		msgs.put(message, timestamp);
    		retVal = true;
    	}
    	sop ("    msgs="+msgs.toString());
    	sop ("    "+retVal);
    	return retVal;
    }
    
    private void sop(String msg) {
    	System.out.println(msg);
    }
    
    Map<String, Integer> msgs = new HashMap<>();
}