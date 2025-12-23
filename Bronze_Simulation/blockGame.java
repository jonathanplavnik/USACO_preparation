import java.util.*;
import java.io.*;
public class blockGame {
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
        Kattio io = new Kattio("blocks");

        int N = io.nextInt(); // num of spell boards
        TreeMap<String, Integer> dups = new TreeMap<String, Integer>(); //checking for duplicate letters
		TreeMap<String, Integer> dups2 = new TreeMap<String, Integer>();
        TreeMap<String, Integer> charCount = new TreeMap<String, Integer>();
        String str = "";
        
        
        
        
        for(int i = 0; i < N; i++) {
            String a = io.next();
            String b = io.next();
            str = str + a + b;


            String[] first = a.split("");
            for(String s : first) {
			if (dups.containsKey(s)) {
				dups.put(s, dups.get(s) + 1);
			} else {
				dups.put(s , 1);
			    }
            }
            String[] second = b.split("");
            for(String s : second) {
			if (dups2.containsKey(s)) {
				dups2.put(s, dups2.get(s) + 1);
			} else {
				dups2.put(s , 1);
			    }
		    }

			int min = 0;

			for(String j : dups.keySet()) {
				if(dups2.containsKey(j)) {
					min = Math.min(dups.get(j), dups2.get(j));
					if(charCount.containsKey(j)) {
                        charCount.put(j, charCount.get(j) - min);
                    } else {
                        charCount.put(j, -1 * min);
                    }
				}
			}
			
            dups.clear();
			dups2.clear(); 
        }
		

		String[] input = str.split("");

		for(String s : input) {
			if (charCount.containsKey(s)) {
				charCount.put(s, charCount.get(s) + 1);
			} else {
				charCount.put(s , 1);
			}
		}
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alpha = alphabet.split("");
        for(int i = 0; i < 26; i++) {
            if(! charCount.containsKey(alpha[i])) charCount.put(alpha[i], 0);
            io.println(charCount.get(alpha[i]));
        }

        io.close();
    }
}