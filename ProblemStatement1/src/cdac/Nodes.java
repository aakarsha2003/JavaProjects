package cdac;

import java.util.Scanner;

class Nodes {
    int data;
    Nodes next;

    public Nodes(int data) {
        this.data = data;
        this.next = null;
    }
}
class DeleteSmallernodes {
private static Nodes reverseList(Nodes head) {
        Nodes prev = null;
        Nodes current = head;
        while (current != null) {
            Nodes nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static Nodes deletesmallernodes(Nodes head) {
        if (head == null || head.next == null) {
            return head;
        }
        head = reverseList(head);
        Nodes current = head;
        Nodes prev = null;
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
    private static Nodes createLinkedList(int[] arr) {
        if (arr.length == 0)
            return null;
        Nodes head = new Nodes(arr[0]);
        Nodes current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Nodes(arr[i]);
            current = current.next;
        }
        return head; 
    }
    private static void printLinkedList(Nodes head) {
        StringBuilder sb = new StringBuilder();
        Nodes current = head;
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
        
        Nodes head = createLinkedList(inputArr);
        Nodes modifiedHead = deletesmallernodes(head);
        printLinkedList(modifiedHead);
    }
}