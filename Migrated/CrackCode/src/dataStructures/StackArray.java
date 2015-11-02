package dataStructures;

import java.util.Arrays;

public class StackArray<T> implements StackInterface<T> {

	private T[] stack;
	private int size;

	@SuppressWarnings("unchecked")
	public StackArray(int capacity) {
		this.stack = (T[]) new Object[capacity];
		this.size = 0;
	}

	@Override
	public void push(T item) {
		if (size >= stack.length)
			// Repeated doubling.
			stack = Arrays.copyOf(stack, 2 * stack.length);
		stack[size++] = item;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;

		// Loitering Problem & avoid it to allow the garbage collection to
		// reclaim the memory of that position.
		T data = stack[--size];
		stack[size] = null;
		return data;
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
		StackInterface<Integer> si = new StackArray<Integer>(5);
		for (int i = 0; i < 10; i++) {
			si.push(i);
		}

		int cnt = 0;
		while (!si.isEmpty() && cnt++ < 100) {
			int v = si.pop();
			System.out.println(v);
			for (int i = 0; i < 1; i++) {
				si.push(v + i);
			}
		}
	}

}
