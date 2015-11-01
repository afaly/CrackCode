package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneNumbers {
	private static class T {

		private int cnt;
		private final N root;

		private class N {

			private final Map<Integer, N> nxt;

			private N(int value) {
				this.nxt = new HashMap<Integer, N>();
				T.this.cnt++;
			}

			public void add(int[] tels, int id) {
				if (id < tels.length) {
					nxt.computeIfAbsent(tels[id], key -> new N(key)).add(tels,
							id + 1);
				}
			}
		}

		private T() {
			this.cnt = 0;
			this.root = new N(-1);
		}

		public int getCnt() {
			return cnt - 1;
		}

		public void add(int[] tels) {
			root.add(tels, 0);
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();

		T trie = new T();
		for (int i = 0; i < M; i++) {
			String tel = in.next();
			trie.add(parseTel(tel));
		}
		System.out.println(trie.getCnt());

		in.close();
	}

	private static int[] parseTel(String tel) {
		return tel.chars().map(Character::getNumericValue).toArray();
	}
}
