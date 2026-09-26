import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // ===== INSERT =====
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent) > heap.get(index)) {
                swap(parent, index);
                index = parent;
            } else break;
        }
    }

    // ===== DELETE (Extract Min) =====
    public int extractMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    // ===== PEEK =====
    public int peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap.get(0);
    }

    // ===== SIZE =====
    public int size() {
        return heap.size();
    }

    // ===== EMPTY =====
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // ===== SWAP =====
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ===== PRINT =====
    public void printHeap() {
        System.out.println(heap);
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        MinHeap heap = new MinHeap();

        heap.insert(30);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        System.out.println("Heap:");
        heap.printHeap();

        System.out.println("\nMin: " + heap.peek());

        System.out.println("\nExtracted: " + heap.extractMin());
        heap.printHeap();

        System.out.println("\nSize: " + heap.size());
    }
}