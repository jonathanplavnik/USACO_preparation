import java.util.*;
import java.io.*;
public class squarePasture {
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
         Kattio io = new Kattio("square");

        int a_x_1 = io.nextInt();
        int a_y_1 = io.nextInt();
        int a_x_2 = io.nextInt();
        int a_y_2 = io.nextInt();
        int b_x_1 = io.nextInt();
        int b_y_1 = io.nextInt();
        int b_x_2 = io.nextInt();
        int b_y_2 = io.nextInt();


        int x1 = Math.min(Math.min(a_x_1, a_x_2), Math.min(b_x_1, b_x_2));
        int x2 = Math.max(Math.max(a_x_1, a_x_2), Math.max(b_x_1, b_x_2));
        int y1 = Math.min(Math.min(a_y_1, a_y_2), Math.min(b_y_1, b_y_2));
        int y2 = Math.max(Math.max(a_y_1, a_y_2), Math.max(b_y_1, b_y_2));

        int ans = Math.max((x2-x1), (y2-y1));

        io.println(ans * ans);



        io.close();

    }
}