import java.util.*;
import java.io.*;
public class mixMilk {
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
    final static int n = 3; //num of buckets
    final static int turn = 100; //num of turns
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");

        int[] capacity = new int[n]; //maximum capacity of milk in bucket i

        int[] milk = new int[n];

        for(int i = 0; i < n; i++) {
            capacity[i] = io.nextInt();
            milk[i] = io.nextInt();
        }

        for(int i = 0; i < turn; i++) {
            int bucket1 = i % n;
            int bucket2 = (i+1) % n;


            int amt = Math.min(milk[bucket1], capacity[bucket2] - milk[bucket2]);

            milk[bucket1] -= amt;
            milk[bucket2] += amt;
        }

        for(int m : milk) {io.println(m); }
        io.close();

    }
}