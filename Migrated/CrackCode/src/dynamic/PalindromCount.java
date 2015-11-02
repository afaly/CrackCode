package dynamic;

import java.util.Arrays;

public class PalindromCount {

	private static long[][] mem;
	private static char[] c;
	private static int siz;

	public static long countPalindrom(String str) {
		c = str.toCharArray();
		siz = str.length();
		mem = new long[siz][siz];
		for (int i = 0; i < siz; i++)
			Arrays.fill(mem[i], -1l);
		return countPalindrom(0, siz - 1);
	}

	private static long countPalindrom(int i, int j) {
		// One Character is a palindrom.
		if (i == j) return 1;
		// Two Characters each is a palindrom and iff they are similar we got a
		// third palindrom.
		if (i + 1 == j) return 2 + (c[i] == c[j] ? 1 : 0);
		// If in the memory return it
		if (mem[i][j] > -1) return mem[i][j];
		// Not in memory calculate it.
		long val = 0l;
		// Palindrom of the middle part without the elements in the middle.
		long cal = countPalindrom(i + 1, j - 1);
		// If the boundary elements are same then we have the same number of
		// palindroms plus if we removed all the middle elements we got a
		// palindrom of the boundary elements.
		if (c[i] == c[j]) val += 1 + cal;
		// Palindrom of the first elements - LAST.
		val += countPalindrom(i, j - 1);
		// Palindrom of the last elements - FIRST.
		val += countPalindrom(i + 1, j);
		// We will have duplicates because the calls [A],[B] have two parts in
		// common which is when we remove the First element [A] and the Last
		// element [B].
		val -= cal;
		mem[i][j] = val;
		return mem[i][j];
	}

	public static void main(String[] args) {
		System.out.println(countPalindrom("ABBA"));
	}

}
