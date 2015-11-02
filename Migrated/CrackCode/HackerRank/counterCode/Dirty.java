package counterCode;

import java.util.Scanner;

public class Dirty {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			String[] s = in.nextLine().split("\\s+");
			int N = I(s[0]), M = I(s[1]), i = 1, d = M / N, r = M % N;
			if (N % 2 == 1) {
				int il = 0, ir = N + 1;
				for (int j = 1; j <= M; j++) {
					if ((il == N / 2 + 1 && ir == N / 2 + 2)
							|| (ir == N / 2 + 1 && il == N / 2)) {
						il = 0;
						ir = N + 1;
					}
					if (j % 2 == 0) {
						ir--;
					} else {
						il++;
					}
				}
				i = M % 2 == 0 ? ir : il;
			} else {
				// N is even
				if (r == 0) i = M % 2 == 0 ? N / 2 : N / 2 + 1;
				else
					i = M % 2 == 0 ? N - ((r / 2) - 1) : (1 + r / 2);
			}
			System.out.println(i + " " + d);
		}

		in.close();
	}
}