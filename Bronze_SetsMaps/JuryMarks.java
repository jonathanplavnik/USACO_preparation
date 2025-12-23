package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class JuryMarks {
	
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

		int k = io.nextInt(); // num of judges
		int n = io.nextInt(); // num of score remembered


		int[] marks = new int[k]; // array of judge scores
		int sum = 0; // total change from beginning to end
		for(int i = 0; i < k; i++){
			int x = io.nextInt();
			sum += x; 
			marks[i] = x;
		}
		int[] check = new int[n]; // array of scores remember
		HashSet<Integer> values = new HashSet<>(); // scores remembered to check against
		for(int i = 0; i < n; i++){
			int x = io.nextInt();
			check[i] = x;
			values.add(x);
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++){
			if(solve(check[i]-sum, check, values)) ans++; // if all the scores achieved contains the scores remembered, ++
		}
		
		io.println(ans);
        io.close();

    }
	static boolean solve(int i, int[] check, HashSet<Integer> values){
		HashSet<Integer> checker = new HashSet<>();
		for(int j = 0; j < check.length; j++){
			i += check[j];
			checker.add(i);
		}
		if(checker.containsAll(values)){
			return true;
		}
		return false;
	}
}