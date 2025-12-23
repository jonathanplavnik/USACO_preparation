import java.util.*;
import java.io.*;
public class coinPiles {
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

        int t = io.nextInt(); //num of tests
        int a;
        int b;
        int sum;

        for(int i = 0; i < t; i++){
            a = io.nextInt();
            b = io.nextInt();
            sum = a+b;
            if(a == 0 & b == 0){
                io.println("YES");
            } else if (a == 0 || b == 0){
                io.println("NO");
            } else if (b > 2 * a || a > 2 * b){
                io.println("NO");
            } else if (sum % 3 == 0) {
                io.println("YES");
            } else if (sum % 3 != 0){
                io.println("NO");
            }
        }


        io.close();

    }
}