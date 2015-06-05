package com.xebia.training.refactor.template;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void shouldSortArrayOfIntegers() {
		Integer[] list = new Integer[] { 2, 3, 4, 1, 0 };
		new BubbleSort().sort(list);
		assertArrayEquals(new Integer[]{0,1,2,3,4},list);

	}

}
