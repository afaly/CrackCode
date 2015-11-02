package tusharRoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Dynamic {

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class cupoid implements Comparable<cupoid> {
		int l, w, h;

		public cupoid(int length, int width, int height) {
			this.l = length;
			this.w = width;
			this.h = height;
		}

		public cupoid(int[] dim) {
			if (dim[0] >= dim[1]) {
				this.l = dim[0];
				this.w = dim[1];
			} else {
				this.l = dim[1];
				this.w = dim[0];
			}
			this.h = dim[2];
		}

		@Override
		public String toString() {
			return l + "," + w + "," + h;
		}

		public int baseArea() {
			return l * w;
		}

		@Override
		public int compareTo(cupoid x) {
			return -(baseArea() - x.baseArea());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + h;
			result = prime * result + l;
			result = prime * result + w;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (!(obj instanceof cupoid)) return false;
			cupoid other = (cupoid) obj;
			if (h != other.h) return false;
			if (l != other.l) return false;
			if (w != other.w) return false;
			return true;
		}

	}

	private static ArrayList<cupoid> rotate(cupoid x) {
		int l = x.l, w = x.w, h = x.h;
		ArrayList<cupoid> list = new ArrayList<cupoid>();
		list.add(new cupoid(new int[] { l, w, h }));
		list.add(new cupoid(new int[] { h, w, l }));
		list.add(new cupoid(new int[] { l, h, w }));
		return list;
	}

	private static boolean valid(cupoid dn, cupoid up) {
		return dn.l > up.l && dn.w > up.w;
	}

	public static int maxStackCupoidHeight(ArrayList<cupoid> list) {
		Set<cupoid> set = new HashSet<cupoid>();
		for (cupoid c : list)
			set.addAll(rotate(c));
		System.out.println("Size: " + set.size());
		int idx = 0;
		cupoid[] cd = new cupoid[set.size()];
		for (cupoid c : set)
			cd[idx++] = c;
		Arrays.sort(cd);
		int[] dp = new int[set.size()];
		int[] id = new int[set.size()];
		for (int i = 0; i < dp.length; i++)
			dp[i] = cd[i].h;
		for (int i = 1; i < dp.length; i++) {
			int maxh = dp[i];
			for (int j = 0; j < i; j++) {
				if (cd[j].baseArea() > cd[i].baseArea()) {
					if (valid(cd[j], cd[i])) {
						if (maxh < dp[i] + dp[j]) {
							maxh = dp[i] + dp[j];
							id[i] = j;
						}
					}
				} else
					break;
			}
			dp[i] = maxh;
		}

		int max = 0;
		for (int i = 0; i < dp.length; i++)
			if (dp[i] > max) max = dp[i];
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(id));
		System.out.println(Arrays.toString(cd));
		return max;
	}

	public static int[] maxSquareMatrixOfOnes(boolean[][] m) {
		int R = m.length + 1, C = m[0].length + 1, max = 0, imax = -1, jmax = -1, cnt = 0;
		int[][] dp = new int[R][C];
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (m[i - 1][j - 1]) {
					dp[i][j] = Math.min(dp[i][j - 1],
							Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
					if (dp[i][j] > max) {
						imax = i;
						jmax = j;
						max = dp[i][j];
						cnt = 1;
					} else if (dp[i][j] == max) cnt++;
				}
			}
		}
		return new int[] { max, cnt, imax, jmax };
	}

	public static int waysMazeRD(int R, int C) {
		int[][] dp = new int[R][C];
		for (int i = 0; i < R; i++)
			dp[i][0] = 1;
		for (int j = 0; j < C; j++)
			dp[0][j] = 1;
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[R - 1][C - 1];
	}

	public static int LongestPalindromicSubsequence(String s) {
		if (s == null || s.length() == 0 || s.isEmpty()) return 0;
		char[] c = s.toCharArray();
		int len = s.length();
		int[][] dp = new int[len][len];
		Pair[][] rd = new Pair[len][len];
		for (int i = 0; i < len; i++)
			dp[i][i] = 1;
		for (int l = 1; l < len; l++) {
			for (int i = 0, j = i + l; i < len - l && j > i; i++, j = i + l) {
				if (c[i] == c[j]) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					// Less length by ONE previous subsequences.
					if (dp[i][j - 1] > dp[i + 1][j]) {
						dp[i][j] += dp[i][j - 1];
						rd[i][j] = new Pair(i, j - 1);
					} else {
						dp[i][j] += dp[i + 1][j];
						rd[i][j] = new Pair(i + 1, j);
					}
				}
			}
		}

		for (int i = 0; i < len; i++)
			System.out.println(Arrays.toString(dp[i]));
		int i = 0, j = len - 1, maxLen = dp[i][j], k = 0;
		char[] res = new char[maxLen];
		Pair itr;

		while (i != j) {
			itr = rd[i][j];
			if (itr == null) {
				res[k++] = c[i];
				break;
			}
			if (dp[i][j] != dp[itr.x][itr.y]) {
				res[k] = c[i];
				res[(maxLen - 1) - k] = c[i];
				k++;
			}
			i = itr.x;
			j = itr.y;
		}
		System.out.println(i + " , " + j);
		// res[k] = c[j];

		System.out.println(new String(res));
		return dp[0][len - 1];
	}

	public static long MaxHistogramRectArea(long[] hist) {
		if (hist == null || hist.length == 0) return 0;
		long maxArea = 0, area;
		int top = 0, idx = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(idx++);
		while (!s.isEmpty() || idx < hist.length) {
			while (idx < hist.length
					&& (s.isEmpty() || hist[idx] >= hist[s.peek()]))
				s.push(idx++);
			while (!s.isEmpty()
					&& (idx < hist.length && hist[idx] < hist[s.peek()])) {
				top = s.pop();
				if (s.isEmpty()) area = hist[top] * idx;
				else
					area = hist[top] * (idx - top);
				if (area > maxArea) maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// System.out.println(LongestPalindromicSubsequence("azdxyzza"));
		// System.out.println(MaxHistogramRectArea(new long[] { 2, 1, 2, 3, 1
		// }));
		System.out.println(waysMazeRD(4, 4));
		boolean t = true, f = false;
		boolean[][] m = new boolean[][] { { t, f, f, t, t, t },
				{ t, f, t, t, t, t }, { t, f, t, t, t, t },
				{ t, f, t, t, t, f }, { t, f, t, f, t, f } };
		int[] res = maxSquareMatrixOfOnes(m);
		System.out.println(Arrays.toString(res));

		ArrayList<cupoid> list = new ArrayList<>();
		cupoid a = new cupoid(4, 4, 4);
		cupoid b = new cupoid(1, 2, 3);

		list.add(a);
		list.add(b);
		System.out.println(maxStackCupoidHeight(list));
	}

}
