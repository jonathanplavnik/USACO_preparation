package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class casino {
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

        int N = io.nextInt();

        
        for(int i = 0; i < N; i++){
            int x = io.nextInt(); // num rows
            int y = io.nextInt(); // num columns
            long[][] bets = new long[y][x]; // we switch orientation of columns and rows
            for(int j = 0; j < x; j++){
                for(int k = 0; k < y; k++){
                    bets[k][j] = io.nextInt();
                }
            }

            long ans = 0;

            for(int j = 0; j < y; j++){
                if(x == 1) break;
                ans += solve(bets[j]);
            }

            io.println(ans);
        }

        io.close();
    }
    static long solve(long[] nums){
        Arrays.sort(nums);

        int n = nums.length;
        long cur = 0;

        for(int i = 1; i < n; i++){
            cur += nums[i] - nums[0];
        }
        long ans = cur;
        for (int i=1; i<n; i++) {
			cur -= (nums[i]-nums[i-1])*(n-i);
			ans +=cur;
		}
		return ans;
    }
}