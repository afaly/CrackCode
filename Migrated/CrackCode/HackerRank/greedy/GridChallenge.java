package greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class GridChallenge {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class pq {
		PriorityQueue<Character> q;

		public pq() {
			q = new PriorityQueue<Character>();
		}

		public char poll() {
			return q.poll();
		}

		public char peek() {
			return q.peek();
		}

		public void add(Character a) {
			q.offer(a);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			int N = I(in.nextLine());
			char[] v;
			pq[] c = new pq[N];
			for (int i = 0; i < N; i++) {
				v = in.nextLine().toCharArray();
				pq t = new pq();
				for (int j = 0; j < N; j++)
					t.add(v[j]);
				c[i] = t;
			}
			boolean valid = true;
			for (int i = 0; i < N && valid; i++) {
				char pre = c[0].poll();
				for (int j = 1; j < N && valid; j++) {
					char cur = c[j].poll();
					if (cur < pre) valid = false;
					else
						pre = cur;
				}
			}

			System.out.println(valid ? "YES" : "NO");
		}
		in.close();
	}
}
