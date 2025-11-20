package cdac;

import java.util.Scanner;

public class Factorial {
	public static int iterative(int n) {
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact*=1;
		}
		return fact;
	}
	 public static int recursive(int n) {
		 if(n==0 || n==1)
			 return 1;
		 else 
			 return n*recursive(n-1);
	 }
	 public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=sc.nextInt();
		System.out.println("factorial of number(iterative:"+iterative(num));
		System.out.println("factorial of number(recursive:"+recursive(num));
	 }

}
