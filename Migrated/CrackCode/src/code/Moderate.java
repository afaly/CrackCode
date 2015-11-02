package code;

public class Moderate {

	static int max(int x, int y) {
		return (int) ((x + y) / 2.0 + Math.abs((x - y) / 2.0));
	}

	static int min(int x, int y) {
		return (int) ((x + y) / 2.0 - Math.abs((x - y) / 2.0));
	}

	// There is a stair case with n steps.
	// U may take 1 step or 2 steps at a time to climb it.
	// Write a Java method to find total number of combinations to climb the
	// stair case.
	//
	//
	// Solution:
	//
	// If there is only 1 step in the stair case: total ways of climbing = 1
	// i.e, f(1) = 1
	// If there are 2 steps in the stair case: total ways of climbing = 2 (2
	// steps at a time, 2 times 1 step) i.e, f(2) = 2
	//
	// If there are n steps:
	// Formula: f(n) = f(n-1) + f(n-2)
	//
	// EG: If there are 3 steps: f(3) = f(2) + f(1)
	// = 2+1 = 3 ways (which are 2+1, 1+2, 1+1+1)
	// If there are 4 steps: f(4) = f(3) + f(2)
	// = 3+2 = 5 ways (which are 2+2, 2+1+1, 1+2+1, 1+1+2, 1+1+1+1)
	// If there are 10 steps: f(10) = f(9) + f(8)
	// = 89

	private static int[] fmem;

	public static int StairsRec(int n) {
		fmem = new int[n + 1];
		fmem[1] = 1;
		fmem[2] = 2;
		return stairs(n);
	}

	private static int stairs(int n) {
		if (n > 0 && fmem[n] > 0) return fmem[n];
		fmem[n] = stairs(n - 1) + stairs(n - 2);
		return fmem[n];
	}

	public static int StairsItr(int n) {
		if (n <= 2) return Math.max(0, n);
		int f1 = 1, f2 = 2, f0 = f1 + f2;
		for (int i = 3; i <= n; i++) {
			f0 = f2 + f1;
			f1 = f2;
			f2 = f0;
		}
		return f0;
	}

	// How can four employees calculate the average of their salaries without
	// knowing other's salary?
	//
	// Lets name these employees A, B, C and D
	//
	// 1. A chooses any random value and whispers it to B privately
	// 2. B chooses any random value and whispers it to C privately
	// 3. C chooses any random value and whispers it to D privately
	// 4. D chooses any random value and whispers to to A privately
	//
	// So each employee has two numbers now - incoming and outgoing. Each
	// employee should get own salary, then add the incoming and subtract the
	// outgoing and report the result. Then they should add all reports and
	// divide by 4.
	//
	// Let us suppose that A, B, C and D each have 2000 Salary and A, B, C, D
	// choose random number 1,2,3 and 4 respectively.
	// so A=4+2000-1
	// B=1+2000-2
	// C=2+2000-3
	// D=3+2000-4
	// So, add A+B+C+D/4=2000 average Salary

	/** if(c == 0) then a >= b else if(c == 1) then a < b; **/
	public static int Max(int a, int b) {
		int c = ((a - b) >> 31) & 1;
		return a - c * (a - b);
	}

	public static void SwapXOR(int[] vals) {
		vals[0] ^= vals[1];
		vals[1] ^= vals[0];
		vals[0] ^= vals[1];
	}

	public static void SwapADD(int[] vals) {
		vals[0] = vals[0] + vals[1];
		vals[1] = vals[0] - vals[1];
		vals[0] = vals[0] - vals[1];
	}

	private static int[] mem;
	private static double LOG5 = Math.log10(5);

	public static int TrailFac0I(int n) {
		int cnt = 0;
		for (int i = 5; i <= n; i += 5) {
			int j = i;
			while (j % 5 == 0) {
				j /= 5;
				cnt++;
			}
		}
		return cnt;
	}

	public static int log5(int n) {
		return (int) Math.round((Math.log10(n) / LOG5));
	}

	public static int TrailFac0R(int n) {
		if (mem == null) mem = new int[1000000];
		return trailfac(n);
	}

	private static int trailfac(int n) {
		if (n < 5 || n > mem.length) return 0;
		if (mem[n] > 0) return mem[n];
		int cnt = 0, j = n;
		while (j % 5 == 0) {
			cnt++;
			j /= 5;
		}
		mem[n] = cnt + trailfac(n - 1);
		return mem[n];
	}

	public static void main(String[] args) {

		System.out.println(max(10, 11));
		System.out.println(StairsItr(3));
		System.out.println(StairsItr(4));
		System.out.println(StairsItr(10));
	}

}
