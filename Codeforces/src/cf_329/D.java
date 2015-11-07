package cf_329;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class D {

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		int N = I(s[0]), M = I(s[1]);
		int[] v = new int[N];
		Adj[] t = new Adj[N];
		for (int i = 0; i < N; i++)
			t[i] = new Adj();
		for (int i = 1; i < N; i++) {
			int[] q = IA(in.nextLine());
			v[i] = q[2];
			t[q[0]].add(q[1]);
			t[q[1]].add(q[0]);
		}
		in.close();
	}

}

class Adj implements Iterable<Integer> {
	ArrayList<Integer> lst;

	public Adj() {
		lst = new ArrayList<Integer>();
	}

	public void add(Integer dst) {
		lst.add(dst);
	}

	@Override
	public Iterator<Integer> iterator() {
		return lst.iterator();
	}
}
