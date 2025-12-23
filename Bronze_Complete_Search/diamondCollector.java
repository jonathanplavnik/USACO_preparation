package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class diamondCollector {
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
         Kattio io = new Kattio("diamond");

        int N = io.nextInt(); // num of diamonds
        int K = io.nextInt(); // greatest diff

     
        int[] list = new int[N];
        for(int i = 0; i < list.length; i++){
            list[i] = io.nextInt();
        }

        Arrays.sort(list);
        int ans = 0;
        int ans1 = 0;
        
        for(int i = 0; i < list.length; i++){
            ans = 1;
            for(int j = i+1; j < list.length; j++){
                if(Math.abs(list[i] - list[j]) <= K) ans++;
            }
            ans1 = Math.max(ans1, ans);
        }

        io.println(ans1);
        io.close();

    }
}