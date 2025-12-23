import java.util.*;
import java.io.*;

public class BestLineup2 {
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

        for (int k = 0; k < T; k++) {
            int N = io.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                a.add(io.nextInt());
            }

            // Find the maximum element and its rightmost occurrence
            int maxVal = Collections.max(a);
            int maxIdx = a.lastIndexOf(maxVal);

            List<Integer> modifiedA = new ArrayList<>(a);
            if (maxIdx != 0) {
                // Move the rightmost max element to the front
                modifiedA.remove(maxIdx);
                modifiedA.add(0, maxVal);
            } else {
                // If max is already at front, find the next best move
                int nextMax = -1;
                int nextMaxIdx = -1;
                for (int i = 1; i < modifiedA.size(); i++) {
                    int current = modifiedA.get(i);
                    if (current > nextMax) {
                        nextMax = current;
                        nextMaxIdx = i;
                    } else if (current == nextMax) {
                        nextMaxIdx = i; // Prefer rightmost
                    }
                }

                if (nextMax != -1) {
                    // Find the best position to move nextMax
                    int bestPos = 0;
                    for (int i = 0; i < nextMaxIdx; i++) {
                        if (modifiedA.get(i) < nextMax) {
                            bestPos = i;
                            break;
                        }
                    }
                    if (bestPos < nextMaxIdx) {
                        modifiedA.remove(nextMaxIdx);
                        modifiedA.add(bestPos, nextMax);
                    }
                }
            }

            // Build sequence b using greedy approach
            TreeMap<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());
            for (int num : modifiedA) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            List<Integer> b = new ArrayList<>();
            for (int num : modifiedA) {
                int highest = freq.firstKey();
                if (num == highest) {
                    b.add(num);
                }
                // Update frequency
                int count = freq.get(num);
                if (count == 1) {
                    freq.remove(num);
                } else {
                    freq.put(num, count - 1);
                }
            }

            // Output the result
            StringBuilder sb = new StringBuilder();
            for (int num : b) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        io.close();
    }
}