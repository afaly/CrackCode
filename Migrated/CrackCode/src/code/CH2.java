package code;

import java.util.Iterator;
import java.util.LinkedList;

class IntWrapper {
	int i;

	public IntWrapper(int i) {
		this.i = i;
	}
}

public class CH2 {

	static Object getKthLinkedList(LinkedList<Object> l, int k) {
		if (k >= l.size()) return null;
		Iterator<Object> it1 = l.iterator();
		Iterator<Object> it2 = l.iterator();
		for (int i = 0; i <= k; i++)
			it2.next();

		while (it2.hasNext()) {
			it2.next();
			it1.next();
		}
		return it1.next();
	}

	private static Object val = null;

	static Object getKthLinkedListRec(LinkedList<Object> l, int k) {
		val = null;
		getKthLinkedList(l.iterator(), k);
		return val;
	}

	static int getKthLinkedList(Iterator<Object> it, int k) {
		if (it.hasNext()) {
			Object temp = it.next();
			int c = getKthLinkedList(it, k);
			if (c == k) val = temp;
			return c + 1;
		} else return 0;
	}

	// Very Good Trick
	// Pass the value of the counter back thought using a pass by reference
	// By using a wrapper object or by using an array.

	// [1] Using Array as a reference holder.
	static Object getkthLinkedListRec(Iterator<Object> it, int k, int[] i) {
		if (it.hasNext()) {
			Object o = it.next();
			Object r = getkthLinkedListRec(it, k, i);
			if (i[0] == k) {
				i[0]++;
				return o;
			}
			i[0]++;
			return r;
		}
		return null;
	}

	// [2] Using an INT data type Class wrapper.
	static Object getkthLinkedListRec(Iterator<Object> it, int k, IntWrapper i) {
		if (it.hasNext()) {
			Object o = it.next();
			Object r = getkthLinkedListRec(it, k, i);
			if (i.i == k) {
				i.i++;
				return o;
			}
			i.i++;
			return r;
		}
		return null;
	}

	static boolean LinkedListPalindrome(LinkedList<Integer> l) {
		Iterator<Integer> it1 = l.iterator();
		Iterator<Integer> it2 = l.iterator();
		while (it2.hasNext()) {
			it1.next();
			it2.next();
			if (it2.hasNext()) it2.next();
		}
		return LinkeListPalindromeRec(l.iterator(), it1);
	}

	static boolean LinkeListPalindromeRec(Iterator<Integer> it1,
			Iterator<Integer> it2) {
		if (it2.hasNext()) {
			Integer I1 = it2.next();
			boolean f = LinkeListPalindromeRec(it1, it2);
			if (it1.next() == I1) return f;
			else return false;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i = 1; i <= 100; i++)
			l.add(i);
		// for (int i = 0; i <= l.size(); i++)
		// System.out.println("VAL : " + getKthLinkedListRec(l, i) + " : "
		// + getKthLinkedList(l, i) + " : "
		// + getkthLinkedListRec(l.iterator(), i, new IntWrapper(0)));
		for (int i = 101; i > 0; i--)
			l.add(i);

		System.out.println(LinkedListPalindrome(l));
	}
}
