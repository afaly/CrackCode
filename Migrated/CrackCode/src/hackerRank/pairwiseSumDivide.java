package hackerRank;

import java.util.Scanner;

public class pairwiseSumDivide {

	public static long Sum(int[] a) {
		int siz = a.length, n1 = 0, n2 = 0;
		long sum = 0l;
		for (int i = 0; i < siz; i++) {
			if (a[i] == 1) n1++;
			else if (a[i] == 2) n2++;
		}
		sum += n1 * (n1 - 1);
		sum += (n2 * (n2 - 1) / 2);
		sum += ((n1 * (siz - n1)));
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine()), N;
		while (T-- > 0) {
			N = Integer.parseInt(in.nextLine());
			String[] ss = in.nextLine().split(" ");
			int[] a = new int[N];
			for (int i = 0; i < N; i++)
				a[i] = Integer.parseInt(ss[i]);
			System.out.println(Sum(a));
		}
		in.close();
	}

}
