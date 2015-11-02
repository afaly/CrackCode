package dataStructures;

/****************************************************************************
 *       This demonstrates binary heap operations along with the heapSort.
 *
 *****************************************************************************/
import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<T> {
	private static final int CAPACITY = 2;

	private int size; // Number of elements in heap
	private T[] heap; // The heap array
	private Comparator<T> cmp;

	public Heap() {
		this.size = 0;
		this.heap = (T[]) new Object[CAPACITY];
		this.cmp = null;
	}

	public Heap(Comparator<T> cmp) {
		this.size = 0;
		this.heap = (T[]) new Object[CAPACITY];
		this.cmp = cmp;
	}

	/**
	 * Construct the binary heap given an array of items.
	 */
	public Heap(T[] array, Comparator<T> cmp) {
		this.size = array.length;
		this.heap = (T[]) new Object[array.length + 1];
		this.cmp = cmp;
		System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0
		buildHeap();
	}

	/**
	 * runs at O(size)
	 */
	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		T tmp = heap[k];
		int child;

		for (; 2 * k <= size; k = child) {
			child = 2 * k;

			if (child != size && cmp.compare(heap[child], heap[child + 1]) > 0)
				child++;

			if (cmp.compare(tmp, heap[child]) > 0)
				heap[k] = heap[child];
			else
				break;
		}
		heap[k] = tmp;
	}

	/**
	 * Sorts a given array of items.
	 */
	public void heapSort(T[] array) {
		size = array.length;
		heap = (T[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		buildHeap();

		for (int i = size; i > 0; i--) {
			T tmp = heap[i]; // move top item to the end of the heap array
			heap[i] = heap[1];
			heap[1] = tmp;
			size--;
			percolatingDown(1);
		}
		for (int k = 0; k < heap.length - 1; k++)
			array[k] = heap[heap.length - 1 - k];
	}

	/**
	 * Deletes the top item
	 */
	public T get() throws RuntimeException {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}

	/**
	 * Inserts a new item
	 */
	public void put(T x) {
		if (size == heap.length - 1)
			doubleSize();
		// Insert a new item to the end of the array
		int pos = ++size;
		// Percolate up
		for (; pos > 1 && cmp.compare(x, heap[pos / 2]) < 0; pos = pos / 2)
			heap[pos] = heap[pos / 2];
		heap[pos] = x;
	}

	private void doubleSize() {
		T[] old = heap;
		heap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public int size() {
		return size;
	}

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
	}
}