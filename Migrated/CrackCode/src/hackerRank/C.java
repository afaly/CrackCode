package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>(
				N);
		Integer a, b;
		int[] k = new int[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] ss = in.nextLine().trim().split(" ");
			a = Integer.parseInt(ss[0]);
			b = Integer.parseInt(ss[1]);
			if (!m.containsKey(a)) m.put(a, new ArrayList<Integer>());
			m.get(a).add(b);
			k[i] = a;
		}
		Arrays.sort(k);
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> l = m.get(k[i]);
			Collections.sort(l);
			for (Integer j : l) {
				if (cnt <= j) cnt = j;
				else cnt = k[i];
			}
		}
		System.out.println(cnt);
		in.close();
	}

}
