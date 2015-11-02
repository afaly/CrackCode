package euler;

import java.util.Arrays;
import java.util.Scanner;

public class Euler_022 {

	public static long score(String name, int pos) {
		long val = 0l;
		for (int i = 0; i < name.length(); i++)
			val += ((name.charAt(i) - 'A') + 1);
		return val * pos;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] names = new String[N];
		for (int i = 0; i < N; i++)
			names[i] = in.nextLine();

		Arrays.sort(names);

		int Q = Integer.parseInt(in.nextLine());
		while (Q-- > 0) {
			String query = in.nextLine();
			int pos = Arrays.binarySearch(names, query);
			System.out.println(score(query, pos + 1));
		}
		in.close();
	}
}
