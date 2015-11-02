package aofa;

import java.util.Arrays;

public class Fib implements Sequence {

	public static void main(String[] args) {}

	private double[] f;
	private int max, MAX;
	private final int THRESHHOLD = 10;

	public Fib(int MAX) {
		this.MAX = MAX + THRESHHOLD;
		this.f = new double[MAX];
		f[1] = 1;
		f[2] = 1;
		this.max = 2;
	}

	private void gen(int val) {
		if (val >= MAX) {
			MAX = val + THRESHHOLD;
			f = Arrays.copyOf(f, MAX);
		}
		for (int i = max + 1; i <= val; i++)
			f[i] = f[i - 1] + f[i - 2];
		max = val;
	}

	@Override
	public double eval(int N) {
		if (N < 0) return 0;
		if (N > max && N < 1e7) gen(N);
		return f[N];
	}
}
