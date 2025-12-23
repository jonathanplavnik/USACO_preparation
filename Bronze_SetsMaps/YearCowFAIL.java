package Bronze_SetsMaps;
import java.util.*;

import java.io.*;
public class YearCowFAIL {
    final static String[] years = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    final static int len = 8; // length of each line of input
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

        int N = io.nextInt(); // num of lines
        int prev = 0;
        int yearDiff;

        HashMap<String, Integer> map = new HashMap<>(); // store all birth years
        map.put("Bessie", 0);
        for(int i = 0; i < N; i++){
            String[] curr = new String[len];
            for(int j = 0; j < len; j++){ // line of input as an array
                curr[j] = io.next();
            }
            
            if(curr[3].equals("previous")){
                yearDiff = mod12(prev - indexOf(years, curr[4]));
                if(yearDiff == 0) yearDiff = 12;
                map.put(curr[0], map.get(curr[len-1]) - yearDiff);
            } else {
                yearDiff = mod12(indexOf(years, curr[4]) - prev);
                if(yearDiff == 0) yearDiff = 12;
                map.put(curr[0], map.get(curr[len-1]) + yearDiff);
            }

            prev = mod12(map.get(curr[0]));
            if(curr[0].equals("Elsie")) break;
        }
        int ans = Math.abs(map.get("Bessie") - map.get("Elsie"));
        
        io.print(ans);
        io.close();

    }
    static int indexOf(String[] years, String s){
        for(int i = 0; i < years.length; i++){
            if(years[i].equals(s)) return i;
        }
        return -1;
    }
    static int mod12(int i){
        if(i < 0){
            return (i + 12 * 10000) % 12;
        } else {
            return i % 12;
        }
    }
}