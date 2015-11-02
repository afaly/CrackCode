package dataStructures;

import java.util.Arrays;

public class QueueArray<T> implements QueueInterface<T> {

	private T[] queue;
	private int size;
	private int head, tail;

	@SuppressWarnings("unchecked")
	public QueueArray(int capacity) {
		if (capacity < 10)
			capacity = 10;
		this.queue = (T[]) new Object[capacity];
		this.size = 0;
		this.head = 0;
		this.tail = 0;
	}

	@Override
	public void enqueue(T item) {
		if (tail >= queue.length)
			queue = Arrays.copyOf(queue, queue.length * 2);
		queue[tail++] = item;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		if (isEmpty())
			return null;
		T temp = queue[head];
		queue[head++] = null;
		size--;
		if (size <= 0.25 * queue.length) {
			T[] t = (T[]) new Object[(queue.length + 1) / 2];
			int j = 0;
			for (int i = head; i < tail; i++) {
				t[j++] = queue[i];
			}
			head = 0;
			tail = size;
			queue = t;
		}

		return temp;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {

		QueueInterface<Integer> si = new QueueArray<Integer>(5);
		for (int i = 0; i < 100; i++) {
			si.enqueue(i);
		}

		int cnt = 0;
		while (!si.isEmpty() && cnt++ < 1000) {
			int v = si.dequeue();
			System.out.println(v);
			for (int i = 0; i < 3; i++) {
				si.enqueue(v + i);
			}
		}

	}

}
