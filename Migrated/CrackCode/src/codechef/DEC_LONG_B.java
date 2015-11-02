package codechef;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class DEC_LONG_B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while (T-- > 0) {
			String[] ss = in.nextLine().split(" ");
			int N = Integer.parseInt(ss[0]);
			int K = Integer.parseInt(ss[1]);
			ss = in.nextLine().split(" ");
			int[] v = new int[N];
			for (int i = 0; i < N; i++)
				v[i] = Integer.parseInt(ss[i]);
			Arrays.sort(v);
			BitSet b = BitSet.valueOf(new long[] { K });
			for (int i = b.size() - 1; i >= 0; i++) {
				if (b.get(i)) {
					
				} else {

				}
			}

		}
		in.close();
	}

}
