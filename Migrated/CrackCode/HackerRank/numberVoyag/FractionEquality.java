package numberVoyag;

import java.io.FileWriter;
import java.io.IOException;

//(P-A)*(Q-A) = (P+B)*(Q+B)
//-A(P+Q) + AA = B(P+Q) + BB
//AA - BB = (P+Q)(A+B)
//P+Q = S
//S = (AA - BB)/(A+B)
//0 < A < S
//10010101
//11111117
//--------
//21121218
public class FractionEquality {

	public static Long valid(long A, long S) {
		long b = (S * S) - (4 * ((A * S) - (A * A)));
		if (b >= 0) {
			long sqrt = (long) Math.sqrt(b);
			if (sqrt * sqrt == b) {
				long B = (-S + sqrt);
				if ((B & 1) == 0) return B >> 1;
				else
					return null;
			}
			return null;
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		int P = 10010101, Q = 11111117, S = P + Q;
		FileWriter fw = new FileWriter("data/AB.txt");
		for (int A = 0; A < S; A++) {
			Long B = valid(A, S);
			if (B != null) fw.write(A + " " + B + "\n");
		}
	}

}
