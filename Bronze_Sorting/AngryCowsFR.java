package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class AngryCowsFR {
	static int N;
	static int[] bales;
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
    
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("angry");

		N = io.nextInt();
		bales = new int[N];
		for (int i = 0; i < N; i++) { bales[i] = io.nextInt(); }

		Arrays.sort(bales);
		int maxExploded = 0;
		for (int i = 0; i < N; i++) {
			// Get the number of exploded bales for the left & right side
			maxExploded = Math.max(maxExploded,
			                       explodedNum(i, -1) + explodedNum(i, 1) + 1);
		}
		io.println(maxExploded);
		io.close();
	}

	public static int explodedNum(int start, int direction) {
		int radius = 1;
		int prev = start;
		while (true) {
			int next = prev;
			// Getting the furthest explosion index without exceeding radius
			while (next + direction >= 0 && next + direction < N &&
			       Math.abs(bales[next + direction] - bales[prev]) <= radius) {
				next += direction;
			}
			// We didn't find a new haybale, so the chain explosion is over
			if (next == prev) { break; }
			// Update our previous explosion and increment radius
			prev = next;
			radius++;
		}
		return Math.abs(prev - start);
	}
}