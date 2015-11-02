package aofa;

import java.util.Arrays;

public class QuickSeq implements Sequence {

	public static void main(String[] args) {}

	private double[] f;
	private int max, MAX;
	private final int THRESHHOLD = 10;

	public QuickSeq(int MAX) {
		this.MAX = MAX + THRESHHOLD;
		f = new double[MAX];
	}

	private void gen(int MAXN) {
		if (MAXN >= MAX) {
			MAX = MAXN + THRESHHOLD;
			f = Arrays.copyOf(f, MAX);
		}
		for (int N = max + 1; N <= MAXN; N++)
			f[N] = (N + 1) * f[N - 1] / N + 2;
		max = MAXN;
	}

	@Override
	public double eval(int N) {
		if (N < 0) return 0;
		if (N > max && N < 1e7) gen(N);
		return f[N];
	}

}
