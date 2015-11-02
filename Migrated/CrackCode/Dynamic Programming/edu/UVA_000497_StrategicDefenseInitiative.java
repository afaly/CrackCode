package edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UVA_000497_StrategicDefenseInitiative {

	public static int[] SDI(int[] m) {
		int N = m.length, max_id = 0, k = 0;
		int[] dp = new int[N + 1];
		int[] prnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			prnt[i] = -1;
			for (int j = i - 1; j >= 1; j--) {
				if (m[i - 1] > m[j - 1] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					prnt[i] = j;
				}
			}
			if (dp[max_id] < dp[i]) max_id = i;
		}

		int[] res = new int[dp[max_id]];
		while (max_id >= 0) {
			res[k++] = m[max_id - 1];
			max_id = prnt[max_id];
		}
		return res;
	}

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
		int T = I(in.nextLine());
		in.nextLine();
		while (T-- > 0) {
			ArrayList<Integer> l = new ArrayList<>();
			String s = in.nextLine();
			while (s != null && !s.isEmpty()) {
				l.add(I(s));
				s = in.nextLine();
			}
			int[] m = new int[l.size()];
			Iterator<Integer> itr = l.iterator();
			for (int i = 0; i < l.size(); i++)
				m[i] = itr.next();
			int[] res = SDI(m);
			int max_len = res.length;
			System.out.println("Max hits: " + max_len);
			for (int i = max_len - 1; i >= 0; i--) {
				System.out.println(res[i]);
			}
		}
		in.close();
	}

}
