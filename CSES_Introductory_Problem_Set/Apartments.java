import java.util.*;
import java.io.*;
public class Apartments {
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

        int n = io.nextInt(); //num of Applicants
        int m = io.nextInt(); //num of apartments
        int k = io.nextInt(); //max diff

        int[] applicants = new int[n];
        int[] apartments = new int[m];
        for(int i = 0; i < n; i++) {
            applicants[i] = io.nextInt();
        }
        for(int i = 0; i < m; i++) {
            apartments[i] = io.nextInt();
        }
        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            if(Math.abs(applicants[i] - apartments[j]) <= k) {
                //found suitable apartment
                i++;
                j++;
                ans++;
            } else if (applicants[i] > apartments[j]) {
                //Apartment too small --> increase apartment size
                j++;
            } else {
                //Apartment too big --> increase desired size
                i++;
            }
        }
        io.print(ans);
        io.close();

    }
}