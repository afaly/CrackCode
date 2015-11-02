package solvedTopcoder;
public class Multiples {
	public int number(int min, int max, int factor) {
		int minMultiple = min / factor * factor;
		if (minMultiple < min) {
			minMultiple += factor;
		}
		if (minMultiple > max) {
			return 0;
		}
		int maxMultiple = max / factor * factor;
		if (maxMultiple > max) {
			maxMultiple -= factor;
		}
		return (maxMultiple - minMultiple) / factor + 1;
	}
}
