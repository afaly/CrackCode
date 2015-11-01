package cf_297;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());

		char[] c = in.nextLine().toCharArray();
		int[] v = new int[26];
		int cnt = 0;
		for (int i = 0; i < c.length - 1; i += 2) {
			v[c[i] - 'a']++;
			if (v[c[i + 1] - 'A'] > 0) v[c[i + 1] - 'A']--;
			else
				cnt++;
		}

		System.out.println(cnt);

		in.close();
	}

}
