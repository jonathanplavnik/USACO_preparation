import java.util.*;
import java.io.*;


public class Desperation {
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

        int T = io.nextInt();

        for(int k = 0; k < T; k++){
            int N = io.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++){
                list.add(io.nextInt());
            }

            ArrayList<Integer> sorted = new ArrayList<>(list);
            sorted.sort(Collections.reverseOrder());

            // move element within a
            int mismatchIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(sorted.get(i))) {
                    mismatchIndex = i;
                    break;
                }
            }

            if(mismatchIndex != -1){
                int index = list.lastIndexOf(sorted.get(mismatchIndex));
                int removed = list.remove(index);
                
                TreeMap<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());
                for (int num : list) {
                    freq.put(num, freq.getOrDefault(num, 0) + 1);
                }

                ArrayList<Integer> b = new ArrayList<>();
                for (Integer num : list) {
                    
                    int highest = freq.firstKey();
                    if (num == highest) {
                        b.add(num);
                    }
                    
                    int count = freq.get(num);
                    if (count == 1) {
                        freq.remove(num);
                    } else {
                        freq.put(num, count - 1);
                    }
                }
                b.add(removed);
                b.sort(Collections.reverseOrder());
                
                StringBuilder sb = new StringBuilder();
                for (int num : b) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb.toString().trim());
            } else {
            
                StringBuilder sb = new StringBuilder();
                for (int num : list) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb.toString().trim());
            }


        }
        io.close();
    }	
}