package cdac;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class DeleteSmallernodes {
private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    
    public static Node deletesmallernodes(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        head = reverseList(head);
        
        Node current = head;
        Node prev = null;
        
        int maxSofar = Integer.MIN_VALUE; 
        
        while (current != null) {
            
            if (current.data < maxSofar) {
                if (prev != null) {
                    prev.next = current.next; 
                }
                current = current.next; 
                
            } else {
                maxSofar = current.data;
                prev = current;
                current = current.next;
            }
        }
        
        head = reverseList(head);
        return head; 
    }
    private static Node createLinkedList(int[] arr) {
        if (arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head; 
    }
    private static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" "); 
            }
            current = current.next;
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int N = sc.nextInt();
        
        int[] inputArr = new int[N];
        for (int i = 0; i < N; i++) {
            if (sc.hasNextInt()) {
                inputArr[i] = sc.nextInt();
            }
        }
        sc.close();
        
        Node head = createLinkedList(inputArr);
        Node modifiedHead = deletesmallernodes(head);
        printLinkedList(modifiedHead);
    }
}