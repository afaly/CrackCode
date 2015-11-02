package counterCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PoisonousPlants {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class p {
		int v;
		boolean f;

		public p(int v) {
			this.v = v;
			this.f = false;
		}

		public void mark() {
			f = true;
		}

		@Override
		public String toString() {
			return "" + v;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		LinkedList<p> n = new LinkedList<p>();
		String[] s = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++)
			n.add(new p(I(s[i])));

		boolean mark = true;
		int c = 0;
		p cur, nxt;
		while (mark) {
			mark = false;
			Iterator<p> itr = n.descendingIterator();
			cur = itr.next();
			while (itr.hasNext()) {
				nxt = itr.next();
				if (cur.v > nxt.v) {
					mark = true;
					cur.mark();
				}
				cur = nxt;
			}
			Iterator<p> dtr = n.iterator();
			while (dtr.hasNext()) {
				cur = dtr.next();
				if (cur.f) {
					System.out.println("DEL: " + cur.v);
					dtr.remove();
				}
			}

			c++;

		}
		System.out.println(c - 1);
		in.close();
	}
}
