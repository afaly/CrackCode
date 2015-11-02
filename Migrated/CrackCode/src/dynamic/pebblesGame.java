package dynamic;

import static java.lang.Math.min;

import java.util.Arrays;
import java.util.BitSet;

public class pebblesGame {

	private static int[] mem;
	private static int bits;

	static String print10(int n) {
		return (n + " : " + Integer.toBinaryString(n));
	}

	public static void Init(int size) {
		if (bits <= 20) {
			bits = size;
			mem = new int[1 << (bits + 1)];
			Arrays.fill(mem, -1);
		}
	}

	public static int Reduce(int game) {
		if (game > ((1 << bits) - 1)) return -1;
		return reduce(game);
	}

	private static int reduce(int g) {
		if (g == 0) return g;
		if ((g & (g - 1)) == 0) return 1;
		if (mem[g] != -1) return mem[g];
		int ret = BitSet.valueOf(new long[] { g }).cardinality();
		for (int i = 0; i < bits; i++) {
			if (((g >> i) & 1) == 0) {
				if (((g >> (i - 2)) & 3) == 3) ret = min(ret, reduce(g
						^ (7 << (i - 2))));
				if (((g >> (i + 1)) & 3) == 3) ret = min(ret, reduce(g
						^ (7 << i)));
			}
		}
		mem[g] = ret;
		return ret;
	}

	public static void main(String[] args) {
		Init(12);
		int n = (1 << 12) + 7;
		System.out.println(print10(n));
		System.out.println(reduce(n));
	}

}
