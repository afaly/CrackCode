package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Bloom_013 {
	private static int ALPHABET_SIZE;

	static class node {
		node[] t;
		boolean leaf;

		public node() {
			t = new node[ALPHABET_SIZE];
			leaf = false;
		}
	}

	static class trie {
		node root;

		public trie(int A) {
			ALPHABET_SIZE = A;
			root = new node();
		}

		public void add(String s) {
			char[] a = s.toCharArray();
			node temp = root;
			for (int i = 0; i < a.length; i++) {
				if (temp.t[a[i] - 'a'] == null) temp.t[a[i] - 'a'] = new node();
				temp = temp.t[a[i] - 'a'];
			}
			temp.leaf = true;
		}

		public boolean isPrefix(String s) {
			char[] a = s.toCharArray();
			node temp = root;
			for (char c : a) {
				if (temp.t[c - 'a'] == null) return false;
				temp = temp.t[c - 'a'];
			}
			return true;
		}

		public node getPrefix(String s) {
			char[] a = s.toCharArray();
			node temp = root;
			for (char c : a) {
				if (temp.t[c - 'a'] == null) return null;
				temp = temp.t[c - 'a'];
			}
			return temp;
		}

		public boolean isWord(String s) {
			char[] a = s.toCharArray();
			node temp = root;
			for (char c : a) {
				if (temp.t[c - 'a'] == null) return false;
				temp = temp.t[c - 'a'];
			}
			return temp.leaf;
		}

		private static ArrayList<String> res;

		public ArrayList<String> withPrefix(String s) {
			res = new ArrayList<String>();
			node temp = getPrefix(s);
			if (temp.leaf) res.add(s);
			withPrefix(temp, s.toCharArray());
			return res;
		}

		private void withPrefix(node n, char[] prefix) {
			if (n == null) return;
			int len = prefix.length;
			char[] d = Arrays.copyOf(prefix, len + 1);
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				if (n.t[i] != null) {
					d[len] = (char) (i + 'a');
					withPrefix(n.t[i], d);
					if (n.t[i].leaf) res.add(new String(d));
				}
			}
		}
	}

	public static HashMap<String, String> book;
	public static trie T;

	public static void PhoneBook(String[] contacts, String[] quires) {
		book = new HashMap<String, String>();
		T = new trie(26);
		for (String c : contacts) {
			String[] s = c.split("\\s+");
			book.put(s[0].toLowerCase(), s[1]);
			T.add(s[0].toLowerCase());
		}

		for (String q : quires) {
			ArrayList<String> names = T.withPrefix(q);
			if (names != null && names.size() > 0) {
				for (String name : names) {
					System.out.println(name + " : " + book.get(name));
				}
			}
		}
	}

	public static void main(String[] args) {
		/*-
		trie t = new trie(26);
		System.out.println(t.isPrefix("abd"));
		t.add("abd");
		t.add("abdalrhman");
		System.out.println(t.isPrefix("abd"));
		t.add("abdulla");
		System.out.println(t.isPrefix("fa"));
		t.add("fathy");
		t.add("faolly");
		t.add("fantom");
		t.add("frahth");
		System.out.println(t.isPrefix("fa"));
		System.out.println(">> : " + t.isWord("abd"));
		System.out.println(t.isWord("abdalrhman"));
		System.out.println(t.isWord("abdulla"));
		System.out.println(t.isWord("fathy"));
		System.out.println(t.withPrefix("abd"));
		System.out.println(t.withPrefix("fr"));
		 */

	}

}
