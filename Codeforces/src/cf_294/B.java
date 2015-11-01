package cf_294;

import java.util.HashMap;
import java.util.Scanner;

public class B {

	private static HashMap<Long, Integer> m;

	public static void parse(String[] ss, int mode) {
		if (mode == 1) {
			for (String s : ss) {
				long key = Long.parseLong(s);
				if (!m.containsKey(key)) m.put(key, 1);
				else
					m.put(key, m.get(key) + 1);
			}
		} else if (mode == 2) {
			for (String s : ss) {
				long key = Long.parseLong(s);
				m.put(key, m.get(key) + 1);
			}
		} else {
			for (String s : ss) {
				Long key = Long.parseLong(s);
				m.put(key, m.get(key) + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = new HashMap<>();
		int N = Integer.parseInt(in.nextLine());
		parse(in.nextLine().split(" "), 1);
		parse(in.nextLine().split(" "), 2);
		parse(in.nextLine().split(" "), 3);

		int found = 0;
		for (Long key : m.keySet()) {
			int cnt = m.get(key);
			if (cnt % 3 == 2) {
				System.out.println(key);
				found++;
			}
			if (cnt % 3 == 1) {
				System.out.println(key);
				System.out.println(key);
				found += 2;
			}
			if (found == 2) break;
		}
		in.close();
	}
}
