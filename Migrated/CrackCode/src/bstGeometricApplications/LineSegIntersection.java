package bstGeometricApplications;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

class Point implements Comparable<Point> {
	long x, y;
	long yy;
	boolean last, ver;
	int lineId;

	public Point(long x, long y, int lid, boolean last, boolean ver) {
		this.x = x;
		this.y = y;
		this.lineId = lid;
		this.last = last;
		this.ver = ver;
	}

	public void setYVertical(long yy) {
		this.yy = yy;
	}

	public boolean isVertical() {
		return ver;
	}

	public boolean isLast() {
		return last;
	}

	@Override
	public int compareTo(Point o) {
		int cmp = ((Long) x).compareTo(o.x);
		if (cmp == 0) cmp = ((Long) y).compareTo(o.y);
		return cmp;
	}

	@Override
	public String toString() {
		return String.format("X: %d , Y: %d , YY: %d , Line: %d", x, y, yy,
				lineId);
	}
}

class lng implements Comparable<lng> {
	long v;
	int id;

	public lng(long x, int id) {
		this.v = x;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (int) (v ^ (v >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		lng other = (lng) obj;
		if (id != other.id) return false;
		if (v != other.v) return false;
		return true;
	}

	@Override
	public int compareTo(lng o) {
		return ((Long) v).compareTo(o.v);
	}

	@Override
	public String toString() {
		return "Value : " + v + " , Line ID: " + id;
	}

}

class Line implements Comparable<Line> {

	private Point a, b;

	private boolean ver;

	public boolean isVertical() {
		return ver;
	}

	public Line(long x1, long y1, long x2, long y2) {
		this.ver = x1 == x2;
	}

	@Override
	public int compareTo(Line o) {
		int cmp = ((Long) a.x).compareTo(o.a.x);
		if (cmp == 0) cmp = ((Long) b.x).compareTo(o.b.x);
		if (cmp == 0) cmp = ((Long) a.y).compareTo(o.a.y);
		if (cmp == 0) cmp = ((Long) b.y).compareTo(o.b.y);
		return cmp;
	}
}

public class LineSegIntersection {

	private ArrayList<Point> ls;
	private TreeSet<lng> tree;

	public LineSegIntersection(long[][] lines) {
		this.ls = new ArrayList<Point>();
		int lid = 0;
		boolean ver = false;
		for (long[] line : lines) {
			ver = line[0] == line[2];
			if (!ver) {
				ls.add(new Point(line[0], line[1], lid, false, false));
				ls.add(new Point(line[2], line[3], lid++, true, false));
			} else {
				Point p = new Point(line[0], line[1], lid, false, true);
				p.setYVertical(line[3]);
				ls.add(p);
			}
		}
		Collections.sort(ls);
		for (Point p : ls)
			System.out.println(p);
		this.tree = new TreeSet<>();
	}

	public void solve() {
		for (Point p : ls) {
			if (p.isVertical()) {
				Iterator<lng> itr = tree.subSet(new lng(p.y, 0), true,
						new lng(p.yy, 0), true).iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				if (p.isLast()) {
					tree.remove(new lng(p.y, p.lineId));
				} else {
					tree.add(new lng(p.y, p.lineId));
				}
			}
		}
	}

	public static void main(String[] args) throws ParseException {
		long[][] pts = { { 1, 2, 5, 2 }, { 3, 4, 6, 4 }, { 5, 3, 7, 3 },
				{ 4, 1, 4, 5 } };

		LineSegIntersection seg = new LineSegIntersection(pts);
		seg.solve();
		DateFormat df = new SimpleDateFormat("dd-MMM-yy");
		Date res = df.parse("21-NOV-12");
		System.out.println(res);
	}

}
