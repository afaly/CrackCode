package bloomberg;

public class Bloom_006 {

	public static int Reverse(int x) {
		return reverse(0, x);
	}

	private static int reverse(int n, int x) {
		return x == 0 ? n : reverse((n * 10) + (x % 10), x / 10);
	}

	public static void main(String[] args) {
		System.out.println(Reverse(12333600));
	}

}
