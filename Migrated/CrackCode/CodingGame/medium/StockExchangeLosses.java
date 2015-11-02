package medium;

import java.util.Scanner;

public class StockExchangeLosses {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] vs = in.nextLine().split(" ");
		long pre = Long.parseLong(vs[0]), cur, dlt, maxLoss = 0, curLoss = 0, maxVal = pre;
		
		for (int i = 1; i < N; i++) {
			cur = Long.parseLong(vs[i]);
			dlt = cur - pre;
			
			if(dlt < 0){
			    if ((dlt - maxVal) < 0) { 
                    curLoss = cur - maxVal;
                    maxLoss = Math.min(maxLoss ,curLoss);
                }
			}else{
			    if(cur > maxVal){
			        maxVal = cur;
			        curLoss = 0;
			    }
			}
			
			
			curLoss += dlt;
			pre = cur;
		}
        System.out.println( (maxLoss<0)? maxLoss : 0);
		in.close();
	}
}
