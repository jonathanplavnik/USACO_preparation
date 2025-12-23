// import java.util.*;
// import java.io.*;

// class Target {
//     private int x1;
//     private int x2;
//     private int y1;
//     private int y3;
    
//     public Target(int x1, int x2, int y1, int y3){
//         this.x1 = x1;
//         this.x2 = x2;
//         this.y1 = y1;
//         this.y3 = y3;
//     }

//     int loc(int m, int x, int y){
//         if(m > 0) return y - m * x;
//         else return y + m * x;
//     }
// }


// public class TargetPractice2Final {
//     static int x1;

//     static class Kattio extends PrintWriter {
// 		private BufferedReader r;
// 		private StringTokenizer st;
// 		// standard input
// 		public Kattio() { this(System.in, System.out); }
// 		public Kattio(InputStream i, OutputStream o) {
// 			super(o);
// 			r = new BufferedReader(new InputStreamReader(i));
// 		}
// 		// USACO-style file input
// 		public Kattio(String problemName) throws IOException {
// 			super(problemName + ".out");
// 			r = new BufferedReader(new FileReader(problemName + ".in"));
// 		}
// 		// returns null if no more input
// 		public String next() {
// 			try {
// 				while (st == null || !st.hasMoreTokens())
// 					st = new StringTokenizer(r.readLine());
// 				return st.nextToken();
// 			} catch (Exception e) { }
// 			return null;
// 		}
// 		public int nextInt() { return Integer.parseInt(next()); }
// 		public double nextDouble() { return Double.parseDouble(next()); }
// 		public long nextLong() { return Long.parseLong(next()); }
// 	}
//     public static void main(String[] args) throws IOException {
//         Kattio io = new Kattio();


//         int T = io.nextInt(); // num test cases

//         for(int i = 0; i < T; i++){
//             int N = io.nextInt(); 
//             x1 = io.nextInt(); // left-most x coordinate

//             Target[] targets = new Target[N];

//             for(int j = 0; j < N; j++){
//                 int y1 = io.nextInt();
//                 int y2= io.nextInt();
//                 int x2 = io.nextInt();
//                 targets[j] = new Target(x1, x2, y1, y2);
//             }

//             ArrayList<Integer> pos = new ArrayList<>();
//             ArrayList<Integer> neg = new ArrayList<>();
//             for(int j = 0; j < 4 * N; j++){
//                 int curr = io.nextInt();
//                 if(curr < 0) neg.add(curr);
//                 else pos.add(curr);
//             }

//             if(neg.size() < N || pos.size() < N){
//                 io.println(-1);
//             } else{
//                 // lets define an upper bound for the slopes
//                 int high = search();
//                 int low = search();
//                 io.println(high - low);
//             }
//         }
//         io.close();

//     }	
// }