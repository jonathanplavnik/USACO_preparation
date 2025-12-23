import java.util.*;
import java.io.*;
public class HaybaleStacking {
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

        int N = io.nextInt();
        int K = io.nextInt();

        // int[] stacks = new int[N];

        // for(int i = 0; i < K; i++){
        //     int a = io.nextInt();
        //     int b = io.nextInt();
        //     for(int j = a-1; j < b; j++){
        //         stacks[j]++;
        //     }
        // }
        
        // io.println(stacks[N/2]);

        int [] stacks = new int[N+1];

        for(int i = 0; i < K; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            stacks[a]++;
            stacks[b+1]--;
        }
        for(int i = 1; i < N+1; i++){
            stacks[i] = stacks[i] + stacks[i-1];
        }
        Arrays.sort(stacks);
        io.println(stacks[N/2]);


        io.close();
    }
}