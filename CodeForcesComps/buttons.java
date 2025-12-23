package CodeForcesComps;
import java.util.*;
import java.io.*;
public class buttons {
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

        int cases = io.nextInt(); // num of test cases

        int a;
        int b;
        int c;
        for(int i = 0; i < cases; i++){
            a = io.nextInt();
            b = io.nextInt();
            c = io.nextInt();

            a = a + c - c/2;
            b = b + c/2;

            if(a > b){
                io.println("First");
            } else {
                io.println("Second");
            }
        }

        io.close();

    }
}