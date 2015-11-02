package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class NStacks<T> {

	private T[] cont;
	private int stackSize, numOfStacks;
	private int[] pointers;

	@SuppressWarnings("unchecked")
	public NStacks(int numOfStacks, int stackSize) {
		this.numOfStacks = numOfStacks;
		this.stackSize = stackSize;
		this.pointers = new int[numOfStacks];
		this.cont = (T[]) new Object[numOfStacks * stackSize];
	}

	public T pop(int stackNum) {
		if (stackNum < 0 || stackNum >= numOfStacks) return null;
		int idx = getAbsoluteIdx(stackNum) - 1;
		if (idx < 0) return null;
		pointers[stackNum]--;
		return cont[idx];
	}

	public boolean push(T data, int stackNum) {
		if (stackNum < 0 || stackNum >= numOfStacks) return false;
		if (pointers[stackNum] >= stackSize) return false;
		int idx = getAbsoluteIdx(stackNum);
		cont[idx] = data;
		pointers[stackNum]++;
		return true;
	}

	private int getAbsoluteIdx(int stackNum) {
		return stackNum * stackSize + pointers[stackNum];
	}
}

class NStacksDynamic<T> {
	private T[] cont;
	private int stackSize, numOfStacks;
	private int[] pointers;

	@SuppressWarnings("unchecked")
	public NStacksDynamic(int numOfStacks, int initialStackSize) {
		this.numOfStacks = numOfStacks;
		this.stackSize = initialStackSize;
		this.pointers = new int[numOfStacks];
		for (int i = 0; i < numOfStacks; i++)
			pointers[i] = i;
		this.cont = (T[]) new Object[numOfStacks * stackSize];
	}

	public T pop(int stackNum) {
		if (stackNum < 0 || stackNum >= numOfStacks) return null;
		if (pointers[stackNum] - numOfStacks < 0) return null;
		int idx = pointers[stackNum] -= numOfStacks;
		return cont[idx];
	}

	public boolean push(T data, int stackNum) {
		if (stackNum < 0 || stackNum >= numOfStacks) return false;
		if (pointers[stackNum] >= stackSize) extend();
		cont[pointers[stackNum]] = data;
		pointers[stackNum] += numOfStacks;
		return true;
	}

	private void extend() {
		this.cont = Arrays.copyOf(cont, cont.length * 2);
		this.stackSize *= 2;
	}
}

class MinStack<T extends Comparable<T>> {
	private T[] stack;
	private int stackSize;
	private int ptr;
	private int minPtr;
	private Stack<Integer> mins;

	@SuppressWarnings("unchecked")
	public MinStack(int initialStackSize) {
		this.stackSize = initialStackSize;
		this.stack = (T[]) new Comparable[initialStackSize];
		this.ptr = 0;
		this.minPtr = -1;
		this.mins = new Stack<Integer>();
	}

	public T pop() {
		if (ptr <= 0) return null;
		if (mins.peek() == ptr - 1) mins.pop();
		return stack[--ptr];
	}

	public boolean push(T data) {
		if (ptr >= stackSize) extend();
		if (minPtr >= 0) {
			if (data.compareTo(stack[minPtr]) < 0) {
				minPtr = ptr;
				mins.push(ptr);
			}
		} else {
			minPtr = ptr;
			mins.push(ptr);
		}
		stack[ptr++] = data;
		return true;
	}

	public T min() {
		if (minPtr <= -1 || mins.isEmpty()) return null;
		return stack[mins.peek()];
	}

	public void extend() {
		this.stack = Arrays.copyOf(stack, stackSize *= 2);
	}

	public boolean isEmpty() {
		return ptr == 0;
	}
}

class SetOfStacks<T> {
	private ArrayList<T[]> stacks;
	private int stackSize;
	private int ptr;
	private T[] stack;
	private int idx;

	@SuppressWarnings("unchecked")
	public SetOfStacks(int stackSize) {
		this.stackSize = stackSize;
		this.stacks = new ArrayList<T[]>();
		this.ptr = 0;
		this.idx = 0;
		this.stack = (T[]) new Object[stackSize];
	}

	public T pop() {
		if (ptr == 0) {
			if (idx == 0) return null;
			stack = stacks.get(--idx);
			ptr = stackSize;
			return pop();
		}
		return stack[--ptr];
	}

	public void push(T data) {
		if (ptr == stackSize) extend();
		stack[ptr++] = data;
	}

	@SuppressWarnings("unchecked")
	private void extend() {
		stacks.add(stack);
		stack = (T[]) new Object[stackSize];
		idx++;
		ptr = 0;
	}

	public boolean isEmpty() {
		return ptr == 0 && idx == 0;
	}
}

class QueueStacks<T extends Comparable<T>> {
	private Stack<T> s1, s2;
	private boolean push = true;

	public QueueStacks() {
		this.s1 = new Stack<T>();
		this.s2 = new Stack<T>();
	}

	public void enque(T data) {
		if (!push) Swap(s2, s1);
		s1.push(data);
		push = true;
	}

	public T deque() {
		if (push) Swap(s1, s2);
		push = false;
		if (s2.isEmpty()) return null;
		return s2.pop();
	}

	public int Size() {
		return Math.max(s1.size(), s2.size());
	}

	public boolean isEmpty() {
		return Size() == 0;
	}

	private void Swap(Stack<T> a, Stack<T> b) {
		while (!a.isEmpty())
			b.push(a.pop());
	}
}

public class CH3 {

	public static void main(String[] args) {
		// nStacksDynamic<Integer> s = new nStacksDynamic<>(3, 100);
		// for (int j = 0; j < 3; j++)
		// for (int i = 0; i < 200; i++)
		// s.push(i * (j + 1), j);
		//
		// for (int j = 0; j < 3; j++)
		// for (int i = 0; i < 10; i++)
		// System.out.println("S[" + j + "] : " + s.pop(j));

		QueueStacks<Integer> q = new QueueStacks<>();

		// SetOfStacks<Integer> ms = new SetOfStacks<>(10);
		for (int i = 0; i <= 10; i++) {
			q.enque(i);
		}

		// Random r = new Random();
		while (!q.isEmpty()) {
			System.out.println(q.deque());
		}
	}
}
