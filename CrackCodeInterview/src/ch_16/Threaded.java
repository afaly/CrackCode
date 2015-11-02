package ch_16;

import java.util.Random;

public class Threaded {

	static private Execute.Status[] status = { Execute.Status.OK,
			Execute.Status.ERR };

	static class ExecuteA implements Execute {
		private int count = 0;
		private Random r = new Random();

		@Override
		public synchronized Status execute(int workId, String workNm) {
			System.out.println("Worker (" + workId + " : " + workNm
					+ ")  CNT : " + ++count);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Exit Thread Execution!");
				return Status.ERR;
			}
			return status[Math.max(0, r.nextInt(10) - 8)];
		}

	}

	static class Worker implements Runnable {
		Execute ex;
		String name;
		int id;
		int count;

		public Worker(int id, String name, Execute ex) {
			this.id = id;
			this.name = name;
			this.ex = ex;
			this.count = 0;
		}

		@Override
		public void run() {
			Execute.Status stat = status[0];
			while (stat.value == 0)
				stat = ex.execute(id, name);

			System.out.println("*************  " + id + ""
					+ "  ***************");
		}
	}

	public static void main(String[] args) {
		System.out.println("START  : ------------- ");
		Execute exec = new ExecuteA();
		int len = 10;
		Thread[] t = new Thread[len];
		for (int i = 0; i < len; i++)
			t[i] = new Thread(new Worker(i, "#0" + i, exec));

		for (int i = 0; i < len; i++)
			t[i].start();

		System.out.println("END    : ------------- ");
	}
}
