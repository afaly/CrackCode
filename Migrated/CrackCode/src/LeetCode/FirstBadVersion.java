package LeetCode;

public class FirstBadVersion {
	public static int val = 2;

	public boolean isBadVersion(int x) {
		return x >= val;
	}

	private int find(long l, long h) {
		if (h - l <= 1) return isBadVersion((int) l) ? (int) l : (int) h;
		int m = (int) (h + l) / 2;
		if (isBadVersion(m)) return find(l, m - 1);
		else return find(m + 1, h);
	}

	public int firstBadVersion(int n) {
		return find(1, n);
	}

	public static void main(String[] args) {
		FirstBadVersion f = new FirstBadVersion();
		System.out.println(f.firstBadVersion(4));
		
	}
}
