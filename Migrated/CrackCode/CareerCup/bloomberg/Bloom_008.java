package bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Bloom_008 {

	public static int[] LargestK(int[] n, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : n) {
			pq.add(x);
			if (pq.size() > K) pq.poll();
		}
		int[] k = new int[K];
		while (!pq.isEmpty())
			k[--K] = pq.poll();
		return k;
	}

	public static void main(String[] args) {
		int len = 10000000;
		int[] v = new int[len];
		for (int i = 1; i < len; i++)
			v[i] = i;

		System.out.println(Arrays.toString(LargestK(v, 10)));
	}

}
