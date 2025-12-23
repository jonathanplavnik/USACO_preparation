package Bronze_Recursion;
import java.util.*;
import java.io.*;
public class backforth {
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

    static HashSet<Integer> results = new HashSet<>();

    static void transport(int day, int b1, int b2, List<Integer> barn1, List<Integer> barn2){
        if(day == 4){
            results.add(b1);
            return;
        }

        for(int i = 0; i < barn1.size(); i++){
            
            int t = barn1.get(i);

            List<Integer> newA = new ArrayList<>(barn1);
			newA.remove(i);
			List<Integer> newB = new ArrayList<>(barn2);
			newB.add(t);

			// Recursively call the function with the new buckets and tank
			// amounts.
			transport(day + 1, b2 + t, b1 - t, newB, newA);
        }
        
    }



    public static void main(String[] args) throws IOException {
        // Kattio io = new Kattio();
        Kattio io = new Kattio("backforth");

        List<Integer> barn1 = new ArrayList<>();
        List<Integer> barn2 = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            barn1.add(io.nextInt());
        }
        for(int i = 0; i < 10; i++){
            barn2.add(io.nextInt());
        }

        transport(0, 1000, 1000, barn1, barn2);

        io.println(results.size());
        io.close();

    }

    static void TR(int b1, int b2, int i){
        b1 -= i;
        b2 += i;
    }
    static void WF(int b1, int b2, int i){
        b1 += i;
        b2 -= i;
    }
}