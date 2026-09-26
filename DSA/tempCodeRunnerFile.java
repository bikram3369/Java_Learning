import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/** A generic one-dimensional singly linked list. */
public class Linked_list_1D<T> implements Iterable<T> {
	private static final class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public boolean isEmpty() { return size == 0; }
	public int size() { return size; }
	public T peekFirst() { return getFirst(); }
	public T peekLast() { return getLast(); }

	public void add(T value) { addLast(value); }

	public void addFirst(T value) {
		Node<T> node = new Node<>(value);
		node.next = head;
		head = node;
		if (tail == null) tail = node;
		size++;
	}

	public void addLast(T value) {
		Node<T> node = new Node<>(value);
		if (tail == null) head = tail = node;
		else { tail.next = node; tail = node; }
		size++;
	}

	public void add(int index, T value) {
		checkPositionIndex(index);
		if (index == 0) { addFirst(value); return; }
		if (index == size) { addLast(value); return; }
		Node<T> previous = nodeAt(index - 1);
		Node<T> node = new Node<>(value);
		node.next = previous.next;
		previous.next = node;
		size++;
	}

	public boolean offer(T value) { addLast(value); return true; }
	public boolean offerFirst(T value) { addFirst(value); return true; }
	public boolean offerLast(T value) { addLast(value); return true; }

	public T getFirst() {
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		return head.data;
	}

	public T getLast() {
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		return tail.data;
	}

	public T get(int index) { return nodeAt(index).data; }

	public T set(int index, T value) {
		Node<T> node = nodeAt(index);
		T old = node.data;
		node.data = value;
		return old;
	}

	public T remove() { return removeFirst(); }

	public T removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		T value = head.data;
		head = head.next;
		if (--size == 0) tail = null;
		return value;
	}

	public T removeLast() {
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		if (size == 1) return removeFirst();
		Node<T> previous = nodeAt(size - 2);
		T value = tail.data;
		previous.next = null;
		tail = previous;
		size--;
		return value;
	}

	public T remove(int index) {
		checkElementIndex(index);
		if (index == 0) return removeFirst();
		if (index == size - 1) return removeLast();
		Node<T> previous = nodeAt(index - 1);
		T value = previous.next.data;
		previous.next = previous.next.next;
		size--;
		return value;
	}

	public boolean removeValue(T value) {
		int index = indexOf(value);
		if (index < 0) return false;
		remove(index);
		return true;
	}

	public boolean contains(T value) { return indexOf(value) >= 0; }

	public int indexOf(T value) {
		int index = 0;
		for (T item : this) {
			if (Objects.equals(item, value)) return index;
			index++;
		}
		return -1;
	}

	public int lastIndexOf(T value) {
		int result = -1, index = 0;
		for (T item : this) {
			if (Objects.equals(item, value)) result = index;
			index++;
		}
		return result;
	}

	public void reverse() {
		Node<T> previous = null, current = head;
		tail = head;
		while (current != null) {
			Node<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	public void clear() { head = tail = null; size = 0; }

	public Object[] toArray() {
		Object[] result = new Object[size];
		int index = 0;
		for (T value : this) result[index++] = value;
		return result;
	}

	public void sort(java.util.Comparator<? super T> comparator) {
		Object[] values = toArray();
		java.util.Arrays.sort(values, (a, b) -> comparator.compare((T) a, (T) b));
		clear();
		for (Object value : values) addLast((T) value);
	}

	private Node<T> nodeAt(int index) {
		checkElementIndex(index);
		Node<T> node = head;
		for (int i = 0; i < index; i++) node = node.next;
		return node;
	}

	private void checkElementIndex(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
	}

	private void checkPositionIndex(int index) {
		if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> current = head;
			public boolean hasNext() { return current != null; }
			public T next() {
				if (!hasNext()) throw new NoSuchElementException();
				T value = current.data;
				current = current.next;
				return value;
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (T value : this) {
			if (result.length() > 1) result.append(", ");
			result.append(value);
		}
		return result.append(']').toString();
	}
}

