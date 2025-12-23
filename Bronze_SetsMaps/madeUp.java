package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class madeUp {
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

        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = io.nextInt();
        }
        int[] B = new int[N];
        for(int i = 0; i < N; i++){
            B[i] = io.nextInt();
        }
        int[] C = new int[N];
        for(int i = 0; i < N; i++){
            C[i] = io.nextInt();
        }


        int count = 0;

        for(int i = 0; i < N; i++){ // iterate through A
			for(int j = 0; j < N; j++){ // iterate through C
				if(C[j] <= N){
					if(A[i] == B[C[j]-1]){
						count++;
					} 
				}
			}
        }
        
        io.println(count);
        io.close();

    }
}