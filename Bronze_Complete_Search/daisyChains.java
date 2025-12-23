package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class daisyChains {
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

        int N = io.nextInt(); // num of flowers

        int[] petals = new int[N];

        for(int i = 0; i < N; i++){
            petals[i] = io.nextInt();
        }

        double sum = 0;
        double average = 0;
        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                sum = 0;

                for(int k = i; k <= j; k++){
                    sum += petals[k];
                }
                average = (sum / (double)(j - i + 1));
                for(int k = i; k <= j; k++){
                    if(average == petals[k]){
                        ans++;
                        break;
                    } 
                }
            }
        }
        ans += N;
        io.println(ans);
        
        io.close();

    }
}