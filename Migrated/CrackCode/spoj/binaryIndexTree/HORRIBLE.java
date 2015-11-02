package binaryIndexTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HORRIBLE {

	static class FT {

		private long[] f;
		private long[] m;
		private int size;

		public FT(int size) {
			this.size = size;
			this.f = new long[size + 1];
			this.m = new long[size + 1];
		}

		private int lsb(int k) {
			return k & -k;
		}

		public long get(long[] array, int q) {
			long sum = 0;
			for (; q > 0; q -= lsb(q))
				sum += array[q];
			return sum;
		}

		public long get(int p, int q) {
			return get(q) - get(p - 1);
		}

		public long get(int q) {
			return get(f, q) * q - get(m, q);
		}

		public void set(long[] array, int p, int v) {
			for (; p <= size; p += lsb(p))
				array[p] += v;
		}

		public void set(int p, int q, int v) {
			set(f, p, v);
			set(f, q + 1, -v);
			set(m, p, v * (p - 1));
			set(m, q + 1, -v * q);
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] A(String s) {
		String[] ss = s.split("\\s+");
		int[] n = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			n[i] = I(ss[i]);
		return n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = I(in.readLine());
		while (T-- > 0) {
			int[] p = A(in.readLine());
			FT ft = new FT(p[0]);
			for (int i = 0; i < p[1]; i++) {
				int[] n = A(in.readLine());
				if (n[0] == 0) {
					ft.set(n[1], n[2], n[3]);
				} else {
					System.out.println(ft.get(n[1], n[2]));
				}
			}
		}
		in.close();
	}
}
