package algorithms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map; // For HashMap
import java.util.NoSuchElementException;

public final class DirectedGraph<T> implements Iterable<T> {
	/*
	 * A map from nodes in the graph to sets of outgoing edges. Each set of
	 * edges is represented by a map from edges to doubles.
	 */
	private final Map<T, Map<T, Double>> mGraph = new HashMap<T, Map<T, Double>>();

	/**
	 * Adds a new node to the graph. If the node already exists, this function
	 * is a no-op.
	 *
	 * @param node
	 *            The node to add.
	 * @return Whether or not the node was added.
	 */
	public boolean addNode(T node) {
		/* If the node already exists, don't do anything. */
		if (mGraph.containsKey(node)) return false;

		/* Otherwise, add the node with an empty set of outgoing edges. */
		mGraph.put(node, new HashMap<T, Double>());
		return true;
	}

	/**
	 * Given a src node, dstination, and length, adds an arc from the src node
	 * to the dstination of the length. If an arc already existed, the length is
	 * updated to the specified value. If either endpoint does not exist in the
	 * graph, throws a NoSuchElementException.
	 *
	 * @param src
	 *            The src node.
	 * @param dst
	 *            The dstination node.
	 * @param length
	 *            The length of the edge.
	 * @throws NoSuchElementException
	 *             If either the src or dstination nodes do not exist.
	 */
	public void addEdge(T src, T dst, double length) {
		/* Confirm both endpoints exist. */
		if (!mGraph.containsKey(src) || !mGraph.containsKey(dst)) throw new NoSuchElementException(
				"Both nodes must be in the graph.");

		/* Add the edge. */
		mGraph.get(src).put(dst, length);
	}

	/**
	 * Given a src node, dstination, and length, adds an arc from the src node
	 * to the dstination of the length. If an arc already existed, the length is
	 * updated to the specified value. If either endpoint does not exist in the
	 * graph, insert the missing.
	 *
	 * @param src
	 *            The src node.
	 * @param dst
	 *            The dstination node.
	 * @param length
	 *            The length of the edge.
	 */
	public void addEdgeInsert(T src, T dst, double length) {
		/* Confirm both endpoints exist. */
		if (!mGraph.containsKey(src)) addNode(src);
		if (!mGraph.containsKey(dst)) addNode(dst);
		/* Add the edge. */
		mGraph.get(src).put(dst, length);
	}

	/**
	 * Removes the edge from src to dst from the graph. If the edge does not
	 * exist, this operation is a no-op. If either endpoint does not exist, this
	 * throws a NoSuchElementException.
	 *
	 * @param src
	 *            The src node.
	 * @param dst
	 *            The dstination node.
	 * @throws NoSuchElementException
	 *             If either node is not in the graph.
	 */
	public void removeEdge(T src, T dst) {
		/* Confirm both endpoints exist. */
		if (!mGraph.containsKey(src) || !mGraph.containsKey(dst)) throw new NoSuchElementException(
				"Both nodes must be in the graph.");

		mGraph.get(src).remove(dst);
	}

	/**
	 * Given a node in the graph, returns an immutable view of the edges leaving
	 * that node, as a map from endpoints to costs.
	 *
	 * @param node
	 *            The node whose edges should be queried.
	 * @return An immutable view of the edges leaving that node.
	 * @throws NoSuchElementException
	 *             If the node does not exist.
	 */
	public Map<T, Double> edgesFrom(T node) {
		/* Check that the node exists. */
		Map<T, Double> arcs = mGraph.get(node);
		if (arcs == null) throw new NoSuchElementException(
				"Source node does not exist.");

		return Collections.unmodifiableMap(arcs);
	}

	/**
	 * Returns an iterator that can traverse the nodes in the graph.
	 *
	 * @return An iterator that traverses the nodes in the graph.
	 */
	public Iterator<T> iterator() {
		return mGraph.keySet().iterator();
	}

	/**
	 * Returns whether a given node is contained in the graph.
	 *
	 * @param The
	 *            node to test for inclusion.
	 * @return Whether that node is contained in the graph.
	 */
	public boolean containsNode(T node) {
		return mGraph.containsKey(node);
	}

	/**
	 * Returns the number of nodes in the graph.
	 *
	 * @return The number of nodes in the graph.
	 */
	public int size() {
		return mGraph.size();
	}

	/**
	 * Returns whether the graph is empty.
	 *
	 * @return Whether the graph is empty.
	 */
	public boolean isEmpty() {
		return mGraph.isEmpty();
	}
}