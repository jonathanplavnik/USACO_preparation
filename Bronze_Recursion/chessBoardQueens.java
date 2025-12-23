package Bronze_Recursion;
import java.util.*;
import java.io.*;
public class chessBoardQueens {
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

    static char[][] board;
    static int ans;
    
    static void solve(int[] arr){
        for(int i = 0; i < 8; i++){
            if(board[arr[i]][i] == '*'){
                return;
            }
        }
        for(int i = 0; i < 8; i++){
            board[arr[i]][i] ='1';
        }
        boolean works = true;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 8; j++){
                if(Math.abs(arr[i] - arr[j]) == Math.abs(i-j)){
                    works = false;
                }
            }
        }
        if(works) ans++;
        for(int i = 0; i < 8; i++){
            board[arr[i]][i] ='.';
        }
    }
    static void swap(int[] arr, int i, int k){
        int temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
    }
    static void permute(int[] arr, int k){
        if(k == 1){
            solve(arr);
        } else {
            permute(arr, k-1);
            for(int i = 0; i < k-1; i++){
                if(k % 2 == 0){
                    swap(arr, i, k-1);
                } else {
                    swap(arr, 0, k-1);
                }
                permute(arr, k-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();


        board = new char[8][8];

        for(int i = 0; i < 8; i++){
            String s = io.next();
            for(int j = 0; j < 8; j++){
                board[i][j] = s.charAt(j);
            }
        }

        int arr[] = new int[8];
        for(int i = 0; i < 8; i++){
            arr[i] = i;
        }

        permute(arr, 8);


        io.println(ans);



        io.close();

    }
}