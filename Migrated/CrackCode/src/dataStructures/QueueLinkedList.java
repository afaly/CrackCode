package dataStructures;

public class QueueLinkedList<T> implements QueueInterface<T> {

	private Node<T> head, tail;
	private int size;

	public QueueLinkedList() {
		this.tail = null;
		this.head = tail;
		this.size = 0;
	}

	@Override
	public void enqueue(T item) {
		Node<T> node = new Node<T>(item);
		if (tail != null)
			tail.setNext(node);
		else
			head = node;
		tail = node;
		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			return null;
		Node<T> temp = head;
		head = head.getNext();
		size--;
		if (isEmpty())
			tail = null;
		return temp.getItem();
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

		QueueInterface<Integer> si = new QueueLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			si.enqueue(i);
		}

		int cnt = 0;
		while (!si.isEmpty() && cnt++ < 100) {
			int v = si.dequeue();
			System.out.println(v);
			for (int i = 0; i < 3; i++) {
				si.enqueue(v + i);
			}
		}

	}

}
