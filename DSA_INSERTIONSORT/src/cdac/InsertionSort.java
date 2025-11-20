package cdac;

import java.util.Scanner;

public class InsertionSort {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter no.of elements:");
	int n=sc.nextInt();
	System.out.println("enter the elements:");
	int[]arr=new int[n];
	for(int i=0;i<n;i++) {
		arr[i]=sc.nextInt();
		
	}
	for(int i=1;i<n;i++) {
		int key=arr[i];
		int j=i-1;
		while(j>0&&arr[j]>key) {
			arr[j+1]=arr[j];
			j--;
			
		}
		arr[j+1]=key;
	}
	System.out.println("sorted array:");
	for(int x:arr) {
		System.out.println(x+"");
	}
}	
	}