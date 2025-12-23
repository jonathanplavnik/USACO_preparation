import java.util.*;
import java.io.*;
public class twoTables {
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
        Kattio io = new Kattio();
        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            int W = io.nextInt(), H = io.nextInt();
            int x1 = io.nextInt(), y1 = io.nextInt(), x2 = io.nextInt(), y2 = io.nextInt();
            int w2 = io.nextInt(), h2 = io.nextInt();
            int w1 = x2 - x1, h1 = y2 - y1;

            boolean flag = false;
            int res = Integer.MAX_VALUE;
            if (H - h2 >= h1) {
                flag = true;
                int dist = Math.max(y1, H - y2);
                res = Math.min(res, h2 - dist);
            }
            if (W - w2 >= w1) {
                flag = true;
                int dist = Math.max(x1, W - x2);
                res = Math.min(res, w2 - dist);
            }
            res = Math.max(res, 0);
            if (flag == false)
                io.println(-1);
            else
                io.println(res);
        }
        io.close();
    }
}
