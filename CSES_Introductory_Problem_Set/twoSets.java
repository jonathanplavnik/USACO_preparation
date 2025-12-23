import java.util.*;
import java.io.*;
public class twoSets {
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

        long n = io.nextLong(); //given numbers 1...n

        
        if(n % 4 != 0 && (n+1) % 4 != 0) {
                io.println("NO");
        } else if (n % 4 == 0) {
            io.println("YES");
            io.println(n/2);
            for(int i = 1; i < n+1; i++){
                if(i % 4 == 1 || i % 4 == 0) io.print(i + " ");
            }
            io.println(n/2);
            for(int i = 1; i < n+1; i++){
                if(i % 4 == 2 || i % 4 == 3) io.print(i + " ");
            }
        } else {
            io.println("YES");
            io.println(n/2 + 1);
            io.print(1 + " ");
            io.print(2 + " ");
             for(int i = 4; i < n+1; i++){
                if(i % 4 == 0 || i % 4 == 3) io.print(i + " ");
            }
            io.println();
            io.println(n/2);
            io.print(3 + " ");
            for(int i = 4; i < n+1; i++){
                if(i % 4 == 2 || i % 4 == 1) io.print(i + " ");
            }
        }




        io.close();

    }
}