package problem2;

import java.util.Scanner;

public class circularlist {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    void createList(int[] arr) {
        Node temp = null;
        for (int val : arr) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                head.next = head;               
                temp = head;    
            } else {
                temp.next = newNode;
                newNode.next = head;  
                temp = newNode;
            }
        }
    }  
    void deleteBefore(int pos) {
        if (head == null || head.next == head)
            return;
        if (pos == 1) {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 3; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    void deleteAfter(int pos) {
        if (head == null || head.next == head)
            return;
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;  
    }

    void printList() {
        if (head == null)
            return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the numbers:");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int pos = sc.nextInt();

        circularlist list = new circularlist();
        list.createList(arr);

       
        list.deleteBefore(pos);
        list.printList();

        
        list = new circularlist();
        list.createList(arr);

      
        list.deleteAfter(pos);
        list.printList();
    }
}
