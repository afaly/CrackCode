package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountingStable {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		HashMap<Integer, ArrayList<String>> l = new HashMap<Integer, ArrayList<String>>(
				100);
		for (int i = 0; i < N; i++) {
			String[] s = in.nextLine().split("\\s+");
			if (!l.containsKey(I(s[0]))) l.put(I(s[0]), new ArrayList<String>());
			l.get(I(s[0])).add(i < N / 2 ? "-" : s[1]);
		}
		StringBuilder sb = new StringBuilder();
		for (Integer key : l.keySet()) {
			for (String s : l.get(key))
				sb.append(s).append(" ");
		}
		System.out.println(sb.toString().trim());
		in.close();

	}

}
