import java.util.*;
import java.io.*;
public class measurement {
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
        	 Kattio io = new Kattio("measurement");

        	int N = io.nextInt(); // num of lines, measurements
			TreeMap<Integer, String> change = new TreeMap<Integer, String>();

        	for(int i = 0; i < N; i++) {
				change.put(io.nextInt(), (io.next() + io.nextInt()));
        	}

			int bes = 7; // amt milk of bessie
			int els = 7; // amt milk of elsie
			int mil = 7; // amt milk of mildred
			int max = 7; // highest amt of milk
			String str;
			int ans = 0;
			boolean b = true; 
			boolean e = true;
			boolean m = true;
			

			for(int i : change.keySet()) {
				str = change.get(i);
				if(str.charAt(str.length()-2) == '-') { // positive change
					if(str.substring(0, str.length()-2).equals("Bessie")) { // if bessie
						bes -= Integer.parseInt(str.substring(str.length()-1));
					} else if (str.substring(0, str.length()-2).equals("Elsie")) {
						els -= Integer.parseInt(str.substring(str.length()-1));
					} else {
						mil -= Integer.parseInt(str.substring(str.length()-1));
					}
				} else { // negative change
					if(str.substring(0, str.length()-1).equals("Bessie")) { // if bessie
						bes += Integer.parseInt(str.substring(str.length()-1));
					} else if (str.substring(0, str.length()-1).equals("Elsie")) {
						els += Integer.parseInt(str.substring(str.length()-1));
					} else {
						mil += Integer.parseInt(str.substring(str.length()-1));
					}
				}
				max = Math.max(Math.max(bes, els), mil);

				boolean bessieNext = bes == max;
				boolean elsieNext = els == max;
				boolean mildredNext = mil == max;
				
				if(b != bessieNext || e != elsieNext || m != mildredNext) {
					ans++;
				} 
				

				b = bessieNext;
				e = elsieNext;
				m = mildredNext;
				
			}
			io.println(ans);
        	io.close();

    }
}