package dynamic;

import java.util.Arrays;

public class MessageMessBuilder {

	public String restore(String[] dictionary, String message) {
		int len = message.length();
		int[] cnt = new int[len + 1];
		String[] res = new String[len + 1];
		Arrays.fill(res, "IMPOSSIBLE!");
		cnt[0] = 1;
		res[0] = "";
		for (int i = 0; i < len; i++) {
			if (cnt[i] == 1) {
				for (String word : dictionary) {
					int j = i + word.length();
					if (j <= len && word.equals(message.substring(i, j))) {
						cnt[j]++;
						if (cnt[j] == 2) res[j] = "AMPIGIOUS!";
						else if (cnt[j] == 1) res[j] = res[i] + " " + word;
					}
				}
			}
		}

		return res[len].trim();
	}

	public static void main(String[] args) {
		MessageMessBuilder m = new MessageMessBuilder();
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
