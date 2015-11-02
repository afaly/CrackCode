package edu;

public class TCO_RGBStreet {

	private static int[][] rgb, mem;
	private static int N, OO = Integer.MAX_VALUE;

	private static void getRGB(String[] h) {
		N = h.length;
		rgb = new int[N][3];
		String[] v;
		for (int i = 0; i < N; i++) {
			v = h[i].split("\\s+");
			rgb[i][0] = I(v[0]);
			rgb[i][1] = I(v[1]);
			rgb[i][2] = I(v[2]);
		}
	}

	private static int cost(int h, int clr) {
		if (h == N) return 0;
		if (clr >= 0 && mem[h][clr] > 0) return mem[h][clr];
		mem[h][clr] = OO;
		if (clr != 0) mem[h][clr] = Math.min(mem[h][clr],
				rgb[h][0] + cost(h + 1, 0));
		if (clr != 1) mem[h][clr] = Math.min(mem[h][clr],
				rgb[h][1] + cost(h + 1, 1));
		if (clr != 2) mem[h][clr] = Math.min(mem[h][clr],
				rgb[h][2] + cost(h + 1, 2));
		return mem[h][clr];
	}

	public static int estimateCost(String[] houses) {
		getRGB(houses);
		mem = new int[N][4];
		return cost(0, 3);
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		String[] s = { "1 100 100", "100 1 100", "100 100 1" }, b = {
				"1 100 100", "100 100 100", "1 100 100" }, a = { "26 40 83",
				"49 60 57", "13 89 99" };
		System.out.println(estimateCost(s));
		System.out.println(estimateCost(b));
		System.out.println(estimateCost(a));
	}

}
