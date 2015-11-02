package ch_16;

public class Table {
	private int numOfPhy;
	private Chopstick[] ch;

	public Table(int numOfPhy) {
		this.numOfPhy = numOfPhy;
		this.ch = new Chopstick[numOfPhy];
		for (int i = 0; i < numOfPhy; i++)
			ch[i] = new Chopstick(i, (i + 1) % numOfPhy);
	}

	public void Status() {
		for (int i = 0; i < numOfPhy; i++)
			System.out.println(ch[i]);
	}

	public synchronized boolean Take(int i) {
		if (i < 0 || i > numOfPhy) return false;
		if (!ch[i].isUsed() && !ch[(i + 1) % numOfPhy].isUsed()) {
			
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {

	}

}
