package codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwapSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		ArrayList<Pair<Integer, Integer>> n = new ArrayList<Pair<Integer, Integer>>(
				N);
		String[] ss = in.nextLine().split(" ");
		for (int i = 0; i < N; i++)
			n.add(new Pair<Integer, Integer>(Integer.parseInt(ss[i]), i));

		Collections.sort(n);
		int i = 0;

		in.close();
	}
}

class Pair<A extends Comparable<? super A>, B> implements
		Comparable<Pair<A, B>> {
	A a;
	B b;

	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Pair<A, B> p) {
		return a.compareTo(p.a);
	}
}