package ch_09;

import java.util.ArrayList;
import java.util.Stack;

public class Q04 {

	private static ArrayList<ArrayList<Integer>> list;
	private static int[] v;
	private static int len;

	public static ArrayList<ArrayList<Integer>> Subsets(int[] n) {
		list = new ArrayList<ArrayList<Integer>>();
		v = n;
		len = n.length;
		subsets(0, new Stack<Integer>());
		return list;
	}

	private static void subsets(int i, Stack<Integer> s) {
		if (i == len) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			t.addAll(s);
			list.add(t);
			return;
		}
		subsets(i + 1, s);
		s.push(v[i]);
		subsets(i + 1, s);
		s.pop();
	}

	public static void main(String[] args) {
		int[] n = { 1, 2, 3, 4, 5 };
		ArrayList<ArrayList<Integer>> list = Subsets(n);
		System.out.println(list.size());
		for (ArrayList<Integer> x : list) {
			System.out.println(x);
		}
	}

}
