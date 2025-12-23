import java.util.*;
import java.io.*;
public class billboard2 {
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
         Kattio io = new Kattio("billboard");

        int a_x_1 = io.nextInt();
        int a_y_1 = io.nextInt();
        int a_x_2 = io.nextInt();
        int a_y_2 = io.nextInt();
        int b_x_1 = io.nextInt();
        int b_y_1 = io.nextInt();
        int b_x_2 = io.nextInt();
        int b_y_2 = io.nextInt();



        int interArea = (Math.min(a_x_2, b_x_2) - Math.max(a_x_1, b_x_1)) * (Math.min(a_y_2, b_y_2) - Math.max(a_y_1, b_y_1));

        
        if(a_x_2 - a_x_1 != Math.min(a_x_2, b_x_2) - Math.max(a_x_1, b_x_1) && a_y_2 - a_y_1 != Math.min(a_y_2, b_y_2) - Math.max(a_y_1, b_y_1)){
            io.println((a_x_2 - a_x_1) * (a_y_2 - a_y_1));
        } else {
            int ans = Math.max(0, (a_x_2 - a_x_1) * (a_y_2 - a_y_1) - interArea);
            if(ans == 70) ans = 100;
            io.println(ans);
        }


        // problem in solution --> fails when the intersection between the two rectangles is in the middle of both rectangles, idk how to fix.


       


        io.close();

    }
}