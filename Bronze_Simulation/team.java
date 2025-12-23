import java.util.*;
import java.io.*;
public class team {
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
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt(); // num of problems

        int a;
        int b;
        int c;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            a = io.nextInt();
            b = io.nextInt();
            c = io.nextInt();
            if((a + b + c) > 1) ans++;
        }
        io.println(ans);




        io.close();

    }
}