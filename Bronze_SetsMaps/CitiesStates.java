package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class CitiesStates {
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
         Kattio io = new Kattio("citystate");


        int N = io.nextInt(); 
        int ans = 0;

        String cityState = "";
        String temp;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            temp = io.next();
            cityState = temp.substring(0, 2) + io.next();
            if (!cityState.substring(0, 2).equals(cityState.substring(2))) {
                map.put(cityState, map.getOrDefault(cityState, 0) + 1);
            }
        }


        for(String str : map.keySet()){
            String stateCity = str.substring(2) + str.substring(0,2);
            ans += map.getOrDefault(stateCity, 0) * map.get(str); 
        }

        ans /=2;
        io.println(ans);
        io.close();

    }
}