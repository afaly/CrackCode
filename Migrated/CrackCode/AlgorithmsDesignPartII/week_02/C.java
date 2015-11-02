package week_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class C {

	public static BitSet fromString(final String s) {
		return BitSet.valueOf(new long[] { Long.parseLong(s, 2) });
	}

	public static String toString(BitSet bs) {
		return Long.toString(bs.toLongArray()[0], 2);
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data\\cluster\\clustering_big.txt");
		Scanner in = new Scanner(file);
		String[] s = in.nextLine().split("\\s+");
		int N = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		BitSet[] nodes = new BitSet[N];
		int[] cards = new int[N];
		for (int n = 0; n < N; n++) {
			nodes[n] = fromString(in.nextLine().replaceAll("\\s+", ""));
			cards[n] = nodes[n].cardinality();
		}
		System.out.println(Arrays.toString(cards));
		in.close();
	}
}
