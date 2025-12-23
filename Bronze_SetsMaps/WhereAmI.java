package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class WhereAmI {
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
        // Kattio io = new Kattio();
        Kattio io = new Kattio("whereami");

        int N = io.nextInt(); // length of string
		String s = io.next(); // String!!
        

		for (int k = 1; k <= N; ++k) {
            boolean isUnique = true; // assume every substring is unique
            HashSet<String> seen = new HashSet<>();
            for (int i = 0; i <= N - k; ++i) {
                String sub = s.substring(i, i + k);
                if (seen.contains(sub)) {
                    isUnique = false;
                    break;
                }
                seen.add(sub);
            }
            if (isUnique) {
                io.println(k);
                break;
            }
        }

		
        io.close();

    }
}