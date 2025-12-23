package Bronze_SetsMaps;
import java.io.*;
import java.util.*;

public class YearCow {
	static final String[] ZODIAC = {"Ox",      "Tiger", "Rabbit", "Dragon",
	                                "Snake",   "Horse", "Goat",   "Monkey",
	                                "Rooster", "Dog",   "Pig",    "Rat"};

	static class Relation {
		String name;
		boolean prev;  // is this a "previous" or "next" relation?
		int year;
		String relative;
		public Relation(String name, boolean prev, int year, String relative) {
			this.name = name;
			this.prev = prev;
			this.year = year;
			this.relative = relative;
		}
	}

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.nextInt();

		Relation[] relations = new Relation[n];
		for (int r = 0; r < n; r++) {
			String name = io.next();
			io.next();
			io.next();
			boolean prev = io.next().equals("previous");
			String animal = io.next();
			int year = -1;
			for (int i = 0; i < ZODIAC.length; i++) {
				if (ZODIAC[i].equals(animal)) { year = i; }
			}
			io.next();
			io.next();
			String relative = io.next();
			relations[r] = new Relation(name, prev, year, relative);
		}

		Map<String, Integer> birthYears = new HashMap<>();
		birthYears.put("Bessie", 0);
		for (Relation r : relations) {
			int change = r.prev ? -1 : 1;
			// +change because it has to be at least 1 year off
			int year = birthYears.get(r.relative) + change;
			while (mod(year, ZODIAC.length) != r.year) { year += change; }
			birthYears.put(r.name, year);
		}

		int dist = Math.abs(birthYears.get("Bessie") - birthYears.get("Elsie"));
		io.println(dist);
		io.close();
	}

	static int mod(int n, int m) { return ((n % m) + m) % m; }

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}