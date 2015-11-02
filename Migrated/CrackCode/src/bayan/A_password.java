package bayan;

import java.util.HashSet;
import java.util.Scanner;

public class A_password {

	// !@#$%^&*()
	static HashSet<Character> set;

	static void Init() {
		set = new HashSet<Character>();
		for (char c : "!@#$%^&*()".toCharArray())
			set.add(c);
	}

	static String solve(String password) {
		int cnt = 0, cntd = 0, cntl = 0;
		boolean capl = false, smal = false, nonld = false, distinct = true;
		char cc;
		char[] c = password.toCharArray();
		boolean[] f = new boolean[256];
		for (int i = 0; i < c.length; i++) {
			cc = c[i];
			if (!f[cc])
				f[cc] = true;
			else
				distinct = false;
			if (Character.isAlphabetic(cc)) {
				cntl++;
				if (Character.isUpperCase(cc)) {
					capl = true;
				} else
					smal = true;
			} else if (Character.isDigit(cc)) {
				cntd++;
			} else if (set.contains(cc)) {
				nonld = true;
			}
		}

		if (cntd > 0)
			cnt++;
		if (cntl > 0)
			cnt++;
		if (nonld)
			cnt++;
		if (c.length >= 6)
			cnt++;
		if (c.length > 10)
			cnt++;
		if (distinct)
			cnt++;
		if (capl && smal)
			cnt++;
		if (cnt < 4)
			return "weak";
		else if (cnt >= 6)
			return "strong";
		else
			return "normal";
	}

	public static void main(String[] args) {
		Init();
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		int t = 1;
		for (; t <= T; t++) {
			in.nextLine();
			String val = in.nextLine();
			System.out.println("Case #" + t + ":");
			System.out.println(solve(val));
		}
		in.close();
	}
}
