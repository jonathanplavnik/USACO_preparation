package Bronze_Recursion;
import java.util.*;
import java.io.*;
public class threeLogos {
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


        int x1 = io.nextInt();
        int y1 = io.nextInt();
        int x2 = io.nextInt();
        int y2 = io.nextInt();
        int x3 = io.nextInt();
        int y3 = io.nextInt();

        int a1 = x1 * y1;
        int a2 = x2 * y2;
        int a3 = x3 * y3;

        int check = 0;
        if((double)Math.sqrt(a1 + a2 + a3) != (int)Math.sqrt(a1 + a2 + a3)){
            check = -1;
        } else {
            int side = (int)Math.sqrt(a1 + a2 + a3);
        }






        

        io.close();

    }
}