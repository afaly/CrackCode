package aofa;

import javax.swing.UIManager;

import edu.princeton.cs.introcs.StdDraw;

public class Values {

	public static void show(Sequence seq, int MaxN) {
		double max = Double.MIN_VALUE, val = 0;
		for (int N = 0; N < MaxN; N++) {
			val = seq.eval(N);
			if (val > max) max = val;
		}
		StdDraw.setPenColor(250, 50, 50);
		StdDraw.show(10);
		for (int N = 0; N < MaxN; N++) {
			double x = 1.0 * N / MaxN;
			double y = 1.0 * seq.eval(N) / max;
			StdDraw.filledSquare(x, y, 0.005);
			StdDraw.show(10);
		}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		int MAX = 1000;
		QuickSeq seq = new QuickSeq(MAX);
//		Fib fib = new Fib(MAX);
		show(seq, MAX);
	}

}
