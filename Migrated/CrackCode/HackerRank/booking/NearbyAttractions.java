package booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class NearbyAttractions {

	public static final double PI = 3.14159265359, EARTH_RADIUS = 6371,
			EPS = 1e-7;
	public static HashMap<String, Double> S;

	public static double toRad(double val) {
		return (val / 180) * PI;
	}

	public static double toDeg(double val) {
		return (val / PI) * 180;
	}

	static class P {
		int id;
		double lat, lng, slat, clat;

		public P(int Id, double latitude, double longtiude) {
			id = Id;
			lat = toRad(latitude);
			lng = toRad(longtiude);
			slat = Math.sin(lat);
			clat = Math.cos(lat);
		}

		public P(String str) {
			String[] s = str.split("\\s+");
			id = Integer.parseInt(s[0]);
			lat = toRad(Double.parseDouble(s[1]));
			lng = toRad(Double.parseDouble(s[2]));
			slat = Math.sin(lat);
			clat = Math.cos(lat);
		}

		/*-
		function distance_between(point1, point2) {
		    var EARTH_RADIUS = 6371;//in km
		    var point1_lat_in_radians  = degree2radians( point1.latitude );
		    var point2_lat_in_radians  = degree2radians( point2.latitude );
		    var point1_long_in_radians  = degree2radians( point1.longitude );
		    var point2_long_in_radians  = degree2radians( point2.longitude );

		    return acos( sin( point1_lat_in_radians ) * sin( point2_lat_in_radians ) +
		                 cos( point1_lat_in_radians ) * cos( point2_lat_in_radians ) *
		                 cos( point2_long_in_radians - point1_long_in_radians) ) * EARTH_RADIUS;
		}
		 */

		public double dist(P p) {
			return Math.acos((slat * p.slat)
					+ (clat * p.clat * Math.cos(p.lng - lng)))
					* EARTH_RADIUS;
		}
	}

	static class G implements Comparable<G> {
		Integer id;
		Double dist;

		public G(int Id, double Dist) {
			id = Id;
			dist = Dist;
		}

		@Override
		public int compareTo(G that) {
			return Math.abs(dist - that.dist) < EPS ? id.compareTo(that.id)
					: dist.compareTo(that.dist);
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		S = new HashMap<String, Double>();
		S.put("metro", 20.0 / 60.0);
		S.put("bike", 15.0 / 60.0);
		S.put("foot", 5.0 / 60.0);
		int N = I(in.nextLine());
		P[] p = new P[N];
		for (int i = 0; i < N; i++)
			p[i] = new P(in.nextLine());
		int M = I(in.nextLine());
		for (int i = 0; i < M; i++) {
			String[] str = in.nextLine().split("\\s+");
			P h = new P(-1, Double.parseDouble(str[0]),
					Double.parseDouble(str[1]));
			double sped = S.get(str[2]), time = Double.parseDouble(str[3]);

			ArrayList<G> list = new ArrayList<G>();
			for (int j = 0; j < N; j++) {
				double dist = h.dist(p[j]);
				double rdist = (Math.round(dist * 100) / 100) / sped;
				// System.out.println(rdist + " : " + p[j].id);
				if (rdist < time || Math.abs(rdist - time) < EPS) {
					list.add(new G(p[j].id, dist));
				}
			}

			Collections.sort(list);
			StringBuilder sb = new StringBuilder();
			for (G t : list) {
				sb.append(t.id).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
		in.close();
	}
}
