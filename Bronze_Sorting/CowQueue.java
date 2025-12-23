package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class CowQueue {
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
	// constructor/class practice
	static class Cow {
		public int arrival;
		public int duration;

		public Cow(int arrival, int duration) {
			this.arrival = arrival;
			this.duration = duration;
		}
	}
    public static void main(String[] args) throws IOException {
        // Kattio io = new Kattio();
        Kattio io = new Kattio("cowqueue");

        int N = io.nextInt();

		Cow[] cows = new Cow[N];
		for (int i = 0; i < N; i++) {
			int x = io.nextInt();
			int y = io.nextInt();
			cows[i] = new Cow(x, y);
		}

		Arrays.sort(cows, Comparator.comparingInt(c -> c.arrival));

		int curr = 0;

		for(Cow c: cows){
			if(curr > c.arrival){
				curr += c.duration;
			} else {
				curr = c.arrival + c.duration;
			}
		}
        
        io.println(curr);
        io.close();

    }
}