public class DoublyLinkedList {

    // Node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // ===== ADD =====

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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

        if (index == size) {
            addLast(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;

        size++;
    }

    // ===== DELETE =====

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteLast() {
        if (tail == null) {
            System.out.println("List empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
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

        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
    }

    public void deleteValue(int key) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp == head) {
            deleteFirst();
        } else if (temp == tail) {
            deleteLast();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
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
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // ===== PRINT =====

    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // ===== SIZE =====

    public int size() {
        return size;
    }

    // ===== MAIN =====

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        // ADD
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.addLast(30);
        list.addAt(2, 15);

        System.out.println("Forward:");
        list.printForward();

        System.out.println("Backward:");
        list.printBackward();

        // DELETE
        list.deleteFirst();
        list.deleteLast();
        list.deleteAt(1);

        System.out.println("\nAfter deletions:");
        list.printForward();

        // SEARCH
        System.out.println("\nSearch 20: " + list.search(20));

        // GET / SET
        System.out.println("Element at index 1: " + list.get(1));
        list.set(1, 99);
        list.printForward();

        // REVERSE
        list.reverse();
        System.out.println("\nAfter reverse:");
        list.printForward();

        // SIZE
        System.out.println("\nSize: " + list.size());
    }
}