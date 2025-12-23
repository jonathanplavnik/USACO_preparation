import java.util.*;
import java.io.*;
public class circularBarn {
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
        // Kattio io = new Kattio();
        Kattio io = new Kattio("cbarn");

        int n = io.nextInt(); // number of rooms

        int sum = 0;
        int[] cow = new int[n]; // num of cows in each room

        for(int i = 0; i < n; i++) {
            cow[i] = io.nextInt();
            sum += cow[i];
        }
        int ans = 0;
        int answer = 100000000;
        int cowRemaining = 0; // num cows remaining
        for(int i = 0; i < n; i++) {
            int start = cow[i];
            cowRemaining = sum;
            cowRemaining -= start;
            for(int j = i + 1; j < n; j++) {
                ans += cowRemaining;
                cowRemaining -= cow[j];
            }
            for(int j = 0; j < i; j++) {
                ans += cowRemaining;
                cowRemaining -= cow[j];
            }
            answer = Math.min(answer, ans);
            ans = 0;
        }
        
        io.println(answer);
        io.close();

    }
}