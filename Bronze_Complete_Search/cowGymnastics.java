package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class cowGymnastics {
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
        Kattio io = new Kattio("gymnastics");

        int K = io.nextInt(); // num practice sessions
        int N = io.nextInt(); // num cows

        int[][] s = new int[K][N]; // log of all rankings

        // storing all the info

        for(int i = 0; i < K; i++){
            for(int j = 0; j < N; j++){
                s[i][j] = io.nextInt();
            }
        }

        int check = 0;
        int ans = 0;

        for(int i = 0; i < N; i++){ // not necessary to do K - 1 bc the next for-loop won't run
            for(int j = i + 1; j < N; j++){
                for(int k = 0; k < K; k++){
                    if(indexOf(s[k], i) < indexOf(s[k], j)) check++;
                }
                
                if(check == 0 || check == K){
                    ans++;
                } 
                check = 0;
            }
        }
        

        io.println(ans);
        io.close();

    }
    private static int indexOf(int[] is, int i) {
        for(int j = 0; j < is.length; j++){
            if(is[j] == (i + 1)) return j;
        }
        return -1;
    }
}