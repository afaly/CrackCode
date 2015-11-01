package cf_312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class A {

	static class P implements Comparable<P> {
		int x, a;

		public P(int x, int a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(P that) {
			return Math.abs(this.x) - Math.abs(that.x);
		}

		@Override
		public String toString() {
			return "(" + x + ":" + a + ")";
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine().trim());
		ArrayList<P> l = new ArrayList<P>();
		ArrayList<P> g = new ArrayList<P>();
		for (int i = 0; i < N; i++) {
			String[] s = in.nextLine().split("\\s+");
			P v = new P(I(s[0]), I(s[1]));
			if (I(s[0]) < 0) l.add(v);
			else
				g.add(v);
		}
		Collections.sort(l);
		Collections.sort(g);
		long cnt = 0;
		System.out.println(l.size() + " : " + l);
		System.out.println(g.size() + " : " + g);
		Iterator<P> itl = l.iterator();
		Iterator<P> itg = g.iterator();
		if (g.size() > l.size()) {
			cnt += itg.next().a;
		} else if (g.size() < l.size()) {
			cnt += itl.next().a;
		}
		int k = 0;
		while (itl.hasNext() && itg.hasNext()) {
			cnt += itl.next().a;
			cnt += itg.next().a;
			System.out.println("HERE (" + k++ + ")");
		}
		System.out.println(cnt);
		in.close();
	}
}
