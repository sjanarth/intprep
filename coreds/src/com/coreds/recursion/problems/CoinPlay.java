package com.coreds.recursion.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Consider a row of n coins of values v1 . . . vn. 
 * We play a game against an opponent by alternating turns. 
 * In each turn, a player selects either the first or last coin 
 * from the row, removes it from the row permanently, and receives 
 * the value of the coin. Determine the maximum possible amount of 
 * money one can definitely win if one moves first.
 *
 * Input Format:
 * 		You will be given an array of integers, v
 * Output Format:
 * 		Return an integer denoting the maximum possible amount of sum that can be accumulated.
 * 
 * Example:
 *  
 * 	v = {8,15,3,7}, o/p=22
 * 
 * 	Player 1 start by picking coin of amount 8. 
 * 	Remaining v = [15, 3, 7].
 * 	Opponent will have two choices, either pick coin of value 15 or 7.
 * 	Opponent will always pick 15 (to maximize his/her own amount).
 * 	Remaining v = [3, 7].
 * 	Player 1 will have two choices, either pick coin of value 3 or 7.
 * 	Player 1 will always pick 7 (to maximize his/her own amount).
 * 	Hence in this case, player 1 can get maximum amount 8 + 7 = 15.
 * 	(This is greedy strategy i.e. pick the highest at every step.)
 * 
 * 	Player 1 start by picking coin of amount 7.
 * 	Remaining v = [8, 15, 3].
 * 	Opponent will have two choices, either pick coin of value 8 or 3.
 * 	Opponent will pick 8 (to maximize his/her own amount). 
 * 	Remaining v = [15, 3].
 * 	Player 1 will have two choices, either pick coin of value 15 or 3.
 * 	Player 1 will always pick 15 (to maximize his/her own amount).
 * 	Hence in this case, player 1 can get maximum amount 7 + 15 = 22.
 * 
 * 	Given these two strategies, we want 22 as the answer, and not 15.
 * 
 */

public class CoinPlay 
{
	public static void main (String[] args) {
		coinPlay (new int[] {8,15,3,7});
	}
	
	protected static void coinPlay (int[] values) {
		int maxVal = coinPlay (values, 0, values.length-1);
		System.out.println("Maximum coin play for "+toString(values)+" = "+maxVal);
		int maxVal2 = coinPlayWithMemo (values, 0, values.length-1, new HashMap<String,Integer>());
		System.out.println("Maximum coin play for (with memo) "+toString(values)+" = "+maxVal2);
	}
	
	private static int coinPlay (int[] values, int i, int j) {
		if (i > values.length-1 || j < 0) return 0;
		if (i == j) return values[i];
		if ((i+1) == j) return Math.max(values[i], values[j]);

		// this is the greedy solution which is not optimal
		// return Math.max(coinPlay(values, i+1, j),coinPlay(values, i, j-1));
		
		/*
		 * One must pick a coin thats both 
		 * 		a local maximum AND 
		 * 		leaves the opponent with smaller choices
		 * One chooses the ith coin with value Vi: 
		 * 		The opponent either chooses (i+1)th coin or jth coin. 
		 * 		The opponent intends to choose the coin which leaves the user with minimum value.
		 * 		i.e. The user can collect the value Vi + min( F(i+2,j), F(i+1,j-1) )
		 * One chooses the jth coin with value Vj: 
		 * 		The opponent either chooses ith coin or (j-1)th coin. 
		 * 		The opponent intends to choose the coin which leaves the user with minimum value.
		 * 		i.e. The user can collect the value Vj + min( F(i+1,j-1), F(i,j-2) )
		 */
		
		return Math.max(values[i] + Math.min(
										coinPlay(values, i+2, j), 
										coinPlay (values, i+1, j-1)), 
						values[j] + Math.min(
										coinPlay(values, i+1, j-1), 
										coinPlay (values, i, j-2))
						);
	}
	
	private static int coinPlayWithMemo (int[] values, int i, int j, Map<String,Integer> memo) {
		String key = makeKey(i, j);
		if (memo.containsKey(key)) return memo.get(key);
		int maxVal = coinPlay (values, i, j);
		memo.put(key,  maxVal);
		return maxVal;
	}
	
	private static String makeKey (int i, int j)	{
		StringBuilder sb = new StringBuilder();
		sb.append(i); sb.append(","); sb.append(j);
		return sb.toString();
	}

	protected static String toString (int[] arr) {
		return Arrays.toString(arr).
					replaceAll("\\[", "\\{").
					replaceAll("\\]", "\\}").
					replaceAll(" ", "");
	}
}	
