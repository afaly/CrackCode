package cf_287;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class pair<K, V> {
	K first;
	V second;

	public pair(K first, V second) {
		this.first = first;
		this.second = second;
	}
}

public class AmrMusic {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int K = Integer.parseInt(ss[1]);
		ss = in.nextLine().split(" ");
		ArrayList<pair<Integer, Integer>> a = new ArrayList<pair<Integer, Integer>>(
				N);
		for (int i = 0; i < N; i++) {
			a.add(new pair<Integer, Integer>(Integer.parseInt(ss[i]), (i + 1)));
		}
		Comparator<pair<Integer, Integer>> cmp = new Comparator<pair<Integer, Integer>>() {

			@Override
			public int compare(pair<Integer, Integer> o1,
					pair<Integer, Integer> o2) {
				return o1.first.compareTo(o2.first);
			}
		};
		Collections.sort(a, cmp);
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (pair<Integer, Integer> p : a) {
			K -= p.first;
			if (K >= 0) {
				cnt++;
				sb.append(p.second).append(" ");
			} else
				break;
		}

		System.out.println(cnt);
		System.out.println(sb.toString().trim());

		in.close();
	}
}
