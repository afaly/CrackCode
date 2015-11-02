package dataStructures;

public interface StackInterface<T> {

	public void push(T item);

	public T pop();

	public boolean isEmpty();

	public int size();

}
