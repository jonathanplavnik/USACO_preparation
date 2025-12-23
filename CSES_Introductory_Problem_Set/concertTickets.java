import java.util.*;
import java.io.*;
public class concertTickets {
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

        int n = io.nextInt(); //number of tickets
        int m = io.nextInt(); //number of customers

        ArrayList<Integer> prices = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            prices.add(io.nextInt());
        }
        // int[] maxPrice = new int[m]; //maximum price IN THE ORDER THEY ARRIVE

        /*
        int i = 0;
        int j = 0;

        while() {

        }
        */












        io.close();
    }
}