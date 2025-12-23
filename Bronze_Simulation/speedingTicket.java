import java.util.*;
import java.io.*;
public class speedingTicket {
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
        Kattio io = new Kattio("speeding");

        int N = io.nextInt(); // segments of the road
        int M = io.nextInt(); // segments of bessie's journey

        int[] road = new int[100];
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            int increment = io.nextInt();
            int speed = io.nextInt();
            end += increment;
            for(int j = start; j < end; j++) {
                road[j] = speed;
            }
            start += increment;
        }
        int[] roadBessie = new int[100];
        int start1 = 0;
        int end1 = 0;
        for(int i = 0; i < M; i++) {
            int increment1 = io.nextInt();
            int speed1 = io.nextInt();
            end1 += increment1;
            for(int j = start1; j < end1; j++) {
                roadBessie[j] = speed1;
            }
            start1 += increment1;
        }
        int max = 0;
        for(int i = 0; i < 100; i++) {
            if(roadBessie[i] - road[i] > max) max = roadBessie[i] - road[i];
        }

        io.println(max);

        io.close();
        
    }
}