package greedy;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class TeamFormation {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static PriorityQueue<Integer> I(String[] s) {
		PriorityQueue<Integer> n = new PriorityQueue<Integer>(I(s[0]));
		for (int i = 0; i < I(s[0]); i++)
			n.offer(I(s[i + 1]));
		return n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			PriorityQueue<Integer> n = I(in.nextLine().trim().split("\\s+"));
			Stack<Integer> m = new Stack<Integer>();
			int smallest = Integer.MAX_VALUE;
			if (!n.isEmpty()) {
				while (!n.isEmpty()) {
					int cnt = 1, pre = n.poll();
					while (!n.isEmpty()) {
						if (n.peek() - pre == 1) {
							pre = n.poll();
							cnt++;
						} else if (n.peek() - pre == 0) {
							m.push(n.poll());
						} else {
							while (!m.isEmpty())
								n.offer(m.pop());
							break;
						}
					}
					while (!m.isEmpty())
						n.offer(m.pop());
					if (cnt < smallest) smallest = cnt;
				}
				System.out.println(smallest);
			} else
				System.out.println(0);
		}
		in.close();
	}
}
