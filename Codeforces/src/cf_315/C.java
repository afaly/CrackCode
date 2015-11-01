package cf_315;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class C {

	public static long R(long x) {
		return Long.parseLong(new StringBuilder("" + x).reverse().toString());
	}

	public static ArrayList<Long> genPal(int K) {
		ArrayList<Long> l = new ArrayList<Long>();
		ArrayList<Long> s = new ArrayList<Long>();
		for (long i = 1; i < 10; i++) {
			s.add(i);
			l.add(i);
		}
		boolean odd = false;
		int p = 10;
		while (l.size() < K) {
			Iterator<Long> itr = s.iterator();
			ArrayList<Long> t = new ArrayList<Long>();
			while (itr.hasNext()) {
				long v = itr.next(), r = R(v);
				if (odd) {
					for (int i = 0; i < 10; i++)
						t.add((v * p * 10) + (i * p) + r);
					p *= 10;
				} else {
					t.add((v * p + r));
				}
			}
			l.addAll(t);
			s = t;
		}
		return l;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		System.out.println(genPal(T));
		in.close();
	}
}
