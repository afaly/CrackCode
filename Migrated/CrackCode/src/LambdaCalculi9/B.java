package LambdaCalculi9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = Integer.parseInt(in.nextLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean flag = false;
		while (Q-- > 0) {
			String[] s = in.nextLine().split(" ");
			HashSet<Integer> f = new HashSet<>();
			for (int i = 0; i < s.length; i += 2) {
				int pi = Integer.parseInt(s[i]);
				int ni = Integer.parseInt(s[i + 1]);
				f.add(pi);
				if (map.containsKey(pi))
					map.put(pi, Math.min(map.get(pi), ni));
				else {
					if (!flag) {
						map.put(pi, ni);
					}
				}
			}
			flag = true;
			for (Integer key : map.keySet()) {
				if (!f.contains(key))
					map.put(key, 0);
			}
		}

		Integer[] keys = map.keySet().toArray(new Integer[] {});
		Arrays.sort(keys);
		StringBuilder sb = new StringBuilder();
		for (Integer key : keys) {
			int x = map.get(key);
			if (x > 0)
				sb.append(key).append(" ").append(x).append(" ");
		}
		System.out.println(sb.toString().trim());
		in.close();
	}

}
