package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import dynamic.LaserArchitect;
import static org.junit.Assert.assertEquals;

public class UlaserArchitect {

	@Test(timeout = 1300)
	public void testCase0() throws IOException {
		Scanner in = new Scanner(new File("data/laser_architect.input"));
		Scanner sol = new Scanner(new File("data/laser_architect.sol"));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int nn = in.nextInt();
			int mm = in.nextInt();
			int[] x = new int[nn];
			int[] y = new int[nn];
			for (int i = 0; i < nn; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			int val = LaserArchitect.Shoot(nn, mm, x, y);
			sol.nextLine();
			int solv = Integer.parseInt(sol.nextLine());
			if (sol.hasNextLine()) sol.nextLine();
			assertEquals("Didn't get the correct Solution", solv, val);
		}

		in.close();
		sol.close();
	}

	@Test(timeout = 1000)
	public void testCase1() throws IOException {
		Scanner in = new Scanner(new File("data/laser_architect_0.input"));
		Scanner sol = new Scanner(new File("data/laser_architect_0.sol"));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int nn = in.nextInt();
			int mm = in.nextInt();
			int[] x = new int[nn];
			int[] y = new int[nn];
			for (int i = 0; i < nn; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			int val = LaserArchitect.Shoot(nn, mm, x, y);
			sol.nextLine();
			int solv = Integer.parseInt(sol.nextLine());
			if (sol.hasNextLine()) sol.nextLine();
			assertEquals("Didn't get the correct Solution", solv, val);
		}

		in.close();
		sol.close();
	}
}
