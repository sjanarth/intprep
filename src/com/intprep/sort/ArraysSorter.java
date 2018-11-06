package com.intprep.sort;
import java.util.Arrays;

public class ArraysSorter extends AbstractSorter {
	@Override
	protected int[] sort(int[] input) {
		Arrays.sort(input);
		return input;
	}
}
