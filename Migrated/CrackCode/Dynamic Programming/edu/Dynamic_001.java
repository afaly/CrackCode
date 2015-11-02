package edu;

import java.util.Arrays;

public class Dynamic_001 {

	private static int[] _fib;

	public static int Fib(int n) {
		if (_fib != null && _fib.length > n) return _fib[n];
		if (_fib == null) _fib = new int[n + 1];
		else
			_fib = Arrays.copyOf(_fib, n + 1);
		return fib(n);
	}

	private static int fib(int n) {
		if (n <= 1) return 1;
		if (_fib[n] > 0) return _fib[n];
		_fib[n] = fib(n - 1) + fib(n - 2);
		return _fib[n];
	}

	private static int[][] maze, _mem_maze;
	private static int R, C;

	public static int MaxCost(int[][] mz) {
		maze = mz;
		R = mz.length;
		C = mz[0].length;
		_mem_maze = new int[R][C];
		return maxCost(0, 0);
	}

	private static boolean valid(int i, int j) {
		return i >= 0 && j <= 0 && i < R && j < C;
	}

	private static int maxCost(int i, int j) {
		if (!valid(i, j)) return 0;
		if (_mem_maze[i][j] > 0) return _mem_maze[i][j];
		_mem_maze[i][j] = maze[i][j]
				+ Math.max(maxCost(i + 1, j), maxCost(i, j + 1));
		return _mem_maze[i][j];
	}

	private static int[] _val;
	private static int N, VALUE;

	public static boolean sumToNumber(int[] v, int value) {
		_val = v;
		VALUE = value;
		N = v.length;
		return sumToNumber(0, 0);
	}

	private static boolean sumToNumber(int i, int sum) {
		if (i == N) return sum == VALUE;
		return sumToNumber(i + 1, sum + _val[i])
				|| sumToNumber(i + 1, sum - _val[i]);
	}

	public static void main(String[] args) {

	}

}
