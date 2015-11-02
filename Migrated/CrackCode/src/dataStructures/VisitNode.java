package dataStructures;

public interface VisitNode<Key extends Comparable<Key>, Value> {

	public void Visit(Key key, Value val);
}
