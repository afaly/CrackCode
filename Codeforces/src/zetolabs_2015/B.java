package zetolabs_2015;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		int n = (1 << (N + 1)) - 1;
		int e = (1 << (N + 1)) - 2;
		System.out.println("Nodes: " + n + "  Edges: " + e);
		int[] a = new int[s.length + 1];
		for (int i = 0; i < s.length; i++)
			a[i + 1] = Integer.parseInt(s[i]);

		int max = 0;
		for (int i = (1 << N) - 1; i < (1 << (N + 1)) - 1; i++) {
			int cnt = 0, j = i;
			while (j > 0) {
				cnt += a[j];
				j--;
				j >>= 1;
			}
			max = Math.max(max, cnt);
		}
		int[] b = Arrays.copyOf(a, a.length);
		for (int i = (1 << N) - 2; i >= 0; i--) {
			System.out.println(i);
			b[i] = Math.max(b[(i << 1) + 1], b[(i << 1) + 2]);
		}

		int value = 0;
		for (int i = 0; i <= N; i++) {
			int level = 0;
			for (int j = (1 << i) - 1; j < (1 << (i + 1)) - 1; j++) {
				value += (max - b[j]);
				level = Math.max(level, b[j]);
			}
			max -= level;
		}

		System.out.println(value);
		in.close();
	}
}
