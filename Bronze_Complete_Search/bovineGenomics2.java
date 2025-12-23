package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class bovineGenomics2 {
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
         Kattio io = new Kattio("cownomics");

        int N = io.nextInt();
		int M = io.nextInt();

		char[][] spotty = new char[N][M];
		char[][] plain = new char[N][M];

		String s;
		for(int i = 0; i < N; i++){
			s = io.next();
			for(int j = 0; j < M; j++){
				spotty[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < N; i++){
			s = io.next();
			for(int j = 0; j < M; j++){
				plain[i][j] = s.charAt(j);
			}
		}

		boolean checker;
		int ans = 0;
        for(int i = 0; i < M; i++){
            for(int j = i + 1; j < M; j++){
                for(int k = j + 1; k < M; k++){
					Set<String> seenCombos = new HashSet<>();
                    checker = true;

					for(int l = 0; l < N; l++){
						seenCombos.add("" + spotty[l][i] + spotty[l][j] +  spotty[l][k]);
					}
					for(int it = 0; it < N; it++){
						if(seenCombos.contains("" + plain[it][i] + plain[it][j] + plain[it][k])){
							checker = false;
							break;
						} 
					}
					

					if(checker){
						ans++;
					}

                }
            }
        }

		io.println(ans);
        io.close();

    }
}