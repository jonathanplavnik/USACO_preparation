package Bronze_Sorting;
import java.util.*;
import java.io.*;
public class bubbleSort {
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

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] =temp;
    }
    public static void main(String[] args) throws IOException {

        //runs in O(n^2) time (always)



        Kattio io = new Kattio();

        int N = io.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = io.nextInt();
        }

        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    count++;
                } 
            }
        }

        io.println("Array is sorted in " + count + " swaps.");
        io.println("First element: " + arr[0]);
        io.println("Last element: " + arr[arr.length-1]);


        io.close();

    }
}