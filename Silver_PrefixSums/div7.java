package Silver_PrefixSums;
import java.util.*;
import java.io.*;
public class div7 {
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
        Kattio io = new Kattio("div7");

        int N = io.nextInt();

        int[] sums = new int[N+1];

        sums[0] = 0;
        for(int i = 1; i < N+1; i++){
            sums[i] = (sums[i-1] + io.nextInt()) % 7;
        }

		// calculate each range
        int ans = 0;

		for(int i = 0; i < 7; i++){

			int a = 0;
			int b = N;
			int range = 0;
			while(a < N+1 && sums[a] != i){
				a++;
			}
			while(b >= 0 && sums[b] != i){
				b--;
			}
			range = b - a;
			ans = Math.max(ans, range);
		}
		io.println(ans);

        io.close();

    }	
}