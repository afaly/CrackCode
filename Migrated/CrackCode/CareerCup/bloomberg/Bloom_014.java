package bloomberg;

public class Bloom_014 {

	static class Node<T extends Comparable<? super T>> {
		Node<T> l, r;
		T v;

		public Node(T value) {
			this.v = value;
			this.l = null;
			this.r = null;
		}

		public Node(T value, Node<T> left, Node<T> right) {
			this.v = value;
			this.l = left;
			this.r = right;
		}

		@Override
		public String toString() {
			return "[" + v + "]";
		}
	}

	private static int OO = Integer.MAX_VALUE;

	public static <T extends Comparable<? super T>> boolean isBST(Node<T> n,
			T MIN, T MAX) {
		return n == null ? true : n.v.compareTo(MIN) >= 0
				&& n.v.compareTo(MAX) <= 0 && isBST(n.l, MIN, n.v)
				&& isBST(n.r, n.v, MAX);
	}

	public static <T extends Comparable<? super T>> int maxDepthBST(Node<T> n) {
		return n == null ? 0 : 1 + Math.max(maxDepthBST(n.l), maxDepthBST(n.r));
	}

	public static void main(String[] args) {
		Node<Integer> p = new Node<Integer>(40);
		p.l = new Node<Integer>(30);
		p.l.r = new Node<Integer>(35);
		p.l.r.l = new Node<Integer>(34); // 29
		p.l.r.r = new Node<Integer>(36); // 41
		p.l.r.r.r = new Node<Integer>(37); // 41
		p.r = new Node<Integer>(50);
		p.r.l = new Node<Integer>(45); // 39
		p.r.r = new Node<Integer>(55);
		p.r.l.r = new Node<Integer>(50); // 50
		p.r.r.r = new Node<Integer>(56);
		p.r.r.r.r = new Node<Integer>(56);
		p.r.r.r.r.r = new Node<Integer>(56);
		p.r.r.r.r.r.r = new Node<Integer>(57);

		System.out.println(isBST(p, -OO, OO));
		System.out.println(maxDepthBST(p));

	}
}
