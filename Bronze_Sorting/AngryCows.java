package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class AngryCows {
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

		int N = io.nextInt(); // num hay bales

		ArrayList<Integer> list = new ArrayList<>();
        
		for(int i = 0; i < N; i++){
			list.add(io.nextInt());
		}

		Collections.sort(list);

		ArrayList<Integer> clone = new ArrayList<>(list);

		int ans = 0;
		for(int i = 0; i < N; i++){
			ans = Math.max(ans, solve(clone, i));
			clone.clear();
			clone.addAll(list);
		}

		io.println(ans);
        io.close();

    }
	static int solve(ArrayList<Integer> list, int index){

		int i = index, j = index, t = 0, ans = 0;


		while(i >= 0 && j <= list.size() - 1){
			t++;

			int next = i;
			while(Math.abs(list.get(i) - list.get(next)) <= t){
				if(i < 0){
					break;
				}
				i--;
			}
			int Next = i;
			while(Math.abs(list.get(j) - list.get(Next)) <= t){
				if(j > list.size() - 1){
					break;
				}
				j++;
			}
		
		}
		

		

		for(int k = 0; k < list.size(); k++){
			if(list.get(k) == -1) ans++;
		}
		return ans;
	}
}