package codecChef;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	private static int[] ls;

	public static int BU(int[] v) {
		ls = new int[v.length];
		return bu(v);
	}

	private static int bu(int[] a) {
		for (int i = 0; i < a.length; i++) {
			ls[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && ls[j] + 1 > ls[i]) {
					ls[i] = ls[j] + 1;
				}
			}
		}
		int max_seq = 1;
		for (int i = 0; i < ls.length; i++)
			max_seq = Math.max(max_seq, ls[i]);
		return max_seq;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// String[] s = in.nextLine().split(" ");
		// int[] v = new int[s.length];
		// for (int i = 0; i < s.length; i++) {
		// v[i] = Integer.parseInt(s[i]);
		// }
		int[] v = { 1, 9, 3, 8, 11, 4, 5, 6, 4, 19, 7, 1, 7 };
		System.out.println("Length : " + BU(v));
		in.close();
	}

}
