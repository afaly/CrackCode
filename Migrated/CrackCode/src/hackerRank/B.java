package hackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class p implements Comparable<p> {
	Integer v, i;

	public p(int i, int v) {
		this.i = i;
		this.v = v;
	}

	@Override
	public int compareTo(p o) {
		return v.compareTo(o.v);
	}

	@Override
	public String toString() {
		return "{" + i + ": " + v + "}";
	}
}

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int K = Integer.parseInt(ss[1]);
		int val;
		ss = in.nextLine().split(" ");
		Queue<p> min = new PriorityQueue<p>(N);
		Queue<p> max = new PriorityQueue<p>(N, new Comparator<p>() {

			@Override
			public int compare(p o1, p o2) {
				return -o1.compareTo(o2);
			}
		});

		for (int i = 0; i < N; i++) {
			val = Integer.parseInt(ss[i]);
			max.add(new p(i + 1, val));
			min.add(new p(i + 1, val));
		}

		int cnt = 0;
		int MIN = Integer.MAX_VALUE;
		int[][] mvs = new int[K][2];
		while (cnt < K) {
			p mx = max.poll();
			p mn = min.poll();
			MIN = (mx.v - mn.v);
			if (mx.v - 1 == mn.v || mx.v == mn.v) break;
			mx.v--;
			mn.v++;
			max.add(mx);
			min.add(mn);
			mvs[cnt][0] = mx.i;
			mvs[cnt][1] = mn.i;
			cnt++;
		}
		if (cnt < K) {
			p mx = max.poll();
			p mn = min.poll();
			MIN = Math.abs(mx.v - mn.v);
		}
		System.out.println(MIN + " " + cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(mvs[i][0] + " " + mvs[i][1]);
		}
		in.close();
	}
}
