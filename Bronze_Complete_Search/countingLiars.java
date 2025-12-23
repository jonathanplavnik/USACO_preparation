package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
// import java.lang.*;
public class countingLiars {
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
//         Kattio io = new Kattio();

//         int N = io.nextInt(); // num of cows

// 		int[] upperBoundv1 = new int[N];
// 		int[] lowerBoundv1 = new int[N];
// 		String s;

// 		 for(int i = 0; i < N; i++){
// 			s = io.next();
// 			if(s.equals("G")) lowerBoundv1[i] = io.nextInt();
// 			if(s.equals("L")) upperBoundv1[i] = io.nextInt();
//         }

// 		int[] upperBound = new int[upperBoundv1.length + 2];
// 		int[] lowerBound = new int[upperBoundv1.length + 2];

// 		for(int i = 0; i < upperBoundv1.length; i++){
// 			if(upperBoundv1[i] == 0) upperBoundv1[i] = Integer.MAX_VALUE;
// 			upperBound[i] = upperBoundv1[i];
// 		}
// 		upperBound[upperBoundv1.length] = Integer.MAX_VALUE;
// 		upperBound[upperBoundv1.length+1] = Integer.MAX_VALUE;

// 		for(int i = 0; i < lowerBoundv1.length; i++){
// 			lowerBound[i] = lowerBoundv1[i];
// 		}
// 		lowerBound[lowerBoundv1.length] = 0;
// 		lowerBound[lowerBoundv1.length+1] = 0;
		
// 		Arrays.sort(upperBound);
// 		Arrays.sort(lowerBound);

//         int ans = 0;

//         int i = lowerBound.length - 1;
// 		int j = 0;


// 		// io.println(Arrays.toString(lowerBound));
// 		// io.println(Arrays.toString(upperBound));
// 		while(lowerBound[i] > upperBound[j]){
// 			if(lowerBound[i] - lowerBound[i-1] < upperBound[j+1] - upperBound[j]){
// 				j++;
// 			} else {
// 				i--;
// 			}
// 			ans++;
// 		}

// 		io.print(ans);


//         io.close();

//     }
// }
// Kattio io = new Kattio();

//         int N = io.nextInt(); // num of cows

// 		long[] upperBound = new long[N];
// 		long[] lowerBound = new long[N];
// 		String s;

// 		for(int i = 0; i < N; i++){
// 			s = io.next();
// 			if(s.equals("G")) lowerBound[i] = io.nextLong();
// 			if(s.equals("L")) upperBound[i] = io.nextLong();
//         }

// 		for(int i = 0; i < N; i++){
// 			if(upperBound[i] == 0) upperBound[i] = Integer.MAX_VALUE;
// 		}
	
// 		Arrays.sort(upperBound);
// 		Arrays.sort(lowerBound);

//         int ans = 0;
//         int i = lowerBound.length - 1;
// 		int j = 0;

// 		// io.println(Arrays.toString(lowerBound));
// 		// io.println(Arrays.toString(upperBound));
// 		while(lowerBound[i] > upperBound[j]){
// 			ans++;
// 			if(lowerBound[i] - lowerBound[i-1] < upperBound[j+1] - upperBound[j]){
// 				j++;
// 			} else {
// 				i--;
// 			}
// 		}

// 		io.print(ans);
//         io.close();

//     }
// }
// Kattio io = new Kattio();

//         int N = io.nextInt(); // num of cows

// 		long[] upperBound = new long[N];
// 		long[] lowerBound = new long[N];
// 		String s;

// 		for(int i = 0; i < N; i++){
// 			s = io.next();
// 			if(s.equals("G")) lowerBound[i] = io.nextLong();
// 			if(s.equals("L")) upperBound[i] = io.nextLong();
//         }

// 		for(int i = 0; i < N; i++){
// 			if(upperBound[i] == 0) upperBound[i] = Integer.MAX_VALUE;
// 		}
	
// 		Arrays.sort(upperBound);
// 		Arrays.sort(lowerBound);

//         int ans = 0;
//         int i = lowerBound.length - 1;
// 		int j = 0;


// 		while(lowerBound[i] > upperBound[j]){
// 			ans++;
// 			i--;
// 		}

// 		int ans1 = 0;
// 		i = lowerBound.length - 1;
// 		while(lowerBound[i] > upperBound[j]){
// 			ans1++;
// 			j++;
// 		}

// 		ans = Math.min(ans, ans1);


// 		// io.println(Arrays.toString(lowerBound));
// 		// io.println(Arrays.toString(upperBound));
		

// 		io.print(ans);
//         io.close();

//     }
// }
// Kattio io = new Kattio();

//         int N = io.nextInt(); // num of cows

// 		long[] upperBound1 = new long[N];
// 		long[] lowerBound1 = new long[N];
// 		String s;
// 		int left = 0;

// 		for(int i = 0; i < N; i++){
// 			s = io.next();
// 			if(s.equals("G")){
// 				lowerBound1[i] = io.nextLong();
// 				left++;
// 			}  
// 			if(s.equals("L")) upperBound1[i] = io.nextLong();
//         }

// 		long[] lowerBound  = new long[left + 1];
// 		long[] upperBound  = new long[N - left + 1];

// 		for(int i = 0; i < left; i++){
// 			if(lowerBound1[i] != 0){
// 				lowerBound[i] = lowerBound1[i];
// 			}
// 		}
// 		lowerBound[left] = 0;

		
// 		Arrays.sort(upperBound1);
// 		for(int i = N - 1; i >= left; i--){
// 			upperBound[N - i - 1] = upperBound1[i];
// 		}



// 		// io.println(Arrays.toString(upperBound));
// 		upperBound[N - left] = Integer.MAX_VALUE;
		
	
// 		Arrays.sort(upperBound);
// 		Arrays.sort(lowerBound);

//         int ans = Integer.MAX_VALUE;
// 		int check = 0;

// 		// io.println(Arrays.toString(lowerBound));
// 		// io.println(Arrays.toString(upperBound));

// 		// io.println(lowerBound[lowerBound.length - 1]);
// 		// io.println(upperBound[0]);
		
// 		if(lowerBound[lowerBound.length - 1] <= upperBound[0]){
// 			ans = 0;
// 		} else {
// 			for(int i = 1; i < left + 1; i++){
// 				for(int j = 0; j < N - left; j++){
// 					check += LL(lowerBound, i);
// 					check += RL(upperBound, j);
// 					io.println(check);
// 					if(lowerBound[i-1] <= upperBound[j+1]) ans = Math.min(ans, check);
// 					check = 0;
// 				}
// 			}
// 		}
		

// 		io.print(ans);
//         io.close();

//     }

// 	public static int LL(long[] it, int i){
// 		return it.length - i;
// 	}
// 	public static int RL(long[] it, int i){
// 		return i + 1;
// 	}
// }
Kattio io = new Kattio();

        int N = io.nextInt(); // num of cows

		long[] upperBound = new long[N];
		long[] lowerBound = new long[N];
		String s;

		for(int i = 0; i < N; i++){
			s = io.next();
			if(s.equals("G")) lowerBound[i] = io.nextLong();
			if(s.equals("L")) upperBound[i] = io.nextLong();
        }

		for(int i = 0; i < N; i++){
			if(upperBound[i] == 0) upperBound[i] = Integer.MAX_VALUE;
		}
	
		Arrays.sort(upperBound);
		Arrays.sort(lowerBound);

        int ans = Integer.MAX_VALUE;
		int check = 0;

		
		
			for(int i = 1; i < N + 1; i++){
				for(int j = -1; j < N - 1; j++){
					check += LL(lowerBound, i);
					check += RL(upperBound, j);
					// io.println(check);
					if(lowerBound[i-1] <= upperBound[j+1]) ans = Math.min(ans, check);
					check = 0;
				}
			}
		
		

		io.print(ans);
        io.close();

    }

	public static int LL(long[] it, int i){
		if(i == it.length) return 0;
		return it.length - i;
	}
	public static int RL(long[] it, int i){
		return i + 1;
	}
}