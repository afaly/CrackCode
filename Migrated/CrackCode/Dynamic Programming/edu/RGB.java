package edu;

import java.util.Arrays;
import java.util.Scanner;

public class RGB {

	private static int[][] C;
	private static long[][] mem;
	private static int N, r = 0, g = 1, b = 2, OO = 1000000000;

	public static long Color(String[] houses) {
		N = houses.length;
		C = new int[N][3];
		mem = new long[N][4];
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1);
			String[] cost = houses[i].split("\\s+");
			C[i][r] = Integer.parseInt(cost[r]);
			C[i][g] = Integer.parseInt(cost[g]);
			C[i][b] = Integer.parseInt(cost[b]);
		}
		return color(0, 3);
	}

	private static long color(int i, int c) {
		if (i == N) return 0;
		if (mem[i][c] >= 0) return mem[i][c];
		mem[i][c] = OO;
		if (c != r) mem[i][c] = Math.min(mem[i][c], C[i][r] + color(i + 1, r));
		if (c != g) mem[i][c] = Math.min(mem[i][c], C[i][g] + color(i + 1, g));
		if (c != b) mem[i][c] = Math.min(mem[i][c], C[i][b] + color(i + 1, b));
		return mem[i][c];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] houses = in.nextLine().replaceAll("\"", "").split("\\s*,\\s*");
		System.out.println("Min Cost: " + Color(houses));
		in.close();
	}
}