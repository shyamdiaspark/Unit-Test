package com.test.basic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
public class SampleTest {

@BeforeClass
public static void init()
{
System.out.println("Inside Before");
}
	
	@Test
	public void testFactorial() {
		
		System.out.println("Inside test");

		Sample sample = new Sample();
		int fact = sample.factorial(5);
		
		// verify information
		assertNotNull(fact);
		assertEquals(120, fact);
		
	}
	
	
	@Test
	public void testFactorial1() {
		
		System.out.println("Inside test1");

		Sample sample = new Sample();
		int fact = sample.factorial(5);
		
		// verify information
		assertNotNull(fact);
		assertEquals(120, fact);
		
	}
	
	
	@Test
	public void testFactorial2() {
		
		System.out.println("Inside test2");

		Sample sample = new Sample();
		int fact = sample.factorial(5);
		
		// verify information
		assertNotNull(fact);
		assertEquals(120, fact);
		
	}
	
	/*@Ignore
	@Test
	public void test() {


		int a[]={1,2};
		int b[]={1,2};
		
		// verify information
		assertEquals(a, b);
		fail("falied..............");
	}
*/	
	
}
