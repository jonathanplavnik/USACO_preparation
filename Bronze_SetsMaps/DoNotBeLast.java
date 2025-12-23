package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class DoNotBeLast {
    final static String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
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
         Kattio io = new Kattio("notlast");

        int N = io.nextInt(); // num of milkings
        String ans = "";

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++){ // updates map with all the input
            String s = io.next();
            int t = io.nextInt();
            if(map.containsKey(s)){
                map.put(s, map.get(s) + t);
            } else {
                map.put(s, t);
            }
        }

        for(int i = 0; i < cows.length; i++){ // sets all cows to 0 that did not show up
            if(!map.containsKey(cows[i])){
                map.put(cows[i], 0);
            }
        }

        int[] order = new int[cows.length]; // organize list of milk amounts by cow

        for(int i = 0; i < cows.length; i++){
            order[i] = map.get(cows[i]);
        }

        Arrays.sort(order); // ascending order

        int index = 0; 

        for(int i = 1; i < cows.length; i++){
            if(order[i] > order[i - 1]){
                index = i;
                break;
            } 
            
        }

        for(String s : map.keySet()){ // finding the cow in question
            if(map.get(s) == order[index]){
                ans = s;
                break;
            }
        }

        if(index == 0){ // in case there was a tie
            ans = "Tie";
        } else if (index != 6){
            if(order[index] == order[index+1]){
                ans = "Tie";
            }
        }

        // io.println(order[index]);
        // io.println(index);
        // for(Map.Entry<String, Integer> i : map.entrySet()){
        //     io.println(i);
        // }

        
        io.println(ans);
        io.close();

    }
}