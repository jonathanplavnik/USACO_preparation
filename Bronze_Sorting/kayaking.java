package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class kayaking {
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
    // public static void main(String[] args) throws IOException {
    //     Kattio io = new Kattio();

    //     int n = io.nextInt();
    //     ArrayList<Integer> weight = new ArrayList<>();

    //     for(int i = 0; i < 2*n; i++){
    //         weight.add(io.nextInt());
    //     }

    //     Collections.sort(weight);

    //     int ans = 0;
    //     int diff = 0;
    //     int check = 0;
    //     int index = 0;
    //     for(int i = 0; i < 2; i++){
    //         for(int j = weight.size() - 1; j > 0; j--){
    //             diff = Math.max(diff, weight.get(j) - weight.get(j-1));
    //             if(diff != check) index = j ;
    //             check = diff;
    //         }
    //         weight.remove(index);
    //         diff = 0;
    //         check = 0;
    //     }


    //     for(int i = weight.size() - 1; i >= 1; i -= 2){
    //         ans = ans + weight.get(i) -  weight.get(i-1);
    //     }
        

    //     io.println(ans);
    //     io.close();

    // }
    // public static void main(String[] args) throws IOException {
    //     Kattio io = new Kattio();

    //     int n = io.nextInt();
    //     ArrayList<Integer> weight = new ArrayList<>();

    //     for(int i = 0; i < 2*n; i++){
    //         weight.add(io.nextInt());
    //     }

    //     Collections.sort(weight);

    //     int ans = 0;

    //     ArrayList<Integer> diff = new ArrayList<>();

    //     for(int i = 0; i < 2 * n; i += 2){
    //         int x = weight.get(i+1) - weight.get(i);
    //         diff.add(x);
    //         ans += x;
    //     }

    //     Collections.sort(diff);

    //     ans -= diff.get(diff.size()-1);

    //     int check = 0;

    //     weight.remove(0);
    //     weight.remove(weight.size()-1);

    //     for(int i = 0; i < weight.size(); i += 2){
    //         check = check - weight.get(i) + weight.get(i+1);
    //     }

    //     ans = Math.min(ans, check);


    //     io.println(ans);
    //     io.close();

    // }
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        ArrayList<Integer> weight = new ArrayList<>();

        for(int i = 0; i < 2*n; i++){
            weight.add(io.nextInt());
        }

        Collections.sort(weight);

        int ans = Integer.MAX_VALUE;
        

        for(int i = 0; i < weight.size(); i++){
            for(int j = i + 1; j < weight.size(); j++){
                ArrayList<Integer> clone = new ArrayList<>(weight);
                clone.remove(i);
                clone.remove(j - 1);
                ans = Math.min(ans, diff(clone));
            }
        }

        io.println(ans);
        io.close();

    }
    static int diff(List<Integer> clone){
        int check = 0;
        for(int i = 0; i < clone.size(); i += 2){
            check = check - clone.get(i) + clone.get(i+1);
        }
        return check;
    }
}