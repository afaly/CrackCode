package microsoft;

public class Micro_004 {

	public static String GenerateLowestNumber(String s, int n) {
		char[] x = s.toCharArray();
		int cnt = n, p = 0, idx = -1;
		StringBuilder sb = new StringBuilder();
		while (cnt >= 0) {
			int cur = 10;
			for (int i = 0; i < cnt && p + i < s.length(); i++) {
				if (x[p + i] - '0' < cur) {
					cur = x[p + i] - '0';
					idx = p + i;
				}
			}
			sb.append(x[idx]);
			cnt -= (idx - p);
			p = idx + 1;
		}
		for (int i = idx + 1; i < s.length(); i++)
			sb.append(x[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(GenerateLowestNumber("4205123", 4));
	}

}
