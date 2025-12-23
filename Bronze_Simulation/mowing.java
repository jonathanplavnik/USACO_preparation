import java.util.*;
import java.io.*;
public class mowing {
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
        Kattio io = new Kattio("mowing");

        int N = io.nextInt(); // num of directions

        int[][] grid = new int[2001][2001];
        int row = 1000;
        int column = 1000;
        grid[row][column] = 1;


        int[][] time = new int[2001][2001];
        time[row][column] = 0;
        int t = 0;

        String[] direction = new String[N];
        int[] distance = new int[N];

        for(int i = 0; i < N; i++){
            direction[i] = io.next();
            distance[i] = io.nextInt();
        }
        int ans = 10000;


        for(int i = 0; i < N; i++) {
            if(direction[i].equals("N")) {
                for(int j = 0; j < distance[i]; j++) {
                    t++;
                    if(grid[row - 1][column] != 1){
                        grid[row - 1][column] = 1;
                    } else {
                        ans = Math.min(ans, t- time[row - 1][column]);
                    }
                    time[row - 1][column] = t;
                    row--;
                    
                }
            } else if(direction[i].equals("E")) {
                for(int j = 0; j < distance[i]; j++) {
                    t++;
                    if(grid[row][column + 1] != 1){
                        grid[row][column + 1] = 1;
                    } else {
                        ans = Math.min(ans, t- time[row][column + 1]);
                    }
                    time[row][column + 1] = t;
                    column++;
                }
            } else if(direction[i].equals("S")) {
                for(int j = 0; j < distance[i]; j++) {
                    t++;
                    if(grid[row + 1][column] != 1){
                        grid[row + 1][column] = 1;
                    } else {
                        ans = Math.min(ans, t- time[row + 1][column]);
                    }
                    time[row + 1][column] = t;
                    row++;
                }
            } else if(direction[i].equals("W")) {
                for(int j = 0; j < distance[i]; j++) {
                    t++;
                    if(grid[row][column - 1] != 1){
                        grid[row][column - 1] = 1;
                    } else {
                        ans = Math.min(ans, t- time[row][column - 1]);
                    }
                    time[row][column - 1] = t;
                    column--;
                }
            }
        }
        if(ans == 10000) {
            io.println(-1);
        } else {
            io.println(ans);
        }
        io.close();
    }
}