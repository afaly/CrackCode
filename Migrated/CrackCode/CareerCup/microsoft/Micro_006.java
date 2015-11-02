package microsoft;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

class Photograph {
	String data;
	int dt;

	public Photograph(String data, int dt) {
		this.data = data;
		this.dt = dt;
	}

	@Override
	public String toString() {
		return "DATA  [" + data + " ON <" + dt + ">]";
	}
}

class Meta implements Comparable<Meta> {
	private Date date;
	private int dt, id;
	private boolean flag;

	public int Id() {
		return id;
	}

	public Meta(Date date) {
		this.date = date;
	}

	public Meta(int id, int dt, boolean flag) {
		this.dt = dt;
		this.id = id;
		this.flag = flag;
	}

	public Meta(int dt) {
		this.dt = dt;
	}

	public boolean isFavorite() {
		return flag;
	}

	@Override
	public String toString() {
		return id + " :  ON <" + dt + "> ";
	}

	@Override
	public int compareTo(Meta ph) {
		int cmp = dt - ph.dt;
		return cmp == 0 ? id - ph.id : cmp;
	}
}

class Foto {
	private TreeSet<Meta> dic;
	private HashMap<Integer, Photograph> arc;
	private int idx;
	private int ldt, ldf;
	private Iterator<Meta> nxtItr, nxtFItr;

	public Foto() {
		dic = new TreeSet<Meta>();
		arc = new HashMap<Integer, Photograph>();
		idx = 0;
		ldt = -1;
		ldf = -1;
	}

	public void add(Photograph ph, int time, boolean favorite) {
		arc.put(idx, ph);
		dic.add(new Meta(idx, time, favorite));
		idx++;
	}

	public Photograph next(int dt) {
		if (dt != ldt) updateNextItr(dt);
		if (nxtItr.hasNext()) return arc.get(nxtItr.next().Id());
		return null;
	}

	public Photograph nextFavorite(int dt) {
		if (dt != ldf) updateNextFavoriteItr(dt);
		while (nxtFItr.hasNext()) {
			Meta meta = nxtFItr.next();
			if (meta.isFavorite()) return arc.get(meta.Id());
		}
		return null;
	}

	private void updateNextFavoriteItr(int dt) {
		nxtFItr = dic.tailSet(new Meta(dt), false).iterator();
		ldf = dt;
	}

	private void updateNextItr(int dt) {
		nxtItr = dic.tailSet(new Meta(dt), false).iterator();
		ldt = dt;
	}

	public int size() {
		return dic.size();
	}
}

public class Micro_006 {

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		Random f = new Random(System.currentTimeMillis());
		Foto foto = new Foto();
		for (int i = 0; i < 10; i++) {
			int dt = r.nextInt(10) + 1;
			Photograph ph = new Photograph("Photo #" + i, dt);
			foto.add(ph, dt, f.nextBoolean());
		}
		System.out.println("Size: " + foto.size());
		for (int i = 0; i <= 10; i++) {
			System.out.println("PHOTOS AFTER : <" + i + ">");
			Photograph ph = foto.next(i);
			while (ph != null) {
				System.out.println(ph);
				ph = foto.next(i);
			}
		}
	}
}
