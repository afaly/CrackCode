package bloomberg;

import java.util.ArrayList;
import java.util.HashMap;

public class Bloom_012 {

	private static int N, D;
	private static HashMap<Integer, ArrayList<Integer>> res;

	public static HashMap<Integer, ArrayList<Integer>> GenLex(int n) {
		N = n;
		res = new HashMap<Integer, ArrayList<Integer>>();
		int i = 1;
		while (n > 0) {
			res.put(i++, new ArrayList<Integer>());
			n /= 10;
		}
		res.put(i, new ArrayList<Integer>());
		D = i;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int k = 1; k < 10; k++)
			list.add(k);
		genLex(list, 1);
		return res;
	}

	public static void genLex(ArrayList<Integer> l, int n) {
		if (n > D) return;
		res.get(n).addAll(l);
		for (int x : l) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++)
				list.add((x * 10) + i);
			genLex(list, n + 1);
		}
	}

	public static void main(String[] args) {
		HashMap<Integer, ArrayList<Integer>> r = GenLex(100);
		for (Integer k : r.keySet()) {
			System.out.println(res.get(k));
		}
	}

}
