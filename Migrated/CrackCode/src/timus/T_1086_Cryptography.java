package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class T_1086_Cryptography {

	private static ArrayList<Integer> p;

	private static void GeneratePrimes() {
		p = new ArrayList<Integer>();
		p.add(2);
		boolean[] f = new boolean[1000010];
		f[2] = true;
		int cnt = 1;
		for (int i = 3; i < f.length && cnt <= 15000; i += 2) {
			if (!f[i]) {
				f[i] = true;
				cnt++;
				p.add(i);
				for (int j = i; j < f.length; j += i)
					f[j] = true;
			}
		}
	}

	public static void main(String[] args) {
		GeneratePrimes();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while (N-- > 0) {
			System.out.println(p.get(in.nextInt() - 1));
		}

		in.close();
	}

}
