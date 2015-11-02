package dynamic;

import java.util.Arrays;
import java.util.HashSet;

public class MessageMess {

	private int size;
	private HashSet<String> set;
	private String s;
	private int K = 0;
	private int[] FINAL;

	public String restore(String[] dictionary, String message) {
		this.set = new HashSet<String>(Arrays.asList(dictionary));
		this.size = message.length();
		this.s = message;
		this.K = 0;
		int ret = restore(0, 0, new int[size], new int[size]);

		if (ret == 3) return "IMPOSSIBLE!";
		else if (ret == 2) return "AMBIGUOUS!";
		else {
			int mark = FINAL[0];
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(0));
			for (int i = 1; i < size; i++) {
				if (mark != FINAL[i]) {
					mark = FINAL[i];
					sb.append(" ");
				}
				sb.append(s.charAt(i));
			}
			return sb.toString();
		}
	}

	private int check(int[] f, int i, int j) {
		for (int k = i; k <= j; k++)
			if (f[k] > 1) return 2;
		return 0;
	}

	private int restore(int i, int j, int[] f, int[] t) {
		if (j == size - 1) {
			if (set.contains(s.substring(i, j + 1))) {
				for (int k = i; k <= j; k++) {
					f[k]++;
					t[k] = K;
				}
				K++;
				this.FINAL = t;
				return check(f, 0, size - 1);
			}
			return 3;
		}

		int x1 = restore(i, j + 1, f, t);
		if (set.contains(s.substring(i, j + 1)) && check(f, i, j) == 0) {
			int[] tt = Arrays.copyOf(t, size);
			for (int k = i; k <= j; k++) {
				f[k]++;
				tt[k] = K;
			}
			K++;
			int x2 = restore(j + 1, j + 1, f, tt);
			for (int k = i; k <= j; k++)
				f[k]--;
			return x2 != 2 ? Math.min(x1, x2) : 2;
		}
		return x1;
	}

	public static void main(String[] args) {
		MessageMess m = new MessageMess();
		System.out
				.println(m
						.restore(
								new String[] { "HI", "YOU", "SAY", "ABC",
										"BCD", "CD", "IMPOS", "IBLE", "S", "SS" },
								"HIYOUSAYHIHIYOUSAYHIHIYOUSAYHIHIABCBCDYOUSAYHIHIIMPOSSIBLEYOUIMPOSSIBLESAYHIHIIMPOSSIBLEYOUSAYHIHIYOUSAYHIHIYOUSAYHI"));
		System.out.println(m.restore(new String[] { "IMPOSS", "SIBLE", "S" },
				"IMPOSSIBLE"));
		System.out.println(m.restore(
				new String[] { "ABC", "BCD", "CD", "ABCB" }, "ABCBCD"));
		System.out.println(m.restore(new String[] { "IMPOSS", "SIBLE", "S",
				"IMPOSSIBLE" }, "IMPOSSIBLE"));
	}

}

