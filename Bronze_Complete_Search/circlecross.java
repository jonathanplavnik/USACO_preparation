package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class circlecross {
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
    final static int line = 52;
    public static void main(String[] args) throws IOException {
        // Kattio io = new Kattio();
         Kattio io = new Kattio("circlecross");

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;
        int v = 0;
        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;

        int start = 0;
        int end;
        int ans = 0;


        String in = io.next(); // entire input 
        for(int it = 0; it < line; it++){
            start = it;
            end = 0;
            for(int it1 = it + 1; it1 < line; it1++){
                if(in.charAt(start) == in.charAt(it1)){
                    end = it1;
                }
            }
            
            

            if(end != 0){
                for(int beg = start + 1; beg < end; beg++){
                    if(in.charAt(beg) == 'A') a++;
                    if(in.charAt(beg) == 'B') b++;
                    if(in.charAt(beg) == 'C') c++;
                    if(in.charAt(beg) == 'D') d++;
                    if(in.charAt(beg) == 'E') e++;
                    if(in.charAt(beg) == 'F') f++;
                    if(in.charAt(beg) == 'G') g++;
                    if(in.charAt(beg) == 'H') h++;
                    if(in.charAt(beg) == 'I') i++;
                    if(in.charAt(beg) == 'J') j++;
                    if(in.charAt(beg) == 'K') k++;
                    if(in.charAt(beg) == 'L') l++;
                    if(in.charAt(beg) == 'M') m++;
                    if(in.charAt(beg) == 'N') n++;
                    if(in.charAt(beg) == 'O') o++;
                    if(in.charAt(beg) == 'P') p++;
                    if(in.charAt(beg) == 'Q') q++;
                    if(in.charAt(beg) == 'R') r++;
                    if(in.charAt(beg) == 'S') s++;
                    if(in.charAt(beg) == 'T') t++;
                    if(in.charAt(beg) == 'U') u++;
                    if(in.charAt(beg) == 'V') v++;
                    if(in.charAt(beg) == 'W') w++;
                    if(in.charAt(beg) == 'X') x++;
                    if(in.charAt(beg) == 'Y') y++;
                    if(in.charAt(beg) == 'Z') z++;
                }


            
                if(a == 1) ans++;
                if(b == 1) ans++;
                if(c == 1) ans++;
                if(d == 1) ans++;
                if(e == 1) ans++;
                if(f == 1) ans++;
                if(g == 1) ans++;
                if(h == 1) ans++;
                if(i == 1) ans++;
                if(j == 1) ans++;
                if(k == 1) ans++;
                if(l == 1) ans++;
                if(m == 1) ans++;
                if(n == 1) ans++;
                if(o == 1) ans++;
                if(p == 1) ans++;
                if(q == 1) ans++;
                if(r == 1) ans++;
                if(s == 1) ans++;
                if(t == 1) ans++;
                if(u == 1) ans++;
                if(v == 1) ans++;
                if(w == 1) ans++;
                if(x == 1) ans++;
                if(y == 1) ans++;
                if(z == 1) ans++;
            }

            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = 0;
            h = 0;
            i = 0;
            j = 0;
            k = 0;
            l = 0;
            m = 0;
            n = 0;
            o = 0;
            p = 0;
            q = 0;
            r = 0;
            s = 0;
            t = 0;
            u = 0;
            v = 0;
            w = 0;
            x = 0;
            y = 0;
            z = 0;


        }

        io.println(ans/2);
        io.close();

    }
}