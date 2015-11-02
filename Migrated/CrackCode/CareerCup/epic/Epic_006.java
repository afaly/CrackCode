package epic;

import java.util.HashSet;

public class Epic_006 {

	public static HashSet<Long> set;
	private static int[] n;
	private static int N;

	public static boolean Color(int[] array) {
		n = array;
		N = array.length;
		set = new HashSet<Long>();
		return color(1, 0);
	}

	private static boolean color(long v, int i) {
		if (i == N) {
			if (set.contains(v)) return false;
			set.add(v);
			return true;
		}
		return n[i] != 1 && color(v, i + 1) && color(v * n[i], i + 1);
	}

	public static void main(String[] args) {
		System.out.println(Color(new int[] { 2, 4, 6 }));
	}

}
