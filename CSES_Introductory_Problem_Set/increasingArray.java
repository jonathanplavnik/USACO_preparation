import java.util.*;
import java.io.*;
public class increasingArray {
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

        int n = io.nextInt(); //size of array
        int[] nums = new int[n]; //array of numbers
        for(int i = 0; i < n; i++) {
            nums[i] = io.nextInt();
        }
        long count = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                count = count + (nums[i-1] - nums[i]);
                nums[i] = nums[i-1];
            }
        }

        io.print(count);
        io.close();

    }
}