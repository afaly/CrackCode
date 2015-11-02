package codeforces;

import java.util.Scanner;

public class TeamOlymbiad {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int[][] t = new int[N][3];
		String[] s = in.nextLine().split(" ");
		int i = 0, j = 0, k = 0, v;
		for (int x = 0; x < Math.min(s.length, N); x++) {
			v = Integer.parseInt(s[x]);
			if (v == 1)
				t[i++][0] = x + 1;
			else if (v == 2)
				t[j++][1] = x + 1;
			else
				t[k++][2] = x + 1;

		}

		int min = Math.min(Math.min(i, j), k);
		System.out.println(min);
		for (int x = 0; x < min; x++) {
			System.out.println(t[x][0] + " " + t[x][1] + " " + t[x][2]);
		}

		in.close();
	}
}
