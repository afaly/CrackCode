package week_01;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {
	final int id;
	final int w, l;

	public Job(int id, int w, int l) {
		this.id = id;
		this.w = w;
		this.l = l;
	}
}

public class A {

	public static final String urlStr = "http://spark-public.s3.amazonaws.com/algo2/datasets/jobs.txt";

	public static final Comparator<Job> CMP_1 = new Comparator<Job>() {

		@Override
		public int compare(Job i, Job j) {
			double si = i.w - i.l;
			double sj = j.w - j.l;
			return -(si > sj ? 1 : si < sj ? -1 : i.w > j.w ? 1 : -1);
		}
	};

	public static final Comparator<Job> CMP_2 = new Comparator<Job>() {

		@Override
		public int compare(Job i, Job j) {
			double si = i.w * 1.0 / i.l;
			double sj = j.w * 1.0 / j.l;
			return -(si > sj ? 1 : si < sj ? -1 : i.w > j.w ? 1 : -1);
		}
	};

	public static long totalCompletionTime(Job[] jobs, int N) {
		long totalCompletion = 0, totalLen = 0;
		for (int i = 0; i < N; i++) {
			Job j = jobs[i];
			totalLen += j.l;
			totalCompletion += j.w * totalLen;
		}
		return totalCompletion;
	}

	public static void main(String[] args) throws IOException {
		URL url = new URL(urlStr);
		Scanner in = new Scanner(url.openStream());
		int N = Integer.parseInt(in.nextLine());
		Job[] jobs = new Job[N];
		for (int i = 0; i < N; i++) {
			String[] s = in.nextLine().split("\\s+");
			int w = Integer.parseInt(s[0]);
			int l = Integer.parseInt(s[1]);
			jobs[i] = new Job(i, w, l);
		}

		Arrays.sort(jobs, CMP_1);
		System.out.println("{w - l}  : " + totalCompletionTime(jobs, N));

		Arrays.sort(jobs, CMP_2);
		System.out.println("{w / l}  : " + totalCompletionTime(jobs, N));
		in.close();

	}
}
