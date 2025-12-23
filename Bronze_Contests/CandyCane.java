package Bronze_Contests;

import java.util.*;
import java.io.*;
public class CandyCane {
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

        int N = io.nextInt(); // num cows
        int M = io.nextInt(); // num candy canes

        int[] cows = new int[N];
        for(int i = 0; i < cows.length; i++){
            cows[i] = io.nextInt();
        }
        int[] canes = new int[M];
        for(int i = 0; i < canes.length; i++){
            canes[i] = io.nextInt();
        }

        for(int i = 0; i < M; i++){
            int eaten = 0;
            int candy = canes[i];

            for(int j = 0; j < cows.length; j++){
                int eat = Math.min(cows[j], candy);
                //io.println(eat);
                if(eat <= eaten){
                    continue;
                } else {
                    cows[j] += eat - eaten;
                    eaten = Math.max(eat, eaten);
                }
            }
        }

        for(int i : cows){
            io.println(i);
        }
        
        io.close();
    }


	
}