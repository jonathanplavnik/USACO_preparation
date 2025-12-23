import java.util.*;
import java.io.*;
public class trafficFail {
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
    /*public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("traffic");

        int N = io.nextInt(); //number of lines, length of road

		int minOn = 0;
		int maxOn = 0;
		int minOff = 0;
		int maxOff = 0;
		int a;
		int b;

        String in = "";
		int j = 0;
		while(true) {
			j++;
			in = io.next();
			if(in.equals("none")) break;
			a = io.nextInt();
			b = io.nextInt();
			if(in.equals("on")){
				minOn += a;
				maxOn += b;
			} else {
				minOff += a;
				maxOff += b;
			}
		}

		String ex = "";
		int min = io.nextInt();
		int max = io.nextInt();


		int minOnAfter = 0;
		int maxOnAfter = 0;
		int minOffAfter = 0;
		int maxOffAfter = 0;
		
		for(int i = j; i < N; i++){
			ex = io.next();
			a = io.nextInt();
			b = io.nextInt();
			if(ex.equals("on")){
				min += a;
				max += b;
				minOnAfter += a;
				maxOnAfter += b;
			} else if (ex.equals("off")) {
				max -= a;
				min -= b;
				minOffAfter += a;
				maxOffAfter += b;
			} else {
				min = Math.max(min, a);
				max = Math.min(max, b);
				minOnAfter = 0;
				maxOnAfter = 0;
				minOffAfter = 0;
				maxOffAfter = 0;
				
			}
		}

		// io.println(minOn);
		// io.println(maxOff);
		// io.println(maxOn);
		// io.println(minOff);

		int ans1 = Math.max(min + minOff - minOnAfter - maxOn + maxOffAfter, 0);
		int ans2 = max - minOn + minOffAfter + maxOff - maxOnAfter;
		min = Math.max(min, 0);

		
		io.println(ans1 + " " + ans2);
		io.println(min + " " + max);





        io.close();

    }
} */
public static void on(int[] xy, int first, int second) {
	xy[0] = Math.max(0, xy[0] + first);
	xy[1] = Math.max(0, xy[1] + second);
}
public static void off(int[] xy, int first, int second) {
	xy[0] = Math.max(0, xy[0] - second);
	xy[1] = Math.max(0, xy[1] - first);
}
public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("traffic");

        int N = io.nextInt(); //number of lines, length of road

		String[] type = new String[N];
		int[] first = new int[N];
		int[] second = new int[N];

		int min = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			type[i] = io.next();
			first[i] = io.nextInt();
			second[i] = io.nextInt();

			min -= first[i];
			max -= second[i];
		}

		int[] xy = {min, max};








        io.close();

    }
}