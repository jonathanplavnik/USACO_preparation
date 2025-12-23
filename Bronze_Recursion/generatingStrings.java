package Bronze_Recursion;
import java.util.*;
import java.io.*;
public class generatingStrings {
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
    static String s;
    static ArrayList<String> perms = new ArrayList<String>();
    static int[] charCount = new int[26];

    static void search(String curr, int iValue, int level) {
        // System.out.println("[" + level + "]" + curr + " " + charCount[0] + " " + charCount[1] + " " + charCount[2] + " [" + iValue +"]");
        if (curr.length() == s.length()) {
			perms.add(curr);
			return;
		}
        for (int i = 0; i < 26; i++) {
			// For all available characters
			if (charCount[i] > 0) {
				// Add it to the current string and continue the search
				charCount[i]--;
				search(curr + (char)(i + 'a'), i, level + 1);
				charCount[i]++;
			}
		}
    }
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        s = io.next();
        
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }
        

        search("", -1, 0);

        io.println(perms.size());
        for(String i : perms){
            io.println(i);
        }

        io.close();
    }
}