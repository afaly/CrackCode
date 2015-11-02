package bloomberg;

public class Bloom_010 {

	public static char[] removeChar(char[] a, char c) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != c) a[j++] = a[i];
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(new String(removeChar(
				",,abcd,efg,t,h,y,u,j,u,t,f,f,,".toCharArray(), ',')));
	}

}
