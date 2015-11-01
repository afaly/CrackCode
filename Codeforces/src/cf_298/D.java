package cf_298;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class D {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[N];
		HashMap<Integer, Stack<Integer>> l = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(s[i]);
			n[v]++;
			if (!l.containsKey(v)) l.put(v, new Stack<Integer>());
			l.get(v).push(i + 1);
		}
		int iMax = N - 1;
		int avl = 0;
		boolean impossible = false;
		StringBuilder sb = new StringBuilder();
		while (iMax >= 0 && !impossible) {
			if (iMax >= avl) {
				if (n[avl] > 0) {
					n[avl]--;
					sb.append(l.get(avl).pop() + " ");
					avl++;
				} else {
					impossible = true;
				}
			} else if (iMax == avl) {
				n[avl]--;
				sb.append(l.get(avl).pop() + " ");
				avl++;
			} else {
				if (avl >= 3) avl -= 3;
				else
					impossible = true;
			}
			while (iMax >= 0)
				if (n[iMax] == 0) iMax--;
				else
					break;
		}
		if (impossible) {
			System.out.println("Impossible");
		} else {
			System.out.println("Possible");
			System.out.println(sb.toString().trim());
		}
		in.close();
	}
}
