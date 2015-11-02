package microsoft;

public class Micro_002 {

	public static int SQRT(int x) {
		for (int i = 1, j = i * i; j <= x; i++, j = i * i) {
			if (j == x) return i;
		}
		return -1;
	}

	public static void main(String[] args) {

		System.out.println(SQRT(100));
		System.out.println(SQRT(1024));
		System.out.println(SQRT(64));
		System.out.println(SQRT(65));
		System.out.println(SQRT(9));
		System.out.println(SQRT(1000000));

	}
}
