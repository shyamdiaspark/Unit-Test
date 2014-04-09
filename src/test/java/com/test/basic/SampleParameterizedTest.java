package com.test.basic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SampleParameterizedTest {

	int inputNumber;
	int expectedResult;
	Sample sample;

	@Before
	public void initialize() {
		sample = new Sample();
	}

	public SampleParameterizedTest(int inputNumber, int expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {

		{ 1, 1 }, { 2, 2 }, { 3, 6 }, { 4, 24 }, { 5, 120 } });
	}

	@Test
	public void testFactorial() {

		int fact = sample.factorial(inputNumber);

		// verify information
		assertEquals(expectedResult, fact);
	}

}
