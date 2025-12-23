import java.util.*;
import java.io.*;
import java.awt.Rectangle;

public class billboard {
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
        Kattio io = new Kattio("billboard");

        int x1, y1, x2, y2;
		x1 = io.nextInt();
		y1 = io.nextInt();
		x2 = io.nextInt();
		y2 = io.nextInt();
		Rectangle firstRect = new Rectangle(x1, y1, x2 - x1, y2 - y1);

		x1 = io.nextInt();
		y1 = io.nextInt();
		x2 = io.nextInt();
		y2 = io.nextInt();
		Rectangle secondRect = new Rectangle(x1, y1, x2 - x1, y2 - y1);

		x1 = io.nextInt();
		y1 = io.nextInt();
		x2 = io.nextInt();
		y2 = io.nextInt();
		Rectangle truck = new Rectangle(x1, y1, x2 - x1, y2 - y1);

		long firstIntersect = getArea(firstRect.intersection(truck));
		long secondIntersect = getArea(secondRect.intersection(truck));

		io.println(getArea(firstRect) + getArea(secondRect) - firstIntersect -
		           secondIntersect);
		io.close();
	}

	public static long getArea(Rectangle r) {
		return r.isEmpty() ? 0 : (long)r.getHeight() * (long)r.getWidth();
	}
}