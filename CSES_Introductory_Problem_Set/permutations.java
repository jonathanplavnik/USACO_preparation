import java.util.*;
import java.io.*;
public class permutations {
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

        int n = io.nextInt(); //highest int aka number of ints
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        if(n == 1) {
            io.print(1);
        } else if (n < 4 && n != 1) {
            io.print("NO SOLUTION");
        } else {
            for(int i = 0; i < n; i++) {
                if(nums[i] % 2 == 0) io.print(nums[i] + " ");
            }
            for(int i = 0; i < n; i++) {
                if(nums[i] % 2 == 1) io.print(nums[i] + " ");
            }
        }



        io.close();

    }
}