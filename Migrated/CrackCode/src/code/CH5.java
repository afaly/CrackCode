package code;

import java.util.Arrays;

public class CH5 {

	static void print10(int n) {
		System.out.println(n + " : " + Integer.toBinaryString(n));
	}

	static int Insert_1(int n, int t, int i, int j) {
		int mask = (~0 << (j + 1)) | (((1 << i) - 1));
		return (n & mask) ^ (t << i);
	}

	static int Insert_2(int n, int m, int i, int j) {
		int mask = ~(((1 << (j + 1)) - 1) ^ ((1 << i) - 1));
		return (((mask) & n) ^ (m << i));
	}

	static String doubleToBin(double d) {
		if (d <= 0 || d >= 1) return "ERROR";
		StringBuilder sb = new StringBuilder(".");
		while (d > 0) {
			// if (sb.length() > 32) return "ERROR";
			d *= 2;
			if (d >= 1) {
				d--;
				sb.append('1');
			} else sb.append('0');
		}
		return sb.toString();
	}

	// TODO: REVISE.
	static int[] getMinMax(int n) {
		if (n <= 0) return null;
		// GET THE MAX:
		// -------------
		boolean found = false, streak = false;
		int[] val = new int[3], ret = new int[2];
		int mask = 1, i = 0, nMin = n, nMax = n, m = 0;
		while (!found) {
			if ((n & mask) == 0) {
				if (streak) {
					val[2] = i;
					found = true;
				} else val[0]++;
			} else {
				val[1]++;
				streak = true;
			}
			mask <<= 1;
			i++;
		}
		val[1]--;
		System.out.println(Arrays.toString(val));

		nMax |= (1 << val[2]);
		nMax &= ~((1 << val[2]) - 1);
		while (val[1]-- > 0) {
			m <<= 1;
			m++;
		}
		nMax ^= m;

		found = false;
		streak = false;
		val = new int[3];
		mask = 1;
		i = 0;
		m = 0;

		while (!found) {
			if ((n & mask) != 0) {
				if (streak) {
					val[2] = i;
					found = true;
				} else val[1]++;
			} else {
				val[0]++;
				streak = true;
			}
			mask <<= 1;
			i++;
		}
		val[1]++;

		System.out.println(Arrays.toString(val));

		nMin ^= (1 << val[2]);
		nMin &= ~((1 << val[2]) - 1);
		while (val[1]-- > 0) {
			m <<= 1;
			m++;
		}
		nMin ^= (m << --val[0]);

		ret[1] = nMax;
		ret[0] = nMin;
		return ret;
	}

	static void print(Object... v) {
		for (Object o : v)
			System.out.print(o.toString() + "  \n");
	}

	// TODO: NICE TRICK.
	static int numAtoB(int A, int B) {
		int n = 0;
		for (int c = A ^ B; c != 0; c &= (c - 1))
			n++;
		return n;
	}

	// TODO: NOCE TRICK.
	static int Swap(int n) {
		return ((0x55555555 & n) << 1) ^ ((n >> 1) & 0x55555555);
	}

	// TODO: TRICKY.
	static byte[] drawHLine(byte[] screen, int width, int x1, int x2, int y) {
		int w = width >> 3;
		int yy = y * w;
		int b1 = yy + (x1 >> 3);
		int b2 = yy + (x2 >> 3);
		int p1 = x1 & 7;
		int p2 = x2 & 7;
		System.out.printf("%d  %d (%d : %d) --> (%d : %d)\n", w, yy, b1, p1,
				b2, p2);

		int i = 0, j = b1 == b2 ? 7 - p2 : 0;
		// Process First BLOCK:
		for (i = 7 - p1; i >= j; i--)
			screen[b1] |= (1 << i);
		System.out.printf("B1 : %02x \n", screen[b1]);

		// Fill the middle:
		for (i = b1 + 1; i < b2; i++)
			screen[i] |= 0xff;

		// Process Last BLOCK:
		for (i = 7; i >= 7 - p2 && b1 != b2; i--)
			screen[b2] |= (1 << i);
		System.out.printf("B2 : %02x \n", screen[b2]);

		for (i = 0; i < screen.length; i++) {
			if (i > 0 && i % w == 0) System.out.println();
			System.out.printf("%02x ", screen[i]);
		}
		return screen;
	}

	static int Negate(int n) {
		return ~(n + (-1));
	}

	static int Add(int a, int b) {
		return a + b;
	}

	static int Subtract(int a, int b) {
		return a + Negate(b);
	}

	static int multiply(int a, int b) {
		if (b == 0) return 0;
		if (b > a) return multiply(b, a);
		return (b & 1) == 1 ? a + multiply(a + a, b >> 1) : multiply(a + a,
				b >> 1);
	}

	static int Multiply(int a, int b) {
		if (a >= 0 && b >= 0) return multiply(a, b);
		else if (a < 0 && b < 0) return multiply(Negate(a), Negate(b));
		else if (a < 0) return Negate(multiply(Negate(a), b));
		else return Negate(multiply(a, Negate(b)));
	}

	static int divide(int a, int b, int v) {
		if (b > a) return 0;
		if (b == a) return 1;
		return 1 + divide(a, b + v, v);
	}

	static int Divide(int a, int b) {
		if (a >= 0 && b >= 0) return divide(a, b, b);
		else if (a < 0 && b < 0) return divide(Negate(a), Negate(b), Negate(b));
		else if (a < 0) return Negate(divide(Negate(a), b, b));
		else return Negate(divide(a, Negate(b), Negate(b)));
	}

	static int Kth(int k) {
		int[] p = { 3, 5, 7 };
		if (k < 3 && k >= 0) return p[k];
		int val = 1;
		for (int i = 0; i <= k; i++) {
			val *= p[i % 3];
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Insert_1(32, 13, 0, 3))
				+ " : " + Integer.toBinaryString(Insert_2(32, 13, 0, 3)));
		System.out.println("--------------------");
		System.out.println(Integer.toBinaryString(Insert_1(2048 - 1, 19, 2, 6))
				+ " : " + Integer.toBinaryString(Insert_2(2048 - 1, 19, 2, 6)));
		System.out.println(doubleToBin(0.5));

		getMinMax(12);
		int A = 12, B = 11;
		print10(A);
		print10(B);
		System.out.println(numAtoB(12, 11));
		print10(17);
		print10(Swap(17));

		// drawHLine(new byte[8 * 8], 64, 8, 11, 3);
		System.out.println(Multiply(10, 10));
		System.out.println(Divide(-10, -10));
		System.out.println(Divide(7, -2));
		System.out.println(Divide(-6, 2));
		System.out.println(Divide(3, 10));
		System.out.println("---------------------------");
		for (int i = 0; i < 10; i++)
			System.out.println(Kth(i));

	}
}
