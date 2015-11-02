package numberVoyag;

import java.math.BigInteger;

public class LoveNine {

	public static void main(String[] args) {
		BigInteger N = new BigInteger("999999999999999999999");
		BigInteger NN = N.pow(2);
		BigInteger res = NN.add(N).divide(BigInteger.valueOf(2));
		System.out.println(res);
		System.out.println(res.divide(N).toString());
	}

}
