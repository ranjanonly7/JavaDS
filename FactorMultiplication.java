package com.practice.li;

/*

Write a program that takes an integer and prints out all 
ways to multiply smaller integers that equal the original number, 
without repeating sets of factors. In other words, if your output 
contains 4 * 3, you should not print out 3 * 4 again as that would 
be a repeating set. Note that this is not asking for prime 
factorization only. Also, you can assume that the input integers 
are reasonable in size; correctness is more important than efficiency. 
 */
public class FactorMultiplication {
	
	public static void PrintFactors(int value) throws Exception{
		if(value<1){
			throw new Exception("value cannot be 0");
		}
		
		for(int i=1; value>=i*i; i++){
			int j=0;
			if((value)%i==0){
				j=value/i;
			System.out.println("");
				
				System.out.printf("%d*%d",i,j);
//				System.out.println(j);
				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PrintFactors(12);

	}

}
