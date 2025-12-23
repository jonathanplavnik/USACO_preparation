import java.util.*;
import java.io.*;
public class ferrisWheel {
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
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt(); //number of children
        int x = io.nextInt(); //maximum allowed weight onto the gondola
        int[] weight = new int[io.nextInt()];
        for(int i = 0; i < weight.length; i++) {
            weight[i] = io.nextInt();
        }
        int ans = 0;
        Arrays.sort(weight);
        int i = 0; //left pointer
        int j = n-1; //right poiunter
        while(i <= j) {
            ans++;
            if(i == j) break;
            if(weight[i] + weight[j] > x) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        io.print(ans);
        io.close();
    }
}
/*import java.util.*;

public class ferrisWheel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.nextLine();

		// Read in weights of children (this optimization is necessary to pass
		// all test cases)
		String[] weightsStr = sc.nextLine().split(" ");
		// weights is of type Integer to prevent having to cast the result from
		// Integer.parseInt() to an int, saving time (part of optimization)
		Integer[] weights = new Integer[n];
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(weightsStr[i]);
		}
		Arrays.sort(weights);

		int ans = 0;
		int i = 0;      // left pointer
		int j = n - 1;  // right pointer
		while (i <= j) {
			ans++;  // Increment number of gondolas used
			if (i == j) break;
			// If total weight is too large, move to lighter child
			if (weights[i] + weights[j] > x) {
				j--;
			}
			// Otherwise, we pair the two children and move on
			else {
				i++;
				j--;
			}
		}
		System.out.println(ans);
	}
}
*/