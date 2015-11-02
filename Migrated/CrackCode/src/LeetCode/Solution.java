package LeetCode;

public class Solution {
	public static boolean isPalindrome(int a) {
		if (a < 0) return false;
		if (a < 10) return true;
		int h = 1, l = 1;
		while (h <= a / 10)
			h *= 10;
		boolean pal = true;
		while (pal && h > l) {
			pal = (a / h) % 10 == (a / l) % 10;
			h /= 10;
			l *= 10;
		}
		return pal;
	}

	public static int reverse(int a) {
		if (a < 10 && a > -10) return a;
		int h = 1, l = 1;
		long val = 0, src = Math.abs(a);
		while (h <= src / 10)
			h *= 10;
		for (; h >= 1; h /= 10, l *= 10) {
			val += ((src / h) % 10) * l;
		}
		if (a < 0) val *= -1;
		if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) return 0;
		return (int) val;
	}

	public static int trailingZeroes(int a) {
		int cnt = 0;
		for (int i = 5; i <= a; i += 5) {
			int j = i;
			while (j % 5 == 0) {
				cnt++;
				j /= 5;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// System.out.println(isPalindrome(2147447412));
		// System.out.println(reverse(2147447412));
		System.out.println(trailingZeroes(60));
	}
}
