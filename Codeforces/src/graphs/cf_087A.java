package graphs;

import java.util.Scanner;

public class cf_087A {

	private static int[] n, d;

	public static int depth(int i) {
		if (d[i] >= 0) return d[i];
		d[i] = depth(n[i]) + 1;
		return d[i];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		n = new int[N];
		d = new int[N];
		for (int i = 0; i < N; i++) {
			n[i] = in.nextInt() - 1;
			if (n[i] == -2) d[i] = 0;
			else
				d[i] = -1;
		}
		int maxDepth = 0;
		for (int i = 0; i < N; i++) {
			if (d[i] < 0) depth(i);
			if (d[i] > maxDepth) maxDepth = d[i];
		}
//		System.out.println(Arrays.toString(d));
		System.out.println(maxDepth + 1);

		in.close();

	}
}
