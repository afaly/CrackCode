package arrays;

import java.util.List;

public class Solution {
	// DO NOT MODFIY THE LIST.
	public static int maxSubArray(final List<Integer> a) {
		int sum = 0, idx = -1, v, maxSum = 0;
		boolean flag = false;
		for (int i = 0; i < a.size(); i++) {
			v = a.get(i);

			if (v < 0) flag = true;
			else idx = idx == -1 && flag ? i : idx;

			if (sum + v > 0) sum += v;
			else {
				if (idx == -1) return maxSum;
				else {
					sum = a.get(idx);
					i = idx;
					idx = -1;
				}
			}
			if (sum > maxSum) maxSum = sum;
		}
		return maxSum;
	}

	public static void main(String[] args) {
	}
}
