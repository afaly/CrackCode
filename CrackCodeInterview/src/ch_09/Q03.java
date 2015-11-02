package ch_09;

public class Q03 {

	public static int magicIndex(int[] a, int l, int h) {
		if (h < l) return -1;
		int m = (l + h) / 2;
		if (a[m] > m) return magicIndex(a, l, m - 1);
		else if (a[m] < m) return magicIndex(a, m + 1, h);
		else
			return m;
	}

	public static void main(String[] args) {
		
	}

}
