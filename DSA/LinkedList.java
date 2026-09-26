public class LinkedList {

    // Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    // ===== ADD =====

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        size++;
    }

    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // ===== DELETE =====

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        size--;
    }

    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void deleteValue(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    // ===== SEARCH =====

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // ===== GET =====

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // ===== SET =====

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.data = value;
    }

    // ===== REVERSE =====

    public void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // ===== SIZE =====

    public int size() {
        return size;
    }

    // ===== PRINT =====

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ===== MAIN METHOD =====

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // ADD
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.addLast(30);
        list.addAt(2, 15);

        System.out.println("After adding:");
        list.printList();

        // DELETE
        list.deleteFirst();
        System.out.println("\nAfter deleteFirst:");
        list.printList();

        list.deleteLast();
        System.out.println("\nAfter deleteLast:");
        list.printList();

        list.deleteAt(1);
        System.out.println("\nAfter deleteAt(1):");
        list.printList();

        list.deleteValue(10);
        System.out.println("\nAfter deleteValue(10):");
        list.printList();

        // ADD AGAIN
        list.addLast(40);
        list.addLast(50);

        // SEARCH
        System.out.println("\nSearch 40: " + list.search(40));
        System.out.println("Search 99: " + list.search(99));

        // GET / SET
        System.out.println("\nElement at index 1: " + list.get(1));
        list.set(1, 99);
        System.out.println("After set:");
        list.printList();

        // REVERSE
        list.reverse();
        System.out.println("\nAfter reverse:");
        list.printList();

        // SIZE
        System.out.println("\nSize: " + list.size());
    }
}