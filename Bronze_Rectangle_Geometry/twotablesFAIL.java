import java.util.*;
import java.io.*;
public class twotablesFAIL {
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

        int t = io.nextInt(); // num of test cases

        long[] width = new long[t];
        long[] height = new long[t];
        long[] x1 = new long[t];
        long[] y1 = new long[t];
        long[] x2 = new long[t];
        long[] y2 = new long[t];
        long[] w2 = new long[t];
        long[] h2 = new long[t];

        for(int i = 0; i < t; i++){
            width[i] = io.nextLong();
            height[i] = io.nextLong();
            x1[i] = io.nextLong();
            y1[i] = io.nextLong();
            x2[i] = io.nextLong();
            y2[i] = io.nextLong();
            w2[i] = io.nextLong();
            h2[i] = io.nextLong();
        }

        long ans = -1;

        for(int i = 0; i < t; i++){
            if((x2[i] - x1[i]) + w2[i] <= width[i] && (y2[i] - y1[i]) + h2[i] <= height[i]){ // needs both vertical and horizontal shifting (pythag)
                if(w2[i] <= Math.max(x1[i], width[i] - x2[i]) || h2[i] <= Math.max(y1[i], height[i] - y2[i])){
                    ans = 0;
                } else {
                    ans = (long)(Math.sqrt(Math.pow(h2[i] - Math.max(height[i] - y2[i], y1[i]), 2) + Math.pow(w2[i] - Math.max(width[i] - x2[i], x1[i]), 2)));
                }
            } else if (((x2[i] - x1[i]) + w2[i] > width[i]) && ((y2[i] - y1[i]) + h2[i] <= height[i])) { // no horizontal movement, only vertical
                if(h2[i] <= y1[i] || h2[i] <= height[i] - y2[i]){
                    ans = 0;
                } else {
                    ans = h2[i] - Math.max(height[i] - y2[i], y1[i]);
                }
            } else if ((x2[i] - x1[i]) + w2[i] <= width[i] && (y2[i] - y1[i]) + h2[i] > height[i]) { // no vertical movement, only horizontal
                if(w2[i] <= x1[i] || w2[i] <= width[i] - x2[i]){
                    ans = 0;
                } else { 
                    ans = w2[i] - Math.max(width[i] - x2[i], x1[i]);
                }
            }
            // if no change to ans, it is impossible to fit both rectangles
            io.println(ans);

            ans = -1;
        }
        io.close();

    }
}