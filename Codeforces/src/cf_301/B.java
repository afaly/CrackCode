package cf_301;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static int Int(String s) {
		return Integer.parseInt(s);
	}

	class median {
		private PriorityQueue<Integer> min, max;
		private int N;

		public median(int n) {
			this.N = n;
			this.min = new PriorityQueue<>((N + 1) / 2);
			this.max = new PriorityQueue<>((N + 1) / 2,
					new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							return -o1.compareTo(o2);
						}

					});
		}

		public void add(int val) {
			if (max.isEmpty()) max.offer(val);
			else if (min.isEmpty()) min.offer(val);
			else if (val < max.peek()) max.offer(val);
			else if (val > min.peek()) min.offer(val);

			if (!min.isEmpty() && !max.isEmpty()) {
				if (min.size() - max.size() >= 2) max.offer(min.poll());
				else if (max.size() - min.size() >= 2) min.offer(max.poll());
			}
		}

		public int peek() {
			if (min.size() > max.size()) return min.peek();
			else if (max.size() > min.size()) return max.peek();
			else
				return min.peek();
		}

		public int poll() {
			if (min.size() > max.size()) return min.poll();
			else if (max.size() > min.size()) return max.poll();
			else
				return min.poll();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int n = Int(s[0]), k = Int(s[1]), p = Int(s[2]), x = Int(s[3]), y = Int(s[4]), sum = 0;

		if (y > p) {
			System.out.println("-1");
		} else {
			s = in.nextLine().split("\\s+");
			int[] v = new int[k];
			int less = 0, more = 0;
			for (int i = 0; i < k; i++) {
				v[i] = Int(s[i]);
				sum += v[i];
				if (v[i] < y) less++;
				else
					more++;
			}
			boolean valid = true;
			ArrayList<Integer> res = new ArrayList<Integer>();
			while (k < n && sum < x && valid) {
				if (more <= less) {
					if ((sum + y) <= x) {
						sum += y;
						more++;
						res.add(y);
					} else
						valid = false;
				} else {
					sum += 1;
					less++;
					res.add(1);
				}
				k++;
			}

			if (valid && k == n && more > less) {
				StringBuilder sb = new StringBuilder();
				for (Integer value : res)
					sb.append(value).append(" ");
				System.out.println(sb.toString().trim());
			} else {
				System.out.println("-1");
			}
		}

		in.close();
	}
}
