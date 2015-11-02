package ch_10;

import java.util.Arrays;
import java.util.Random;

public class Q01 {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {

		Random r1 = new Random(System.currentTimeMillis());
		Random r2 = new Random(System.currentTimeMillis() % 791827319);
		int na = 300, nb = 150;
		int[] a = new int[na], b = new int[nb];

		for (int i = 0; i < na; i++)
			a[i] = r1.nextInt(100);
		for (int i = 0; i < nb; i++)
			b[i] = r2.nextInt(100);
		
		Arrays.sort(a);
		Arrays.sort(b);
		a = Arrays.copyOf(a, na + nb);
		
		int i = (na + nb) - 1, j = nb - 1, k = na - 1;
		for (; i >= 0; i--)
			a[i] = j < 0 ? a[k] : k < 0 ? b[j] : b[j] > a[k] ? b[j--] : a[k--];

		System.out.println(Arrays.toString(a));
	}
}
