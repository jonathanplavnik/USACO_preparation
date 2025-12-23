import java.util.*;
import java.io.*;
public class bovineShuffle {
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
        Kattio io = new Kattio("shuffle");

        int N = io.nextInt(); // number of cows

        int[] shuffle = new int[N]; //rearragements
        for(int i = 0; i < N; i++){
            shuffle[i] = io.nextInt() - 1;
        }

        int[] num = new int[N]; // list of numbers
        for(int i = 0; i < N; i++){
            num[i] = io.nextInt();
        }
        int[] numNew = new int[N]; // output
        int index = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(shuffle[k] == j) index = k;
                }
                
                numNew[index] = num[j]; 
            }
            for(int l = 0; l < N; l++){
                num[l] = numNew[l];
            }
        }

        for(int i = 0; i < N; i++){
            io.println(numNew[i]);
        }



        io.close();

    }
}