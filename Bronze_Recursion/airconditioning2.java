package Bronze_Recursion;
import java.util.*;
import java.io.*;

class air {
    int startC;
    int endC;
    int reduce;
    int cost;

    air(int startC, int endC, int reduce, int cost){
        this.startC = startC;
        this.endC = endC;
        this.reduce = reduce;
        this.cost = cost;
    }
}
public class airconditioning2 {
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

        int N = io.nextInt(); // num of cows
        int M = io.nextInt(); // num of air conditioners

        


        //cow conditions
        int[] start = new int[N];
        int[] end = new int[N];
        int[] ideal = new int[N];

        for(int i = 0; i < N; i++){
            start[i] = io.nextInt();
            end[i] = io.nextInt();
            ideal[i] = io.nextInt();
            for(int j = start[i]; j < end[i]+1; j++){
                farm[j] += ideal[i];
            }
        }
        

        //air conditioners

        int[] startC = new int[M];
        int[] endC = new int[M];
        int[] reduce = new int[M];
        int[] cost = new int[M];
        air[] conditioner = new air[M];

        for(int i = 0; i < M; i++){
            startC[i] = io.nextInt();
            endC[i] = io.nextInt();
            reduce[i] = io.nextInt();
            cost[i] = io.nextInt();
            conditioner[i] = new air(startC[i], endC[i], reduce[i], cost[i]);
        }
        
        subsets(conditioner, new ArrayList<air>(), 0);
        io.println(ans);
        io.close();

    }
    static void subsets(air[] conditioner, List<air> currentSubset, int i){
        if (i == conditioner.length) {
            solve(currentSubset);
            return;
        }

        // Recursive case: include the current element in the subset
        currentSubset.add(conditioner[i]);
        subsets(conditioner, currentSubset, i + 1);

        // Recursive case: exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        subsets(conditioner, currentSubset, i + 1);

    }
    static void solve(List<air> currentSubset){
        int money = 0;
        int[] taken = Arrays.copyOf(farm, farm.length);
        air current;
    
        for(int i = 0; i < currentSubset.size(); i++){
            current = currentSubset.get(i);
            for(int j = current.startC; j < current.endC + 1; j++){
                taken[j] -= current.reduce;
            }
            money += current.cost;
        }
        

        boolean check = true;
        for(int i = 0; i < 101; i++){
            if(taken[i] > 0) check = false;
        }
        if(check && money > 0){
            ans = Math.min(ans, money);
        }
        

    }
    static int ans = Integer.MAX_VALUE;
    static int[] cooled = new int[101];
    static int[] farm = new int[101];
}