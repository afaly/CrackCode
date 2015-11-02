package ch_16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	private ReentrantLock lock;
	private int pre, nxt;

	public Chopstick(int pre, int nxt) {
		this.lock = new ReentrantLock();
		this.pre = pre;
		this.nxt = nxt;
	}

	public boolean tryTake() {
		return this.lock.tryLock();
	}

	public boolean tryTake(long timeOut) {
		try {
			return this.lock.tryLock(timeOut, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void take() {
		this.lock.lock();
	}

	public void leave() {
		this.lock.unlock();
	}

	public synchronized boolean isUsed() {
		return this.lock.isLocked();
	}

	public synchronized boolean isUsedByPhy() {
		return this.lock.isHeldByCurrentThread();
	}

	@Override
	public String toString() {
		return "Chopstick (" + pre + "," + nxt + ")  : Used [" + isUsed()
				+ "].";
	}

}
