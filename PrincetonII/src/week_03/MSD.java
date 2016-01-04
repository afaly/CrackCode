package week_03;

import java.util.Arrays;
import java.util.Random;

public class MSD {

	private static final int R = 256;
	private static String[] aux;

	private static void sort(String[] a, int w, int lo, int hi, int W) {
		if (hi <= lo) return;
		int[] freq = new int[R + 2];
		for (int i = lo; i <= hi; i++)
			freq[(w < a[i].length() ? a[i].charAt(w) : -1) + 2]++;
		for (int i = 0; i < R + 1; i++)
			freq[i + 1] += freq[i];
		for (int i = lo; i <= hi; i++)
			aux[w < a[i].length() ? freq[a[i].charAt(w) + 1]++ : 0] = a[i];
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		for (int i = 0; i < R; i++)
			sort(a, w + 1, lo + freq[i], lo + freq[i + 1], W);
	}

	public static void Sort(String[] a, int W) {
		aux = new String[a.length];
		sort(a, 0, 0, a.length - 1, W);
	}

	public static void main(String[] args) {
		String[] d = { "abab", "acaf", "agal", "bacd", "baaa", "bbbb", "asda",
				"xyzx", "zyxx", "xxyz", "xxyy", "aaaa" };
		MSD.Sort(d, 4);
		System.out.println(Arrays.toString(d));
		int[] v = new int[1000];
		Random r = new Random();
		for (int i = 0; i < v.length; i++)
			v[i] = r.nextInt(100);
		LSD.Sort(v);
		System.out.println(Arrays.toString(v));
	}
}
