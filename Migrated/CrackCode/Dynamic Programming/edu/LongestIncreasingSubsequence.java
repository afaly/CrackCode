package edu;

import java.util.ArrayList;
import java.util.Stack;

public class LongestIncreasingSubsequence {

	private static int[] seq;
	private static int[][] mem;
	private static int N, CNT;
	private static ArrayList<Integer> val;

	public static int LIS(int[] sequence) {
		N = sequence.length;
		CNT = 0;
		seq = sequence;
		mem = new int[N][N + 1];
		val = new ArrayList<Integer>();
		int ans = lis(0, N, new Stack<Integer>());
		ans = lis(0, N);
		System.out.println(ans + "= " + CNT + " : " + val);
		return ans;
	}

	private static int lis(int i, int j, Stack<Integer> ans) {
		if (i == N) {
			if (ans.size() > CNT) {
				CNT = ans.size();
				val.clear();
				val.addAll(ans);
			}
			return 0;
		}
		int cnt = lis(i + 1, j, ans);
		ans.push(seq[i]);
		if (j == N || seq[i] > seq[j]) cnt = Math.max(cnt,
				1 + lis(i + 1, i, ans));
		ans.pop();
		return cnt;
	}

	private static int lis(int i, int j) {
		if (i == N) return 0;
		if (mem[i][j] > 0) return mem[i][j];
		mem[i][j] = lis(i + 1, j);
		if (j == N || seq[i] > seq[j]) mem[i][j] = Math.max(mem[i][j],
				1 + lis(i + 1, i));
		return mem[i][j];
	}

	public static void main(String[] args) {
		LIS(new int[] { 5, 2, 7, 3, 4, 6 });
	}

}
