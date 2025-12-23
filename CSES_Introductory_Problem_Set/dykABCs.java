import java.util.*;
import java.io.*;
public class dykABCs {
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

        long[] in = new long[7];
        for(int i = 0; i < 7; i++){
            in[i] = io.nextLong();
        }
        Arrays.sort(in);

        long a = in[0];
        long bC = in[6] - a;
        long b = 0;
        long c = 0;

        for(int i = 1; i < 7; i++) {
            for(int j = i; j < 7; j++) {
                if(bC - in[j] == in[i]){
                    b = Math.min(in[j], in[i]);
                    c = Math.max(in[j], in[i]);
                    break;
                }
            }
        }
        io.println(a + " " + b + " " + c);

        





        io.close();

    }
}