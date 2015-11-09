package cf_329;


public class C {

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}


}
