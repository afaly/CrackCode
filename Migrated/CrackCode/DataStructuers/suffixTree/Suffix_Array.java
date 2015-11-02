package suffixTree;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdOut;

public class Suffix_Array {

	private Suffix[] suffixes;
	private final char[] str;
	private final int len;

	public Suffix_Array(String s) {
		this.str = s.toCharArray();
		this.len = s.length();
		this.suffixes = new Suffix[len];
		for (int i = 0; i < len; i++)
			suffixes[i] = new Suffix(i);
		Arrays.sort(suffixes);
		// System.out.println(Arrays.toString(suffixes));
	}

	public int length() {
		return len;
	}

	public int index(int i) {
		return i >= 0 && i < len ? suffixes[i].getIdx() : -1;
	}

	public int rank(String query) {
		int lo = 0, hi = suffixes.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = compare(query, suffixes[mid]);
			if (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	// compare query string to suffix
	private static int compare(String query, Suffix suffix) {
		int N = Math.min(query.length(), suffix.length());
		for (int i = 0; i < N; i++) {
			if (query.charAt(i) < suffix.charAt(i)) return -1;
			if (query.charAt(i) > suffix.charAt(i)) return +1;
		}
		return query.length() - suffix.length();
	}

	public String select(int i) {
		if (i < 0 || i >= suffixes.length) throw new IndexOutOfBoundsException();
		return suffixes[i].toString();
	}

	public int lcp(int i) {
		if (i < 1 || i >= suffixes.length) throw new IndexOutOfBoundsException();
		return lcp(suffixes[i], suffixes[i - 1]);
	}

	// longest common prefix of s and t
	private static int lcp(Suffix s, Suffix t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) != t.charAt(i)) return i;
		}
		return N;
	}

	class Suffix implements Comparable<Suffix> {
		private int index;

		public Suffix(int idx) {
			this.index = idx;
		}

		public int length() {
			return len - index;
		}

		public int getIdx() {
			return index;
		}

		public char charAt(int j) {
			return index + j < len ? str[index + j] : null;
		}

		@Override
		public int compareTo(Suffix that) {
			if (this == that) return 0;
			int M = Math.min(this.length(), that.length());
			for (int k = 0; k < M; k++) {
				if (this.charAt(k) < that.charAt(k)) return -1;
				if (this.charAt(k) > that.charAt(k)) return +1;
			}
			return this.length() - that.length();
		}

		@Override
		public String toString() {
			return new String(str, index, length());
		}

	}

	public static void main(String[] args) {
		String s = "Abdalrhman fathy muhammed";
		s = s.replaceAll("\\s+", " ").trim();
		Suffix_Array suffix = new Suffix_Array(s);

		// StdOut.println("rank(" + args[0] + ") = " + suffix.rank(args[0]));

		StdOut.println("  i ind lcp rnk select");
		StdOut.println("---------------------------");

		for (int i = 0; i < s.length(); i++) {
			int index = suffix.index(i);
			String ith = "\""
					+ s.substring(index, Math.min(index + 50, s.length()))
					+ "\"";
			assert s.substring(index).equals(suffix.select(i));
			int rank = suffix.rank(s.substring(index));
			if (i == 0) {
				StdOut.printf("%3d %3d %3s %3d %s\n", i, index, "-", rank, ith);
			} else {
				int lcp = suffix.lcp(i);
				StdOut.printf("%3d %3d %3d %3d %s\n", i, index, lcp, rank, ith);
			}
		}
	}

}
