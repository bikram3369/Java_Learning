public class Stack {

    // Node class (same idea as LinkedList)
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    // ===== PUSH =====
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // ===== POP =====
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    // ===== PEEK =====
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // ===== IS EMPTY =====
    public boolean isEmpty() {
        return top == null;
    }

    // ===== SIZE =====
    public int size() {
        return size;
    }

    // ===== PRINT =====
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        Stack stack = new Stack();

        // PUSH
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("After push:");
        stack.printStack();

        // PEEK
        System.out.println("\nTop element: " + stack.peek());

        // POP
        System.out.println("\nPopped: " + stack.pop());
        stack.printStack();

        // SIZE
        System.out.println("\nSize: " + stack.size());

        // EMPTY
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}