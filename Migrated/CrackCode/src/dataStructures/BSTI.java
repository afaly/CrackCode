package dataStructures;


public interface BSTI<Key extends Comparable<Key>, Value> {

	public void put(Key key, Value value);

	public Value get(Key key);

	public int size();

	public void delete(Key key);

	public void deleteMin();

	public void deleteMax();

	public Value min();

	public Value max();

	public int rank(Key key);

	public Value ceil(Key key);

	public Value floor(Key key);

	public void inorder();

	public void postorder();

	public void preorder();

	public void setVisiter(VisitNode<Key, Value> visiter);
	

}
