package week_03;

import java.util.Arrays;
import java.util.Random;

public class LSD {

	public static void Sort(String[] a, int W) {
		int R = 256, N = a.length;
		String[] sorted = new String[N];
		for (int i = W - 1; i >= 0; i--) {
			int[] freq = new int[R + 1];
			for (String s : a)
				freq[s.charAt(i) + 1]++;
			for (int j = 0; j < R; j++)
				freq[j + 1] += freq[j];
			for (String s : a)
				sorted[freq[s.charAt(i)]++] = s;
			String[] temp = a;
			a = sorted;
			sorted = temp;
		}
	}

	public static void Sort(int[] a) {
		int R = 2, N = a.length, W = 32;
		int[] sorted = new int[N];
		for (int i = 0; i < W; i++) {
			int[] freq = new int[R + 1];
			for (int val : a)
				freq[((val >> i) & 1) + 1]++;
			for (int j = 0; j < R; j++)
				freq[j + 1] += freq[j];
			for (int val : a)
				sorted[freq[(val >> i) & 1]++] = val;
			int[] temp = a;
			a = sorted;
			sorted = temp;
		}
	}

	public static void main(String[] args) {
		String[] d = { "abab", "acaf", "agal", "bacd", "baaa", "bbbb", "asda",
				"xyzx", "zyxx", "xxyz", "xxyy", "aaaa" };
		LSD.Sort(d, 4);
		System.out.println(Arrays.toString(d));
		int[] v = new int[1000];
		Random r = new Random();
		for (int i = 0; i < v.length; i++)
			v[i] = r.nextInt(100);
		LSD.Sort(v);
		System.out.println(Arrays.toString(v));
	}
}
