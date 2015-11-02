package dynamic;

import java.util.Arrays;
import java.util.HashMap;

public class MailArchiving {

	private static int[] box;

	public static int MailArchive(String[] s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>(s.length);
		int val = 0, idx = 0;
		box = new int[s.length];
		for (String str : s) {
			if (!map.containsKey(str)) map.put(str, val++);
			box[idx++] = map.get(str);
		}
		return MailArchive(0, s.length - 1, new boolean[s.length]);
	}

	private static boolean isSame(int i, int j) {
		int val = box[i];
		for (int k = i; k <= j; k++)
			if (box[k] != val) return false;
		return true;
	}

	private static int MailArchive(int i, int j, boolean[] f) {
		if (i == j || isSame(i, j)) return 1;
		int min = Integer.MAX_VALUE, val, x;
		for (int k = i; k <= j; k++) {
			boolean[] ff = Arrays.copyOf(f, f.length);
			val = box[k];
			for (x = k; x <= j; x++) {
				if (box[k] == val) ff[x] = true;
			}
			int v1 = MailArchive(i, k, ff);
			int v2 = MailArchive(x, j, ff);
			k = x - 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
