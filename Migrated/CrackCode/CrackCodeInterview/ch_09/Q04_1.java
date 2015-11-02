package ch_09;

import java.util.ArrayList;
import java.util.Stack;

public class Q04_1 {

	private static ArrayList<ArrayList<Integer>> lst;
	private static int[] n;
	private static int N;

	public static ArrayList<ArrayList<Integer>> genPower(int[] array) {
		n = array;
		N = array.length;
		lst = new ArrayList<ArrayList<Integer>>();
		gen_power(0, new Stack<Integer>());
		return lst;
	}

	private static void gen_power(int i, Stack<Integer> src) {
		if (i == N) {
			ArrayList<Integer> dst = new ArrayList<Integer>(src);
			lst.add(dst);
		} else {
			src.push(n[i]);
			gen_power(i + 1, src);
			src.pop();
			gen_power(i + 1, src);
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lst = genPower(new int[] { 1, 2, 3 });
		for (ArrayList<Integer> l : lst) {
			System.out.println(l);
		}
	}

}
