package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_000103_StackingBoxes {

	static class box implements Comparable<box> {

		int[] v;
		int sum, dim, id;

		public box(int id, int[] dimentions) {
			this.id = id;
			v = dimentions;
			dim = dimentions.length;
			Arrays.sort(v);
			sum = 0;
			for (int dim : v)
				sum += dim;
		}

		public box(int id, String dimentions) {
			this.id = id;
			String[] s = dimentions.split("\\s+");
			dim = s.length;
			v = new int[dim];
			sum = 0;
			for (int i = 0; i < dim; i++)
				sum += v[i] = Integer.parseInt(s[i]);
			Arrays.sort(v);
		}

		@Override
		public int compareTo(box that) {
			return that.sum - this.sum;
		}

		public int Dim() {
			return dim;
		}

		public boolean nest(box that) {
			if (that.Dim() != dim) return false;
			for (int i = 0; i < dim; i++) {
				if (v[i] < that.v[i]) return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return Arrays.toString(v);
		}
	}

	private static box[] b;
	private static int N, D;

	public static int[] StackBoxes(box[] boxes, int dim) {
		b = boxes;
		N = boxes.length;
		D = dim;
		Arrays.sort(b);
		int[] dp = new int[N];
		int[] pd = new int[N];
		Arrays.fill(dp, 1);
		Arrays.fill(pd, -1);
		int MAX_IDX = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (boxes[j].nest(boxes[i]) && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					pd[i] = j;
				}
			}
			if (dp[MAX_IDX] < dp[i]) MAX_IDX = i;
		}
		int[] res = new int[dp[MAX_IDX]];
		int itr = 0;
		while (MAX_IDX >= 0) {
			res[itr++] = boxes[MAX_IDX].id;
			MAX_IDX = pd[MAX_IDX];
		}
		return res;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	// 7 2 5 6
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		while (s != null && !s.isEmpty()) {
			int[] p = IA(s);
			box[] B = new box[p[0]];
			for (int i = 0; i < p[0]; i++)
				B[i] = new box(i + 1, in.nextLine());
			int[] res = StackBoxes(B, p[1]);
			System.out.print(res[0]);
			for (int i = 1; i < res.length; i++)
				System.out.print(" " + res[i]);
			System.out.println();
			s = in.nextLine();
		}
		in.close();
	}

}
