package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class N<T> {
	T d;
	int i;

	public N(T data, int idx) {
		this.d = data;
		this.i = idx;
	}
}

class E implements Comparable<E> {
	int s, d;
	double w;

	public E(int src, int dst, double weight) {
		this.s = src;
		this.d = dst;
		this.w = weight;
	}

	@Override
	public int compareTo(E e) {
		return w - e.w >= 0 ? Math.abs(w - e.w) < 1e-6 ? 0 : 1 : -1;
	}
}

class Adj {
	ArrayList<E> adj;
	int src;

	public Adj(int src) {
		this.adj = new ArrayList<E>();
		this.src = src;
	}

	public void add(E edge) {
		this.adj.add(edge);
	}

	public void add(int dst, double weight) {
		this.adj.add(new E(src, dst, weight));
	}
}

public class G<T> {

	private Map<Integer, T> dmap;
	private Adj[] gmap;
	private int numOfNodes, numOfEdges, nodeIdx;

	public G(int numOfNodes, int numOfEdges) {
		this.numOfNodes = numOfNodes;
		this.numOfEdges = numOfEdges;
		this.nodeIdx = 0;
		this.dmap = new HashMap<Integer, T>(numOfNodes);
		this.gmap = new Adj[numOfNodes];
	}

	public G(int numOfNodes) {
		this.numOfNodes = numOfNodes;
		this.numOfEdges = 0;
		this.nodeIdx = 0;
		this.dmap = new HashMap<Integer, T>(numOfNodes);
		this.gmap = new Adj[numOfNodes];
	}

	public int addNode(T data) {
		dmap.put(nodeIdx, data);
		gmap[nodeIdx] = new Adj(nodeIdx);
		return nodeIdx++;
	}

	public void addEdge(int src, int dst, int weight, boolean dir) {
		gmap[src].add(dst, weight);
		if (!dir) gmap[dst].add(src, weight);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
