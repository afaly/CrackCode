package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MehtaTypicalSupermarket {

	public static long Count(long l, long r, int[] a) {
		long cnt = 0l;
		for (int i = 0; i < a.length; i++) {
			cnt += r / a[i];
			cnt -= l / a[i];
			System.out.println(">> " + cnt + "  : " + a[i]);
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println("MORE : " + (1 << 17));
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int[] c = new int[N];
		for (int i = 0; i < N; i++)
			c[i] = Integer.parseInt(in.nextLine());
		Arrays.sort(c);
		int D = Integer.parseInt(in.nextLine());
		long L, R;
		for (int j = 0; j < D; j++) {
			String[] ss = in.nextLine().trim().split(" ");
			L = Long.parseLong(ss[0]);
			R = Long.parseLong(ss[1]);
			System.out.println(Count(L, R, c));
		}
		in.close();
	}

}
