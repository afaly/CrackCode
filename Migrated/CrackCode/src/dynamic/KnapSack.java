package dynamic;

import static java.lang.Math.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {

	private int[] p;
	private int[] w;
	private int size;

	public int knapsack(int[] price, int[] weight, int W) {
		if (price == null || weight == null || price.length != weight.length
				|| price.length <= 0) return 0;
		this.p = price;
		this.w = weight;
		this.size = p.length;
		return knapsack(0, W);
	}

	private int knapsack(int i, int ww) {
		if (i == size) return 0;
		int prof1 = ww >= w[i] ? knapsack(i + 1, ww - w[i]) + p[i] : -1;
		int prof2 = knapsack(i + 1, ww);
		return max(prof1, prof2);
	}

	private int[][] mem;

	public int knapsackDP(int[] price, int[] weight, int W) {
		if (price == null || weight == null || price.length != weight.length
				|| price.length <= 0) return 0;
		this.p = price;
		this.w = weight;
		this.size = p.length;
		this.mem = new int[size][W + 1];
		return knapsackDP(0, W);
	}

	private int knapsackDP(int i, int ww) {
		if (i == size) return 0;
		if (mem[i][ww] > 0) return mem[i][ww];
		int prof1 = ww >= w[i] ? knapsackDP(i + 1, ww - w[i]) + p[i] : -1;
		int prof2 = knapsackDP(i + 1, ww);
		mem[i][ww] = max(prof1, prof2);
		return mem[i][ww];
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inw = new Scanner(new FileInputStream(new File(
				"knapsack/p07_w.txt")));
		Scanner inp = new Scanner(new FileInputStream(new File(
				"knapsack/p07_p.txt")));
		Scanner inc = new Scanner(new FileInputStream(new File(
				"knapsack/p07_c.txt")));
		int SIZE = 15;
		int[] prices = new int[SIZE];
		int[] weights = new int[SIZE];
		int i = 0, W = 0;
		while (inw.hasNext())
			weights[i++] = inw.nextInt();
		i = 0;
		while (inp.hasNext())
			prices[i++] = inp.nextInt();
		W = inc.nextInt();
		KnapSack k = new KnapSack();
		System.out.println(k.knapsackDP(prices, weights, W));

		inw.close();
		inp.close();
		inc.close();
	}
}
