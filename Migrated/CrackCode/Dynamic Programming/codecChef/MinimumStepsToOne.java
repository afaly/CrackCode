package codecChef;

import java.util.Scanner;

/*
 http://www.codechef.com/wiki/tutorial-dynamic-programming
 */
public class MinimumStepsToOne {

	private static int[] mem;
	private static int OO = Integer.MAX_VALUE;

	public static int TD(int n) {
		mem = new int[n + 1];
		return td(n);
	}

	private static int td(int n) {
		if (n == 1) return 0;
		if (mem[n] > 0) return mem[n];
		int v1 = td(n - 1);
		int v2 = (n & 1) == 0 ? td(n >> 1) : OO;
		int v3 = (n % 3) == 0 ? td(n / 3) : OO;
		mem[n] = 1 + Math.min(v1, Math.min(v2, v3));
		return mem[n];
	}

	public static int BU(int n) {
		mem = new int[n + 1];
		return bu(n);
	}

	private static int bu(int n) {
		mem[1] = 0;
		for (int i = 2; i <= n; i++) {
			mem[i] = mem[i - 1];
			mem[i] = (i & 1) == 0 ? Math.min(mem[i], mem[i >> 1]) : mem[i];
			mem[i] = (i % 3) == 0 ? Math.min(mem[i], mem[i / 3]) : mem[i];
			mem[i]++;
		}
		return mem[n];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		while (!s.equalsIgnoreCase("q")) {
			try {
				int n = Integer.parseInt(s);
				System.out.println("Min to One : " + TD(n) + "   " + BU(n));
			} catch (Exception e) {
				System.out.println("Invalid!");
			}
			s = in.nextLine();
		}

		in.close();
	}

}
