package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class bovineGenomics {
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

		int a = 0;
		int c = 0;
		int g = 0;
		int t = 0;

		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;
		

		int ans = 0;

		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(spotty[j][i] == 'A' && a == 0) a++;
				if(spotty[j][i] == 'C' && c == 0) c++;
				if(spotty[j][i] == 'G' && g == 0) g++;
				if(spotty[j][i] == 'T' && t == 0) t++;
			}
			for(int j = 0; j < N; j++){
				if(plain[j][i] == 'A' && A == 0) A++;
				if(plain[j][i] == 'C' && C == 0) C++;
				if(plain[j][i] == 'G' && G == 0) G++;
				if(plain[j][i] == 'T' && T == 0) T++;
			}
			ans++;

			a += A;
			c += C;
			g += G;
			t += T;

			if(a == 2 || c == 2 || g == 2 || t == 2) ans--;
			a = 0;
			c = 0;
			g = 0;
			t = 0;
			A = 0;
			C = 0;
			G = 0;
			T = 0;
		}


		io.println(ans);
        io.close();

    }
}