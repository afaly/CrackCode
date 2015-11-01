package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cf_502B {

	private static final int OO = 1000000;
	private static boolean[] mem;

	public static int Solve(int v, int m) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		boolean found = false;
		int cnt = 0;
		while (!q.isEmpty() && !found) {
			for (int sz = q.size(); sz > 0 && !found; sz--) {
				int x = q.poll();
				mem[x] = true;
				if (x == m) found = true;
				if (x < m && !mem[x << 1]) q.add(x << 1);
				if (x > 0 && !mem[x - 1]) q.add(x - 1);
			}
			cnt++;
		}
		return cnt - 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt();
		mem = new boolean[(Math.max(M, N) << 1) + 1];
		System.out.println(Solve(N, M));
		in.close();
	}
}
