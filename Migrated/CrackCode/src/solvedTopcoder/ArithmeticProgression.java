package solvedTopcoder;

public class ArithmeticProgression {
	public double minCommonDifference(int a0, int[] seq) {
		final int INFINITE = 10000000;
		int a[] = new int[seq.length + 1];
		a[0] = a0;
		for (int i = 1; i < a.length; i++) {
			a[i] = seq[i - 1];
		}
		Rationl lower = new Rationl(0, 1);
		Rationl upper = new Rationl(INFINITE, 1);
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) { return -1; }
			lower = Rationl.max(lower, new Rationl(a[i] - a[0], i));
			upper = Rationl.min(upper, new Rationl(a[i] - a[0] + 1, i));
			if (Rationl.compare(lower, upper) >= 0) { return -1; }
		}
		return (double) lower.numerator / lower.denominator;
	}
}

class Rationl {
	int numerator;
	int denominator;

	public Rationl(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	static int compare(Rationl r1, Rationl r2) {
		return r1.numerator * r2.denominator - r1.denominator * r2.numerator;
	}

	static Rationl max(Rationl r1, Rationl r2) {
		return (compare(r1, r2) > 0) ? r1 : r2;
	}

	static Rationl min(Rationl r1, Rationl r2) {
		return (compare(r1, r2) < 0) ? r1 : r2;
	}
}