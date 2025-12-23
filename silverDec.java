import java.util.*;
import java.io.*;
public class silverDec {
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
		int t = io.nextInt(); // num test cases

		for(int i = 0; i < t; i++){
			int N = io.nextInt(); // num cakes
			int[] size = new int[N];
			for(int j = 0; j < N; j++){
				size[j] = io.nextInt();
			}

			int[] prefix = new int[N+1];
            for (int j = 0; j < N; j++) {
                prefix[j+1] = prefix[j] + size[j];
            }

			long elsie = 0;
			int left = 0;
			int right = N-1;
			int count = 1;
			while(count < N-1){
				count++;
				int lsize = size[left];
				int rsize = size[right];
				if(lsize > rsize){
					elsie += lsize;
					left++;
				} else {
					elsie += rsize;
					right--;
				}
				count++;
			}

			long sumAll = prefix[N];
            long bessie = sumAll - elsie;
            io.println(bessie + " " + elsie);
		}
        
        io.close();
    }
	
}