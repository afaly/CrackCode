package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EvenTree {

	private static HashMap<Integer, ArrayList<Integer>> T;
	private static boolean[] vis;
	private static int[] cnt;
	private static int N, M;

	public static int cutEdges() {
		cnt = new int[N + 1];
		vis = new boolean[N + 1];
		// Arrays.fill(cnt, 1);
		cutEdges(0, 1);
//		System.out.println(Arrays.toString(cnt));
		int even = 0;
		for (int i = 1; i <= N; i++)
			if (cnt[i] % 2 == 0) even++;
		return even - 1;
	}

	private static int cutEdges(int prnt, int n) {
		cnt[n]++;
		for (int nxt : T.get(n))
			if (nxt != prnt) cnt[n] += cutEdges(n, nxt);
		return cnt[n];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		N = I(s[0]);
		M = I(s[1]);
		T = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < M; i++) {
			s = in.nextLine().split("\\s+");
			int src = I(s[0]), dst = I(s[1]);
			if (!T.containsKey(src)) T.put(src, new ArrayList<Integer>());
			if (!T.containsKey(dst)) T.put(dst, new ArrayList<Integer>());
			T.get(src).add(dst);
			T.get(dst).add(src);
		}
		System.out.println(cutEdges());

		in.close();
	}
}
