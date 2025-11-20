package cdac;

import java.util.Scanner;

public class classes{
     static class Node{
    	 int data;
    	 Node next;
		 public Node(int data) {
			this.data = data;
		 }
     }
     Node head;
     
     void createCircularLinkedList(int[] arr) {
    	 head = new Node(arr[0]);
    	 Node temp = head;
    	 for(int i=1;i<arr.length;i++) {
    		 temp.next = new Node(arr[i]);
    		 temp = temp.next;
    	 }
    	 temp.next = head;
     }
     
     void deleteNodeBefore(int pos) {
    	 if(head==null || head.next == head)
    		 return;
    	 Node temp = head;
    	 int count = 1;
    	 
    	 while(count<pos-2) {
    		 temp = temp.next;
    		 count++;
    	 }
    	 
    	 Node deleteNode = temp.next;
    	 temp.next = deleteNode.next;
    	 
    	 if(deleteNode == head)
    		 head = head.next;
     }
     
     void deleteNodeAfter(int pos) {
    	 if(head == null || head.next == head)
    		 return;
    	 Node temp = head;
    	 int count = 1;
    	 
    	 while(count<pos) {
    		 temp = temp.next;
    		 count++;
    	 }
    	 
    	 Node deleteNode = temp.next;
    	 temp.next = deleteNode.next;
    	 
    	 if(deleteNode == head)
    		 head = head.next;
     }
     
     void printList() {
    	 if(head == null)
    		 return;
    	 Node temp = head;
    	 do {
    		 System.out.println(temp.data+" ");
    		 temp = temp.next;
    	 }while(temp!=head);
    	 System.out.println();
     }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Number of nodes:");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the Nodes:");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the Position: ");
		int pos = sc.nextInt();
		
		classes c =new classes();
		c.createCircularLinkedList(arr);
		
		c.deleteNodeBefore(pos);
		c.printList();
		
		c.createCircularLinkedList(arr);
		c.deleteNodeAfter(pos);
		c.printList();
	}
}
