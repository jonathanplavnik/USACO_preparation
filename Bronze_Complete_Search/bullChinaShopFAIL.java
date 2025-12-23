package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class bullChinaShopFAIL {
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
        //Kattio io = new Kattio("bcs");

        int N = io.nextInt(); // N by N figurine
        int K = io.nextInt(); // number of figures on the ground

        char[][] og = new char[N][N];

        for(int i = 0; i < N; i++){
            String s = io.next();
            for(int j = 0; j < N; j++){
                og[i][j] = s.charAt(j);
            }
        }

        char[][] figurines = new char[K*N][N];

        for(int i = 0; i < K * N; i++){
            String str = io.next();
            for(int j = 0; j < N; j++){
                figurines[i][j] = str.charAt(j);
            }
        }


        char[][] current = new char[N][N];
        char[][] next = new char[N][N];

        boolean ans = false;

        
        for(int i = 0; i < K; i++){
            current[0] = figurines[i*N];
            current[1] = figurines[i*N + 1];
            current[2] = figurines[i*N + 2];
            current[3] = figurines[i*N + 3];

            for(int j = i+1; j < K; j++){
                next[0] = figurines[j*N];
                next[1] = figurines[1 + j*N];
                next[2] = figurines[2 + j*N];
                next[3] = figurines[3 + j*N];

                ans = solve(current, next, og);
                if(ans){
                    io.println((i+1) + " " + (j+1));
                    break;
                }

            } 
            
        }





        io.close();

    }

    public static boolean solve(char[][] current, char[][] next, char[][] og){
        
        if((countY(current[0]) + countY(current[1]) + countY(current[2]) + countY(current[3]) + countY(next[0]) + countY(next[1]) + countY(next[2]) + countY(next[3])) != (countY(og[0]) + countY(og[1]) + countY(og[2]) + countY(og[3]))){
            return false;
        }

        
        while(countX(current, 0) == 0){ // move to the left
            for(int i = 0; i < current[0].length; i++){
                for(int j = 0; j < current[0].length; j++){
                    if(current[i][j] == '#'){
                        current[i][j] = '*';
                        current[i][j-1] = '#';
                    }
                }
            }
        }
        while(countY(current[current[0].length - 1]) == 0){ // move to the bottom
            for(int i = 0; i < current[0].length; i++){
                for(int j = 0; j < current[0].length; j++){
                    if(current[i][j] == '#'){
                        current[i][j] = '*';
                        current[i-1][j] = '#';
                    }
                }
            }
        }

        while(countX(current, current[0].length - 1) != 0){
            while(countY(current[0]) != 0){
                for(int i = 0; i < current[0].length; i++){
                    for(int j = 0; j < current[0].length; j++){
                        if(current[i][j] == '#'){
                            current[i][j] = '*';
                            current[i+1][j] = '#';
                        }
                    }
                }
            }
            for(int i = 0; i < current[0].length; i++){
                for(int j = 0; j < current[0].length; j++){
                    if(current[i][j] == '#'){
                        current[i][j] = '*';
                        current[i+1][j] = '#';
                    }
                }
            }
        }

















        return true;
    }

    public static int countY(char[] it){
        int ans = 0;
        for(int i = 0; i < it.length; i++){
            if(it[i] == '#') ans++;
        }
        return ans;
    }
    public static int countX(char[][] it, int j){
        int ans = 0;
        for(int i = 0; i < it.length; i++){
            if(it[i][j] == '#') ans++;
        }
        return ans;
    }
    public static boolean checker(char[][] it, char[][] og){
        for(int i = 0; i < it[0].length; i++){
            for(int j = 0; j < it[0].length; j++){
                if(it[i][j] == '#' && og[i][j] != '#') return false;
            }
        }
        return true;
    }
    public static boolean NoOverlap(char[][] it, char[][] item){
        for(int i = 0; i < it[0].length; i++){
            for(int j = 0; j < it[0].length; j++){
                if(it[i][j] == '#' && item[i][j] == '#') return false;
            }
        }
        return true;
    }
}