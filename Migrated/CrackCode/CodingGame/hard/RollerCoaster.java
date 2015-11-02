package hard;

import java.util.Scanner;

public class RollerCoaster {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt(), C = in.nextInt(), N = in.nextInt(), cur = 0;

		int[] g = new int[N];
		int[] s = new int[N];
		int[] p = new int[N];

		for (int i = 0; i < N; i++)
			g[i] = in.nextInt();

		for (int i = 0; i < N; i++) {
			s[i] = 0;
			int j = i, k = 0;
			for (; k < N && s[i] + g[j] <= L; k++, j = (j + 1) % N)
				s[i] += g[j];
			p[i] = j;
		}

		long v = 0;
		for (int i = 0; i < C; i++) {
			v += s[cur];
			cur = p[cur];
		}
		System.out.println(v);

		in.close();
	}
}
