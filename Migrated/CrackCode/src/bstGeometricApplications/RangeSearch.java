package bstGeometricApplications;

import java.util.ArrayList;
import java.util.Random;

import dataStructures.RedBlackBST;
import dataStructures.VisitNode;

public class RangeSearch<Key extends Comparable<Key>, Value> extends
		RedBlackBST<Key, Value> {

	private ArrayList<Value> list;

	public RangeSearch() {
		super();
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	public int rangeCount(Key lo, Key hi) {
		int cnt = 0;
		if (contains(hi)) cnt++;
		if (contains(lo)) cnt++;
		int rhi = rank(hi);
		int rlo = rank(lo);
		System.out.printf("\n[%d , %d]   Rank LO: %d , Rank HI: %d\n", lo, hi,
				rlo, rhi);
		return cnt + ((rhi - rlo) - 1);
	}

	public ArrayList<Value> rangeSearch(Key lo, Key hi) {
		list = new ArrayList<>();
		rangeSearch(lo, hi, root);
		return list;
	}

	private void rangeSearch(Key lo, Key hi, Node x) {
		if (x == null) return;

		int clo = x.key.compareTo(lo);
		int chi = x.key.compareTo(hi);

		if (clo > 0) rangeSearch(lo, hi, x.l);
		if (clo >= 0 && chi <= 0) list.add(x.val);
		if (chi < 0) rangeSearch(lo, hi, x.r);
	}

	public static void main(String[] args) {
		RangeSearch<Integer, String> bst = new RangeSearch<>();
		bst.setVisiter(new VisitNode<Integer, String>() {

			@Override
			public void Visit(Integer key, String val) {
				System.out.println("Key: " + key + " , " + " Value: " + val);
			}
		});
		for (int i = 0; i < 20; i += 2) {
			bst.put(i, "" + i);
		}

		bst.inorder();
		Random r = new Random(System.currentTimeMillis());
		for (String s : bst.rangeSearch(5, 15)) {
			System.out.println(s);
		}
		for (int i = 0; i < 0; i++) {
			int lo = r.nextInt(10);
			int hi = lo + r.nextInt(20);
			System.out.println("[" + lo + " , " + hi + "]");
			for (String s : bst.rangeSearch(lo, hi)) {
				System.out.println(s);
			}
		}
	}

}
