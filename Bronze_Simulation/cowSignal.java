import java.util.*;
import java.io.*;
public class cowSignal {
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
        Kattio io = new Kattio("cowsignal");

        int M = io.nextInt(); //num rows of input
        int N = io.nextInt(); //num columns of input
        int K = io.nextInt(); //factor of enlargement
        ArrayList<String> chars = new ArrayList<>(); // list of all characters
        for(int i = 0; i < M; i++){
            String[] indivChars = io.next().split("");
            for(String j : indivChars) {chars.add(j);}

        }
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < K; j++) {
                for(int k = 0; k < N; k++) {
                    for(int l = 0; l < K; l++) {
                        io.print(chars.get(k + i * N));
                    }
                }
                io.println();
            }
        }





        io.close();

    }
}