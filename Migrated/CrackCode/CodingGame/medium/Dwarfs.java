package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dwarfs {
	private static Map<Integer, ArrayList<Integer>> M;
	private static Set<Integer> F;
	private static Map<Integer, Integer> D;

	public static int depth(int n) {
		if (F.contains(n)) return D.get(n);
		int max_dist = 1;
		F.add(n);
		for (Integer nn : M.get(n))
			max_dist = Math.max(max_dist, depth(nn) + 1);
		D.put(n, max_dist);
		F.remove(n);
		return max_dist;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		M = new HashMap<Integer, ArrayList<Integer>>();
		D = new HashMap<Integer, Integer>();
		F = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			if (!M.containsKey(x)) M.put(x, new ArrayList<Integer>());
			if (!M.containsKey(y)) M.put(y, new ArrayList<Integer>());
			M.get(x).add(y);
		}

		int max_dist = 0;

		for (Integer S : M.keySet())
			depth(S);
		for (Integer k : D.keySet()) {
			max_dist = Math.max(max_dist, D.get(k));
		}
		System.out.println(max_dist);

		in.close();
	}
}
