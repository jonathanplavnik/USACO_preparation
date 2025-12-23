package Bronze_Complete_Search;
import java.io.*;
import java.util.*;

public class bullChinaShop {
	public static boolean pieces[][][];
	public static int n;
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("bcs");

		pieces = new boolean[11][8][8];
		int[][] s = new int[11][4];
		n = io.nextInt();
		int k = io.nextInt();

		for (int i = 0; i <= k; i++) {
			int left = n - 1;
			int right = 0;
			int top = n - 1;
			int bottom = 0;
			for (int j = 0; j < n; j++) {
				String str = io.next();
				for (int l = 0; l < n; l++) {
					char c = str.charAt(l);
					pieces[i][j][l] = (c == '#');
					// find the sides of the piece
					if (pieces[i][j][l]) {
						bottom = Math.max(bottom, j);
						top = Math.min(top, j);
						right = Math.max(right, l);
						left = Math.min(left, l);
					}
				}
			}
			s[i] = new int[] {left, right, top, bottom};
		}

		// try all the pieces and shifts to find the correct one
		for (int i = 1; i <= k; i++) {
			for (int j = i + 1; j <= k; j++) {
				for (int idx = s[i][3] - n + 1; idx <= s[i][2]; idx++) {
					for (int idy = s[i][1] - n + 1; idy <= s[i][0]; idy++) {
						for (int jdx = s[j][3] - n + 1; jdx <= s[j][2]; jdx++) {
							for (int jdy = s[j][1] - n + 1; jdy <= s[j][0];
							     jdy++) {
								boolean good = true;
								for (int x = 0; x < n; x++) {
									for (int y = 0; y < n; y++) {
										boolean ipiece =
										    check(i, x + idx, y + idy);
										boolean jpiece =
										    check(j, x + jdx, y + jdy);
										// two '#' are in the same place
										if (ipiece && jpiece) {
											good = false;
											break;
										}
										// the result doesn't match the figurine
										if (pieces[0][x][y] !=
										    (ipiece || jpiece)) {
											good = false;
											break;
										}
									}
									if (!good) { break; }
								}
								if (good) {
									io.println(i + " " + j);
									System.exit(0);
								}
							}
						}
					}
				}
			}
		}
		io.close();
	}

	/** checks if a piece location is in bounds and is '#' */
	static boolean check(int piece, int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n && pieces[piece][x][y];
	}

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
}