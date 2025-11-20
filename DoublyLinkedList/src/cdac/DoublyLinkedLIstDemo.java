package cdac;

import java.util.Scanner;

class DNode{
	int data;
	DNode prev;
	DNode next;
	
	public DNode(int data) {
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}
class DoublyLinkedList{
	DNode head;
	DNode tail;
	public void insert(int data) {
		DNode newNode=new DNode(data);
		if(head==null) {
			head=tail=newNode;
			return;
		}
		tail.next=newNode;
		newNode.prev=tail;
		tail=newNode;
	}
		public void displayForward() {
			DNode current=head;
			System.out.print("Forward:");
			while(current !=null) {
				System.out.println(current.data+"");
				current=current.next;
			}
			System.out.println();
			}
	}
		
public class DoublyLinkedListDemo{
	public static void main(String[]args) {
		DoublyLinkedList list=new DoublyLinkedList();
		Scanner sc=new Scanner(System.in);
		
	}
}
public class DoublyLinkedLIstDemo {

}
