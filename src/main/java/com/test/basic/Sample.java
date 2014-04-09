package com.test.basic;

public class Sample {

	public int factorial(int n){
		 
		if(n==1)
			return 1;
		
		n=n*factorial(--n);		
		return n;
	}
	
	public static void main(String args[]){
		
		Sample sample=new Sample();
		System.out.println(sample.factorial(5));
	}
}
