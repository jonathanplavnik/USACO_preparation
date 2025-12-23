package Bronze_Contests;
import java.util.*;
import java.io.*;
public class CowntactTracing2 {
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
        String s = io.next();
        int[] sick = new int[N];
        List<Integer> zero = new ArrayList<>();
        for(int i = 0; i < sick.length; i++){
            int it = Integer.parseInt(Character.toString(s.charAt(i)));
            sick[i] = it;
            if(it == 0){
                zero.add(i);
            }
        } 

        // all 1's
        if(zero.size() == 0){
            io.println(1);
        }

        // now we find the smallest range of 1s
        int dist = zero.get(1); // start to first 0
        for(int i = 0; i < zero.size()- 1; i++){
            dist = Math.min(dist, zero.get(i+1) - zero.get(i) - 1);
        }
        dist = Math.min(dist, N - zero.get(zero.size()-1) - 1); // last 0 to the end

        int days;
        if(dist == 1){
            days = 0;
        } else {
            days = (dist + 1)/2;
        }

        // Now we know amount of days- we look at each range of 1s to find how many cows must be infected in each range
        // formual is range - 2 * days
        int cows = zero.get(0) - 2 * days;
        int range;
        for(int i = 0; i < zero.size() - 1; i++){
            range = zero.get(i+1) - zero.get(i) - 1;
            cows += (range - 2 * days);

        }
        range = N - zero.get(zero.size()-1) - 1;
        cows += (range - 2 * days);
        

        io.println(cows);
        
        io.close();
    }
}