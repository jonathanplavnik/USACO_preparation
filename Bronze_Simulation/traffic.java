import java.util.*;
import java.io.*;
public class traffic {
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
    public static void on(int[] xy, int first, int second) {
		xy[0] = Math.max(0,xy[0] + first);
		xy[1] = Math.max(0,xy[1] + second);
	}
	
	public static void off(int[] xy, int first, int second) {
		xy[0] = Math.max(0, xy[0] - second);
		xy[1] = Math.max(0, xy[1] - first);
	}
	
	public static void none(int[] xy, int first, int second) {
		xy[0] = Math.max(first, xy[0]);
		xy[1] = Math.min(second, xy[1]);
	}
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("traffic");

        int segments = io.nextInt(); // num of segments
		
		String[] type = new String[segments];
		int[] first = new int[segments];
		int[] second = new int[segments];
		
		int min = 0;
		int max = 0;
		for(int x = 0; x < segments; x++) {
			type[x] = io.next();
			first[x] = io.nextInt();
			second[x] = io.nextInt();
			
			min -= first[x];
			max += second[x];
		}
		
		int[] xy = {min,max};
		
		for(int x = segments - 1; x >= 0;x --) { //finding traffic prior to mile 1
			if(type[x].equals("on")) {
				off(xy,first[x],second[x]);
			}
			
			else if(type[x].equals("off")) {
				on(xy,first[x],second[x]);
			}
			
			else {
				none(xy,first[x],second[x]);
			}
            
		}
		io.println(xy[0]+" "+xy[1]);
		
		xy[0] = min;
		xy[1] = max;
		
		for(int x = 0; x < segments; x++) {//finding traffic after last mile
			if(type[x].equals("on")) {
				on(xy,first[x],second[x]);
			}
			
			else if(type[x].equals("off")) {
				off(xy,first[x],second[x]);
			}
			
			else {
				none(xy,first[x],second[x]);
			}
		}
		io.print(xy[0]+" "+xy[1]);
		io.close();

        io.close();
    }
}