package dataStructures;

public class StackLinkedList<T> implements StackInterface<T> {

	private Node<T> head;
	private int size;

	public StackLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public void push(T item) {
		Node<T> node = new Node<T>(item, head);
		head = node;
		size++;
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			Node<T> temp = head;
			head = head.getNext();
			size--;
			return temp.getItem();
		}
		return null;
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

		StackLinkedList<Integer> si = new StackLinkedList<Integer>();
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
