package codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class LunchQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		HashMap<Integer, Integer> ma = new HashMap<>(N);
		HashMap<Integer, Integer> mb = new HashMap<>(N);
		for (int i = 0; i < N; i++) {
			String[] s = in.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			ma.put(a, b);
			mb.put(b, a);
		}

		ArrayList<Integer> la = new ArrayList<>();
		int key = 0;
		while (ma.containsKey(key)) {
			key = ma.get(key);
			la.add(key);
		}

		ArrayList<Integer> lb = new ArrayList<>();
		key = 0;
		while (mb.containsKey(key)) {
			key = mb.get(key);
			lb.add(key);
		}

		Iterator<Integer> ia = la.iterator();
		Iterator<Integer> ib = lb.iterator();
		while (ia.hasNext() && ib.hasNext()) {
			System.out.println(ia.next());
			System.out.println(ib.next());
		}
		if (ia.hasNext())
			System.out.println(ia.next());
		else if (ib.hasNext())
			System.out.println(ib.next());

		in.close();
	}

}
