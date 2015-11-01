package cf_293;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int M = Integer.parseInt(ss[1]);
		int K = Integer.parseInt(ss[2]);

		ss = in.nextLine().split(" ");
		int[] n = new int[N + 1];
		int[] p = new int[N + 1];
		p[1] = -1;
		int cur, pre = Integer.parseInt(ss[0]);
		n[pre] = 1;
		p[pre] = 0;
		for (int i = 1; i < N; i++) {
			cur = Integer.parseInt(ss[i]);
			n[cur] = i + 1;
			p[cur] = pre;
			pre = cur;
		}

		ss = in.nextLine().split(" ");
		long g = 0;
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(ss[i]);
			g += Math.ceil((n[m]*1.0 / K));
			if (n[m] > 1) {
				n[p[m]]++;
				int temp = p[m];
				p[m] = p[p[m]];
				p[temp] = --n[m];
			}
		}
		System.out.println(g);
		in.close();
	}

}
