package cdac;
public class StackArray {
    int arr[], top, capacity;
    public StackArray(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        arr[++top] = x;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return arr[top--];
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }
    private boolean isEmpty() {
        return top == -1;
    }
    private boolean isFull() {
        return top == capacity - 1;
    }
    public int size() {
        return top + 1;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackArray s = new StackArray(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        System.out.println("Top element is: " + s.peek());
        System.out.println("Popped element: " + s.pop());
        s.display();
        s.push(40);
        s.push(50);
        s.push(60);
        s.display();
    }
}