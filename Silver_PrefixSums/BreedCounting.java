package Silver_PrefixSums;
import java.util.*;
import java.io.*;
public class BreedCounting {
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
        Kattio io = new Kattio("bcount");

        int N = io.nextInt(); // num cows
        int Q = io.nextInt(); // num queries

        int[] sum1 = new int[N+1];
        int[] sum2 = new int[N+1];
        int[] sum3 = new int[N+1];

        sum1[0] = 0;
        sum2[0] = 0;
        sum3[0] = 0;

        for(int i = 1; i < N+1; i++){
            int next = io.nextInt();
            sum1[i] += sum1[i-1];
            sum2[i] += sum2[i-1];
            sum3[i] += sum3[i-1];
            if(next == 1) sum1[i]++;
            else if(next == 2) sum2[i]++;
            else sum3[i]++;
        }


        for(int i = 0; i < Q; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            io.println((sum1[b] - sum1[a-1]) + " " + (sum2[b] - sum2[a-1]) + " " + (sum3[b] - sum3[a-1]));
        }

        io.close();
    }
}