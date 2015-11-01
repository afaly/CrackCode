package cf_303;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[] n = new int[N];
		String[] s = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++)
			n[i] = I(s[i]);
		Arrays.sort(n);
		int sum = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			if (n[i] >= sum) {
				sum += n[i];
				cnt++;
			}
		}
		System.out.println(cnt);
		in.close();
	}

}
