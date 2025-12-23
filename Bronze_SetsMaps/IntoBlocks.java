package Bronze_SetsMaps;
import java.util.*;
import java.io.*;
public class IntoBlocks {
    final static int q = 0;

    static class Block{
        public int start;
        public int end;
        public int element;
        public int size;

        public Block(int element, int end, int start){
            this.start = start;
            this.end = end;
            this.element = element;
            this.size = (end - start) + 1;
        }
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
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        io.nextInt();
        int[] num = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        

        for(int i = 0; i < n; i++){
            int it = io.nextInt();
            num[i] = it;
            if(!map.containsKey(it)){
                map.put(it, 1);
            } else {
                map.put(it, map.get(it) + 1);
            }
        }

        List<Block> blocks = new ArrayList<>();

        int start = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[i - 1]) {
                blocks.add(new Block(num[start], start, i - 1));
                start = i;
            }
        }
        blocks.add(new Block(num[start], start, num.length - 1)); 

        

        int diff = 0;
        for(int i = 0; i < blocks.size(); i++){
            //if(check(blocks)) break;
            int total = 0;
            for(int j = i + 1; j < blocks.size(); j++){
                if(blocks.get(i).element == blocks.get(j).element){
                    diff += total;
                    for(int k = i+1; k < j; k++){
                        blocks.get(k).element = blocks.get(i).element;
                    }
                    i = j;
                    break;
                }
                total += blocks.get(j).size;
                
            }
        }

        io.println(diff);
        io.close();

    }
    public static boolean check(List<IntoBlocks.Block> blocks){
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < blocks.size(); i++){
            s.add(blocks.get(i).element);
        }
        if(blocks.size() == s.size()){
            return true;
        }
        return false;
    }
}