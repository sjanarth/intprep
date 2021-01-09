package com.coreds.arrays;

public class RemoveValue extends AbstractArraysProblem 
{
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,2,3};
		printArray("Input", nums);
		int count = removeValue(nums, 3);
		printArray("Output", nums);
		System.out.println("Length of o/p array = "+count);
	}

    private static int removeValue(int[] input, int val) {
    	int pos = 0;
    	for (int i = 0; i < input.length; i++)
    		if (input[i] != val)
    			input[pos++] = input[i];
    	return pos;
    }
}
