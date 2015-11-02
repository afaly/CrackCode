package ch_16;

public class Philosopher extends Thread {

	private long id;
	private long bites = 10;
	private Chopstick left, right;

	public Philosopher(long id, Chopstick left, Chopstick right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		for (int i = 0; i < bites; i++) {
			eat(i + 1);
			think();
		}
	}

	public void eat(int bite) {
		System.out.println("PHY [" + id + "]  TRY EAT BITE #" + bite + " ...");
		while (left.isUsed() || right.isUsed())
			think();
		left.take();
		right.take();
		System.out.println("PHY [" + id + "]  EATTING BITE #" + bite + " ...");
		chew();
		left.leave();
		right.leave();
		System.out.println("PHY [" + id + "]  DONE    BITE #" + bite + " ...");
	}

	public void chew() {
		// System.out.println("PHY [" + id + "]  EATING  ...");
		try {
			sleep(2000);
		} catch (InterruptedException e) {} finally {}
	}

	public void think() {
		// System.out.println("PHY [" + id + "]  THINKING...");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("PHY [" + id + "]");
		}
	}

	@Override
	public String toString() {
		return "Phylosipher [" + id + "]   Eating ?  "
				+ (left.isUsedByPhy() && right.isUsedByPhy());
	}

	public static void main(String[] args) {
		int numOfPhy = 6;

		Chopstick[] ch = new Chopstick[numOfPhy];
		for (int i = 0; i < numOfPhy; i++)
			ch[i] = new Chopstick(i, (i + 1) % numOfPhy);
		for (int i = 0; i < numOfPhy; i++)
			System.out.println(ch[i]);

		Philosopher[] phy = new Philosopher[numOfPhy];
		for (int i = 0; i < numOfPhy; i++)
			phy[i] = new Philosopher(i, ch[i], ch[(i + 1) % numOfPhy]);

		for (int i = 0; i < numOfPhy; i++)
			phy[i].start();

	}
}
