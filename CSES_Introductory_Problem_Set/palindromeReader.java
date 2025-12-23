import java.util.*;
import java.io.*;
public class palindromeReader {
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
	private static Object reverse;
    public static void main(String[] args) {
        Kattio io = new Kattio();

		String in = io.next();
		HashMap<String, Integer> charCount = new HashMap<String, Integer>();
		String[] input = in.split("");
        int len = input.length;

		for(String s : input) {
			if (charCount.containsKey(s)) {
				charCount.put(s, charCount.get(s) + 1);
			} else {
				charCount.put(s , 1);
			}
		}

		int flag = 0;
		int oddFlag = 0;
		for(HashMap.Entry<String, Integer> set : charCount.entrySet()) { //idk what this does
			int val = set.getValue() % 2;

			if(val != 0){
				if(len % 2 == 0 || oddFlag == 1){
					flag = 1;
					break;
				}
				for (int l = 0 ; l<set.getValue(); l++)
                    io.append(set.getKey());
                	oddFlag++;
            } else {
                for (int k = 0; k < set.getValue()/2; k++)
                    io.append(set.getKey());
            }
        }

        if (flag==0){
            System.out.print(io);
            System.out.print(io);
            // io.reverse(Collections(reverse));
            System.out.print(io);
        } else System.out.println("NO SOLUTION");
		io.close();
	}
}