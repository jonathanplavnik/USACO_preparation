import java.util.*;
import java.io.*;
public class whitesheet {
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

        long a_x_1 = io.nextLong();
        long a_y_1 = io.nextLong();
        long a_x_2 = io.nextLong();
        long a_y_2 = io.nextLong();
        long b_x_1 = io.nextLong();
        long b_y_1 = io.nextLong();
        long b_x_2 = io.nextLong();
        long b_y_2 = io.nextLong();
        long c_x_1 = io.nextLong();
        long c_y_1 = io.nextLong();
        long c_x_2 = io.nextLong();
        long c_y_2 = io.nextLong();

        long area = (a_x_2 - a_x_1) * (a_y_2 - a_y_1);

        long intersectionAB;
        long intersectionAC;
        long intersectionABC;

        if(a_x_1 >= b_x_2 || a_x_2 <= b_x_1 || a_y_1 >= b_y_2 || a_y_2 <= b_y_1) { // check to see if they intersect
            intersectionAB = 0;
        } else {
            intersectionAB = (Math.min(a_x_2, b_x_2) - Math.max(a_x_1, b_x_1)) * (Math.min(a_y_2, b_y_2) - Math.max(a_y_1, b_y_1)); // intersection between A & B
        }
        if(a_x_1 >= c_x_2 || a_x_2 <= c_x_1 || a_y_1 >= c_y_2 || a_y_2 <= c_y_1) { // check to see if they intersect
            intersectionAC = 0;
        } else {
            intersectionAC = (Math.min(c_x_2, a_x_2) - Math.max(c_x_1, a_x_1)) * (Math.min(c_y_2, a_y_2) - Math.max(c_y_1, a_y_1)); // intersection between A & C
        }

        // check if intersectionAB, intersectionBC is true --> then check for intersection of abc

        if(b_x_1 >= c_x_2 || b_x_2 <= c_x_1 || b_y_1 >= c_y_2 || b_y_2 <= c_y_1) {
            intersectionABC = 0;
        } else {
            intersectionABC = 0;
            if(intersectionAB > 0 && intersectionAC > 0) intersectionABC = (Math.min(Math.min(a_x_2, b_x_2), c_x_2) -  Math.max(Math.max(a_x_1, b_x_1), c_x_1)) * (Math.min(Math.min(a_y_2, b_y_2), c_y_2) -  Math.max(Math.max(a_y_1, b_y_1), c_y_1));
        }
        // io.println(Math.min(Math.min(a_x_2, b_x_2), c_x_2) -  Math.max(Math.max(a_x_1, b_x_1), c_x_1));
        // io.println(Math.min(Math.min(a_y_2, b_y_2), c_y_2) -  Math.max(Math.max(a_y_1, b_y_1), c_y_1));

        // io.println(Math.min(Math.min(a_y_2, b_y_2), c_y_2));
        // io.println(Math.max(Math.max(a_y_1, b_y_1), c_y_1));

        //  io.println(area);
        //  io.println(intersectionAB);
        //  io.println(intersectionAC);
        //  io.println(intersectionABC);

        if((area - intersectionAB - intersectionAC + intersectionABC) > 0){
            io.println("YES");
        } else {
            io.println("NO");
        }
        io.close();
    }
}