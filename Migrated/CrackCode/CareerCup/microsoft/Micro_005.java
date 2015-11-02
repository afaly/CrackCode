package microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class Micro_005 {

	private static ArrayList<ArrayList<Integer>> p;
	private static int N;
	private static int[] n;

	public static ArrayList<ArrayList<Integer>> PowerSet(int[] data) {
		N = data.length;
		n = data;
		p = new ArrayList<ArrayList<Integer>>();
		powerSet(new Stack<Integer>(), 0);
		return p;
	}

	private static void powerSet(Stack<Integer> x, int i) {
		if (i == N) {
			p.add(new ArrayList<Integer>(x));
		} else {
			x.push(n[i]);
			powerSet(x, i + 1);
			x.pop();
			powerSet(x, i + 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = PowerSet(new int[] { 1, 1, 2, 3 });
		for (ArrayList<Integer> l : res)
			System.out.println(l);
	}

}
