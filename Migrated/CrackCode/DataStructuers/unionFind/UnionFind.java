package unionFind;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {

	private static final int MIN_SIZE = 5;

	private int[] uf, rk;
	private int sz, nc;

	public UnionFind(int size) {
		this.sz = Math.max(size, MIN_SIZE);
		this.nc = sz;
		this.uf = new int[sz];
		this.rk = new int[sz];
		for (int i = 0; i < sz; i++) {
			uf[i] = i;
			rk[i] = 1;
		}
	}

	public void union(int i, int j) {
		int pi = find(i), pj = find(j);
		if (pi != pj) {
			if (rk[pi] > rk[pj]) {
				uf[pj] = pi;
				rk[pj] += rk[pi];
			} else if (rk[pi] < rk[pj]) {
				uf[pi] = pj;
				rk[pi] += rk[pj];
			} else {
				uf[pi] = pj;
				rk[pi]++;
			}
			nc--;
		}
	}

	public boolean connected(int i, int j) {
		return find(i) == find(j);
	}

	public int find(int i) {
		if (i == uf[i]) return i;
		uf[i] = find(uf[i]);
		return uf[i];
	}

	public int numOfComponents() {
		return nc;
	}

	public int size() {
		return sz;
	}

	@Override
	public String toString() {
		return Arrays.toString(uf);
	}

	public static final String urlStrTiny = "http://algs4.cs.princeton.edu/15uf/tinyUF.txt";
	public static final String urlStrMed = "http://algs4.cs.princeton.edu/15uf/mediumUF.txt";
	public static final String urlStrHuge = "http://algs4.cs.princeton.edu/15uf/largeUF.txt";

	public static void main(String[] args) throws IOException {
		URL url = new URL(urlStrMed);
		Scanner in = new Scanner(url.openStream());
		int N = Integer.parseInt(in.nextLine());
		UnionFind uf = new UnionFind(N);
		UF dk = new UF(N);

		String[] s;
		while (N-- > 0) {
			s = in.nextLine().split("\\s+");
			int i = Integer.parseInt(s[0]);
			int j = Integer.parseInt(s[1]);
			uf.union(i, j);
			dk.union(i, j);
		}
		System.out.println("# Components : " + uf.numOfComponents());
		System.out.println("# Components : " + dk.count());
		in.close();

	}
}