package timus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 73251890877325189087 5 it your reality real our 4294967296 5 it your reality
 * real our -1
 */
class Trie {
	class node {
		boolean wrd;
		node[] nxt;

		public node(int size) {
			this.wrd = false;
			this.nxt = new node[size];
		}

		public void word() {
			this.wrd = true;
		}
	}

	node root;
	int size;

	public Trie(int size) {
		this.size = size;
		this.root = new node(size);
	}

	public void add(char[] s) {
		node itr = root;
		for (int i = 0; i < s.length; i++) {
			if (itr.nxt[s[i] - '0'] == null) itr.nxt[s[i] - '0'] = new node(
					size);
			itr = itr.nxt[s[i] - '0'];
			if (i == s.length - 1) itr.word();
		}
	}

	public int isPrefix(char[] s) {
		node itr = root;
		for (int i = 0; i < s.length; i++) {
			if (itr.nxt[s[i] - '0'] == null) return i;
			itr = itr.nxt[s[i] - '0'];
		}
		return s.length;
	}

	public int isPrefix(char[] s, int i) {
		node itr = root;
		for (; i < s.length; i++) {
			if (itr.nxt[s[i] - '0'] == null) return i;
			itr = itr.nxt[s[i] - '0'];
		}
		return s.length;
	}

	public boolean isPrefix(char[] s, int i, int j) {
		node itr = root;
		for (; i < j; i++) {
			if (itr.nxt[s[i] - '0'] == null) return false;
			itr = itr.nxt[s[i] - '0'];
		}
		return true;
	}

	public boolean isWord(char[] s) {
		node itr = root;
		for (int i = 0; i < s.length; i++) {
			if (itr.nxt[s[i] - '0'] == null) return false;
			itr = itr.nxt[s[i] - '0'];
		}
		return itr.wrd;
	}

	public boolean isWord(char[] s, int i, int j) {
		node itr = root;
		for (; i < j; i++) {
			if (itr.nxt[s[i] - '0'] == null) return false;
			itr = itr.nxt[s[i] - '0'];
		}
		return itr.wrd;
	}

}

public class T_1002_PhoneNumbers {

	private static char[] map = new char[26];
	static {
		map['i' - 'a'] = '1';
		map['j' - 'a'] = '1';

		map['a' - 'a'] = '2';
		map['b' - 'a'] = '2';
		map['c' - 'a'] = '2';

		map['d' - 'a'] = '3';
		map['e' - 'a'] = '3';
		map['f' - 'a'] = '3';

		map['g' - 'a'] = '4';
		map['h' - 'a'] = '4';

		map['k' - 'a'] = '5';
		map['l' - 'a'] = '5';

		map['m' - 'a'] = '6';
		map['n' - 'a'] = '6';

		map['p' - 'a'] = '7';
		map['r' - 'a'] = '7';
		map['s' - 'a'] = '7';

		map['t' - 'a'] = '8';
		map['u' - 'a'] = '8';
		map['v' - 'a'] = '8';

		map['w' - 'a'] = '9';
		map['x' - 'a'] = '9';
		map['y' - 'a'] = '9';

		map['o' - 'a'] = '0';
		map['q' - 'a'] = '0';
		map['z' - 'a'] = '0';
	}

	public static char[] toPhone(String s) {
		char[] ret = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			ret[i] = map[s.charAt(i) - 'a'];
		return ret;
	}

	private static char[] str;
	private static Trie t;
	private static int OO = Integer.MAX_VALUE;
	private static int[][] mem;
	private static boolean[] f;
	private static int[] s;

	public static int Connect(String phone, Trie trie) {
		str = phone.toCharArray();
		t = trie;
		mem = new int[str.length + 1][str.length + 1];
		f = new boolean[str.length];
		s = new int[str.length];
		Arrays.fill(s, OO);
		return connect(0, 0, 1);
	}

	private static int connect(int i, int j, int n) {
		if (j == str.length) {
			if (t.isWord(str, i, j)) {
				for (int k = i + 1; k < j; k++)
					f[k] = false;
				return n;
			} else return OO;
		}
		if (mem[i][j] > 0) { return mem[i][j]; }
		int m1 = OO, m2 = OO;
		if (t.isPrefix(str, i, j + 1)) m1 = connect(i, j + 1, n);
		if (t.isWord(str, i, j) && t.isPrefix(str, j, j + 1)) m2 = connect(j,
				j + 1, n + 1);
		mem[i][j] = Math.min(m1, m2);
		if (m2 < m1) {
			int sj = OO;
			for (int k = i; k < j; k++)
				sj = Math.min(sj, s[k]);
			if (m2 < sj) {
				// System.out.println(m2 + " , " + sj + " : " + str[i] + " , "
				// + str[j]);
				for (int k = i; k < j; k++) {
					s[k] = m2;
					f[k] = false;
				}
				f[j] = true;
			}
		}
		return mem[i][j];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String phone = in.nextLine().trim();
		while (!phone.equalsIgnoreCase("-1")) {
			int N = Integer.parseInt(in.nextLine());
			HashMap<String, String> m = new HashMap<String, String>();
			Trie t = new Trie(10);
			// System.out.println("-----------------------------");
			for (int i = 0; i < N; i++) {
				String s = in.nextLine().trim().toLowerCase();
				char[] p = toPhone(s);
				String ps = new String(p);
				m.put(ps, s);
				t.add(p);
				// System.out.println(s + " : " + ps);
			}
			// System.out.println("-----------------------------");
			int words = Connect(phone, t);
			System.out.println(Arrays.toString(f));
			if (words < Integer.MAX_VALUE) {
				StringBuilder sb = new StringBuilder();
				int i = 0, j = 0;
				for (; j < phone.length(); j++) {
					if (f[j]) {
						String key = phone.substring(i, j);
						System.out.println(key);
						sb.append(m.get(key)).append(" ");
						i = j;
					}
				}
				String key = phone.substring(i, j);
				System.out.println(key);
				sb.append(m.get(key));
				System.out.println(sb.toString().trim());
			} else {
				System.out.println("No solution.");
			}
			phone = in.nextLine().trim();
		}

		in.close();
	}
}
