import java.util.*;
import java.io.*;

public class lostCow {
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
        Kattio io = new Kattio("lostcow");

        int x = io.nextInt(); // farmer john's current position
        int y = io.nextInt(); // bessie's current position
        
        int dis = 0;
		int travel = 1;
		int johnPos = x;

		while(true) {
			int newPos = x + travel;

			if(newPos > y && x < y){
				io.println(dis + y - johnPos);
				break;
			}
			if(newPos < y && x > y){
				io.println(dis - y + johnPos);
				break;
			}
			if(newPos == y){
				io.println(dis + Math.abs(y-johnPos));
				break;
			}
			
			dis += Math.abs(newPos - johnPos);
			travel *= -2;	
			johnPos = newPos;
		}
        io.close();

    }
}

