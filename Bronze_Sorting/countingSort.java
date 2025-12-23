package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class countingSort {
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

        // if c is small enough, we can use this method to get O(n) time. c = O(n).

        int N = io.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = io.nextInt();
        }

        int[] book = new int[N];
        Arrays.fill(book, 0);

        for(int i = 0; i < N; i++){
            book[arr[i] - 1]++;
        }

        io.println(Arrays.toString(book));
        io.close();

    }
}