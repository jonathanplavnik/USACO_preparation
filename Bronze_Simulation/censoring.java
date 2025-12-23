import java.util.*;
import java.io.*;
public class censoring {
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
        Kattio io = new Kattio("censor");

        String s = io.next(); // long word
        String t = io.next(); // censored part
        
        // while(s.contains(t)){
        //     s = s.replace(t, "");
        // }
        // doesnt work for whatever reason


        StringBuilder ans = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));
            if(ans.length() >= t.length()) {
                if(ans.substring(ans.length()-t.length(), ans.length()).equals(t)){
                    ans.delete(ans.length()-t.length(), ans.length());
                }
            }
        }


        io.println(ans);
        io.close();

    }
}