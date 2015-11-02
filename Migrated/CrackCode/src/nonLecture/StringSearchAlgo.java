package nonLecture;

import java.util.Arrays;

class Horspool implements StringMatcher {

	/**
	*
	**/
	private int[] map;

	private void buildShiftTable(String pat, int M) {
		map = new int[256];
		Arrays.fill(map, M);
		for (int i = 0; i < M - 1; i++)
			map[pat.charAt(i)] = Math.max(1, M - i - 1);
	}

	@Override
	public int Match(String txt, String pat) {
		int N = txt.length();
		int M = pat.length();
		boolean cont;
		buildShiftTable(pat, M);
		for (int i = 0; i < N; i++) {
			cont = true;
			for (int j = M - 1; j >= 0 && cont; j--) {
				if (pat.charAt(j) != txt.charAt(i + j)) {
					i = i + (map[txt.charAt(i + j)] - (M - j - 1));
					cont = false;
				}
			}
			if (cont) return i;
		}
		return N;
	}
}

class BruteForce implements StringMatcher {
	/**
	 * PROBLEM: O(N*M)
	 * 
	 * [1]Brute force will be worst case when the TXT string has a lot of
	 * successive repetitions that will render the jump step useless.
	 * 
	 * [2]Backup problem as the algorithm always need to fall back to previous
	 * position in the TXT string and so if we are working with streams we will
	 * have to store backups that is <= M in length that is storage hazard and
	 * security hazard and can cause bottlenecks.
	 */
	@Override
	public int Match(String txt, String pat) {
		int N = txt.length();
		int M = pat.length();

		if (M > N) return -1;

		int K = -1, v = 0;
		char c = pat.charAt(0), t;
		boolean cont = true;

		for (int i = 0; i < N; i++) {
			cont = true;
			for (int j = 0; cont && j < M; j++) {
				v = i + j;
				if (v < N) {
					t = txt.charAt(v);
					if (K == -1 && t == c) K = v;
					cont = t == pat.charAt(j);
				} else cont = false;
			}
			if (cont) return i;
			i = K > i ? K : i;
			K = -1;
		}
		return -1;
	}
}

class KMP implements StringMatcher {

	/**
	 * 
	 * 
	 */

	private int R, M;
	private int[][] dfa;

	public KMP(int R) {
		this.R = Math.min(Math.max(R, 0), 256);
	}

	private void buildDFA(String pat) {
		if (pat == null || pat.length() <= 0) return;
		this.M = pat.length();
		this.dfa = new int[M][R];
		int X = 0;
		for (int i = 0; i < M; i++) {
			dfa[i] = Arrays.copyOf(dfa[X], R); // Mismatch
			X = dfa[X][pat.charAt(i)]; // Update the Mismatch Pointer.
			dfa[i][pat.charAt(i)] = i + 1; // Match correct state.
		}
	}

	@Override
	public int Match(String txt, String pat) {
		buildDFA(pat);
		int N = txt.length();
		int s = 0, i = 0;
		for (; i < N && s < M; i++)
			s = dfa[s][txt.charAt(i)];
		if (s == M) return i - M;
		return N;
	}
}

public class StringSearchAlgo {

	public static void main(String[] args) {
		// StringMatcher sm = new BruteForce();
		// StringMatcher sm = new KMP(256);
		StringMatcher sm = new Horspool();
		String txt = "aaaaaaaaacbaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String pat = "aab";
		int shift = sm.Match(txt, pat);
		System.out.println(txt);
		for (int i = 0; i < shift; i++)
			System.out.print("-");
		System.out.println(pat);
	}
}
