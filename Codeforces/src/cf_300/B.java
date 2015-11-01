package cf_300;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		vals.add(1);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		boolean work = true;
		while (work) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (Integer x : a) {
				int y = x * 10;
				if (y > v) {
					work = false;
					break;
				}
				b.add(y);
				if (y + 1 > v) {
					work = false;
					break;
				}
				b.add(y + 1);
			}
			vals.addAll(b);
			a = b;
		}
		a.clear();
		System.out.println(vals.size());
		System.out.println(vals);
		for (int i = vals.size() - 1; i >= 0 && v > 0; i--) {
			int x = vals.get(i);
			while (x <= v && v > 0) {
				a.add(x);
				v -= x;
			}
		}
		System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i));
			if (i < a.size() - 1) System.out.print(" ");
		}
		in.close();
	}
}
