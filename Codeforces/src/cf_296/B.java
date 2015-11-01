package cf_296;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	private static class list {
		ArrayList<Integer> lst;

		public list() {
			lst = new ArrayList<Integer>();
		}

		public void add(int value) {
			lst.add(value);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());

		char[] s = in.nextLine().toCharArray();
		char[] t = in.nextLine().toCharArray();

		list[] m = new list[26];

		int sj = -2, si = -2, d = 0, dt = 0;

		for (int i = 0; i < N; i++) {
			if (s[i] != t[i]) {
				d++;
				if (m[s[i] - 'a'] == null) m[s[i] - 'a'] = new list();
				m[s[i] - 'a'].add(i);
			}
		}

		list lst;
		for (int i = 0; i < N && dt < 2; i++) {
			if (s[i] != t[i]) {
				if (m[t[i] - 'a'] != null) {
					lst = m[t[i] - 'a'];
					for (int j : lst.lst) {
						sj = j;
						si = i;
						dt = 1;
						if (s[si] == t[sj] && s[sj] == t[si]) {
							dt = 2;
							break;
						}
					}
				}
			}
		}
		System.out.println(d - dt);
		System.out.println((si + 1) + " " + (sj + 1));

		in.close();
	}

}
