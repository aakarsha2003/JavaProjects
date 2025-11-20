package cdac;

import java.util.Scanner;

public class SecondLargest{
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n<2) {
			System.out.println(-1);
			return;
		}
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int x=sc.nextInt();
			if(x>first) {
				second=first;
				first=x;
			}
				else if(x>second&& x< first) {
			               second=x;
				}
			}
		System.out.println(second==Integer.MIN_VALUE ? -1:second);
		}
	}
	
