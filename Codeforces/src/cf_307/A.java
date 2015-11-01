package cf_307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		Integer[] v = new Integer[N];
		for (int i = 0; i < N; i++)
			v[i] = I(s[i]);
		Integer[] t = Arrays.copyOf(v, N);
		Arrays.sort(t, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		for (int i = 0; i < N; i++) {
			
		}

		in.close();
	}
}
