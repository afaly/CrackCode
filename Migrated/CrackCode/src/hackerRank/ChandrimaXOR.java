package hackerRank;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Scanner;

public class ChandrimaXOR {

	private static int N = 100;
	private static long MOD = 1000000007l;
	private static long[] fib = new long[N];
	private static long[] pow = new long[N];
	static {
		fib[0] = 1;
		fib[1] = 2;
		for (int i = 2; i < N; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		pow[0] = 1;
		for (int i = 1; i < N; i++) {
			pow[i] = pow[i - 1] + pow[i - 1];
			if (pow[i] > MOD) pow[i] -= MOD;
		}
	}

	public static int fibFloor(int low, int high, long x) {
		if (low > high) { return high; }
		int mid = (low + high) >>> 1;
		if (fib[mid] > x) {
			return fibFloor(low, mid - 1, x);
		} else if (fib[mid] < x) {
			return fibFloor(mid + 1, high, x);
		} else {
			return mid;
		}
	}

	public static int fibCeil(int low, int high, long x) {
		if (low > high) { return low; }
		int mid = (low + high) >>> 1;
		if (fib[mid] > x) {
			return fibCeil(low, mid - 1, x);
		} else if (fib[mid] < x) {
			return fibCeil(mid + 1, high, x);
		} else {
			return mid;
		}
	}

	private static BitSet toFibBase(long val) {
		BitSet b = new BitSet(100);
		int idx = N;
		while (val > 0) {
			idx = fibFloor(0, N, val);
			System.out.println(val + ": " + idx);
			val -= fib[idx];
			b.set(idx);
		}
		return b;
	}

	private static long fromFibBase(BitSet val) {
		long ret = 0l;
		for (int i = val.nextSetBit(0); i >= 0; i = val.nextSetBit(i + 1)) {
			ret += pow[i];
			if (ret > MOD) ret -= MOD;
		}
		return ret;
	}

	private static long Solve(long[] pos) {
		BitSet res = new BitSet(100);
		for (long v : pos)
			res.xor(toFibBase(v));
		return fromFibBase(res);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] ss = in.nextLine().trim().split(" ");
		long[] pos = new long[N];
		long val;
		for (int i = 0; i < N; i++) {
			val = Long.parseLong(ss[i]);
			pos[i] = val;
		}
		System.out.println(Solve(pos));
		in.close();
	}

	public static long gen(long max, long[] pos) {
		ArrayList<Long> all = new ArrayList<Long>();
		ArrayList<Long> t0 = new ArrayList<Long>();
		ArrayList<Long> t1 = new ArrayList<Long>();
		ArrayList<Long> p0 = new ArrayList<Long>();
		ArrayList<Long> p1 = new ArrayList<Long>();
		p1.add(1l);
		long cnt = 0l;
		System.out.println("MAX: " + max);
		while (cnt < max + 1) {
			t0.clear();
			t1.clear();
			for (Long l0 : p0) {
				t0.add(l0 << 1);
				t1.add((l0 << 1) + 1);
			}
			for (Long l1 : p1) {
				t0.add(l1 << 1);
			}
			all.addAll(t0);
			all.addAll(t1);
			p0.clear();
			p1.clear();
			p0.addAll(t0);
			p1.addAll(t1);
			cnt = all.size();
		}
		all.add(0l);
		all.add(1l);
		Collections.sort(all);
		Long[] val = all.toArray(new Long[0]);
		long res = 0l;
		for (long v : pos) {
			System.out.println("ALL: " + val[(int) v]);
			res ^= val[(int) v];
		}

		return res;
	}

	public static long Xor(long[] a) {
		long f1 = Long.valueOf("101010101010101010", 2);
		long f2 = Long.valueOf("010101010101010101", 2);
		int cnt = 1;
		long xor = 0l;
		int j = 0;
		for (long i = 1l; i < 1e18 && j < a.length; i++) {
			if ((((i | f1) ^ f1) == 0 || ((i | f2) ^ f2) == 0)) {
				if (cnt == a[j]) {
					xor ^= i;
					j++;
				}
				cnt++;
			}
		}
		return xor;
	}

}
