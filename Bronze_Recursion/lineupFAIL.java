package Bronze_Recursion;
import java.util.*;
import java.io.*;

class next {
    String x; 
    String y;

    next(String x, String y){
        this.x = x;
        this.y = y;
    }
}
public class lineupFAIL {
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
        //Kattio io = new Kattio("lineup");

        N = io.nextInt(); // num of conditions
        close = new next[N];

        for(int i = 0; i < N; i++){
            String[] conditions = new String[6];
            for(int j = 0; j < 6; j++){
                conditions[j] = io.next();
            }
            close[i] = new next(conditions[0], conditions[conditions.length-1]);
        }

        String[] list = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"}; //  list of all anmes
        permute(list, list.length);

        // for(int i = 0; i < 8; i++){
        //     io.println(list[i]);
        // }
        io.close();

    }
    static void permute(String[] list, int k){
        if(k == 1 || end){
            check(list);
        } else {
            permute(list, k-1);
            for(int i = 0; i < k-1; i++){
                if(k % 2 == 0){
                    swap(list, i, k-1);
                } else {
                    swap(list, 0, k-1);
                }
                permute(list, k-1);
            }
        }
    }
    static void swap(String[] arr, int i, int k){
        String temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
    }
    static void check(String[] list){
        boolean valid = true;
        for(int i = 0; i < N; i++){
            next current = close[i]; 
            if(Math.abs(indexOf(list, current.x) - indexOf(list, current.y)) != 1){
                valid = false;
                break;
            } 
        }

        if(valid){
            finalList = list;
            System.out.println(Arrays.toString(finalList));
            end = true;
        }
    }
    static int indexOf(String[] list, String str){
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str)) {
                index = i; // Update the index if the element is found
                break; // Exit the loop since we found the element
            }
        }
        return index;
    }
    static int N;
    static next[] close;
    static String[] finalList;
    static boolean end;
}