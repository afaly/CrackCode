package counterCode;

import java.util.Scanner;

public class dirtyDegree {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			String[] s = in.nextLine().trim().split("\\s+");
			int N = I(s[0]), M = I(s[1]), il = 0, ir = N - 1, idxF = 0, degF = 0;
			boolean left = true;
			int[] deg = new int[N];

			while (M > 0) {
				if (left) {
					M--;
					if (M <= 0) {
						idxF = il + 1;
						degF = deg[il];
						break;
					}
					deg[il]++;
					il++;

				} else {
					M--;
					if (M <= 0) {
						idxF = ir + 1;
						degF = deg[ir];
						break;
					}
					deg[ir]++;
					ir--;
				}
				left ^= true;

				if (il > ir) {
					il = 0;
					ir = N - 1;
				}
			}

			System.out.println(idxF + " " + degF);
		}
		in.close();
	}
}