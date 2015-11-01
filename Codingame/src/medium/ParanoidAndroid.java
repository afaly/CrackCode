package medium;

import java.util.Scanner;

public class ParanoidAndroid {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// int nbFloors = in.nextInt(); // number of floors
		// int width = in.nextInt(); // width of the area
		// int nbRounds = in.nextInt(); // maximum number of rounds
		int exitFloor = in.nextInt(); // floor on which the exit is found
		int exitPos = in.nextInt(); // position of the exit on its floor
		// int nbTotalClones = in.nextInt(); // number of generated clones
		// int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
		int nbElevators = in.nextInt(); // number of elevators
		int[] elvPos = new int[nbElevators];
		for (int i = 0; i < nbElevators; i++) {
			int elevatorFloor = in.nextInt(); // floor on which this elevator is
												// found
			int elevatorPos = in.nextInt(); // position of the elevator on its
											// floor
			elvPos[elevatorFloor] = elevatorPos;
		}

		// game loop
		while (true) {
			int cloneFloor = in.nextInt(); // floor of the leading clone
			int clonePos = in.nextInt(); // position of the leading clone on its
											// floor
			String direction = in.next(); // direction of the leading clone:
											// LEFT or RIGHT
			if (cloneFloor == -1 && clonePos == -1
					&& direction.equalsIgnoreCase("NONE")) {
				System.out.println("WAIT");
			} else {
				if (cloneFloor == exitFloor) {
					if (clonePos < exitPos
							&& direction.equalsIgnoreCase("LEFT")) {
						System.out.println("BLOCK");
					} else if (clonePos > exitPos
							&& direction.equalsIgnoreCase("RIGHT")) {
						System.out.println("BLOCK");
					} else System.out.println("WAIT");
				} else {
					if (clonePos < elvPos[cloneFloor]
							&& direction.equalsIgnoreCase("LEFT")) {
						System.out.println("BLOCK");
					} else if (clonePos > elvPos[cloneFloor]
							&& direction.equalsIgnoreCase("RIGHT")) {
						System.out.println("BLOCK");
					} else System.out.println("WAIT");
				}
			}
			in.close();
		}
	}
}
