import java.util.*;
import java.io.*;
public class bucketList {
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
        Kattio io = new Kattio("blist");

        int N = io.nextInt(); // num cows

        int[] buckets = new int[1000];

        for(int i = 0; i < N; i++) {
            int start = io.nextInt() - 1;
            int end = io.nextInt() - 1;
            int b = io.nextInt();
            for(int j = start; j < end + 1; j++){
                buckets[j] += b;
            }
        }
        

        int max = 0;
        for(int i = 1; i < buckets.length; i++) {
            max = Math.max(max, buckets[i]);
        }
        io.println(max);
        io.close();

    }
}