public class Queue {

    // Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // ===== ENQUEUE (Add) =====
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {  // empty queue
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // ===== DEQUEUE (Remove) =====
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) { // queue becomes empty
            rear = null;
        }

        size--;
        return value;
    }

    // ===== PEEK =====
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // ===== IS EMPTY =====
    public boolean isEmpty() {
        return front == null;
    }

    // ===== SIZE =====
    public int size() {
        return size;
    }

    // ===== PRINT =====
    public void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        Queue q = new Queue();

        // ENQUEUE
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("After enqueue:");
        q.printQueue();

        // PEEK
        System.out.println("\nFront element: " + q.peek());

        // DEQUEUE
        System.out.println("\nDequeued: " + q.dequeue());
        q.printQueue();

        // SIZE
        System.out.println("\nSize: " + q.size());

        // EMPTY
        System.out.println("Is Empty: " + q.isEmpty());
    }
}