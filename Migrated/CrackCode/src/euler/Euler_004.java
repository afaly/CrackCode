package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Euler_004 {

	public static boolean isPalind(String x) {
		int len = x.length();
		for (int i = 0; i < len / 2; i++) {
			if (x.charAt(i) != x.charAt(len - 1 - i)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), L = 1000, v;
		ArrayList<Integer> pal = new ArrayList<Integer>();
		for (int i = 0; i <= L; i++) {
			for (int j = i; j <= L; j++) {
				v = i * j;
				if (isPalind("" + v)) {
					pal.add(v);
				}
			}
		}
		Collections.sort(pal);
		while (T-- > 0) {
			v = in.nextInt();
			int idx = Collections.binarySearch(pal, v - 1);
			if (idx >= 0) System.out.println(pal.get(idx));
			else System.out.println(pal.get(-idx - 2));
		}

		in.close();
	}
}
