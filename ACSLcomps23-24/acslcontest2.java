import java.util.*;
import java.io.*;


public class acslcontest2 {
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


        String ex = encodeMessage("To be or not to be, that is the question - a quote by William Shakespeare.  2B or not 2B - a hexadecimal equivalent!  How would you write it?", 
        "Boolean is always True!");
        System.out.println(ex);


        //("2.1.2 1.3.1 1.4.2 2.7.7 1.12.5 2.5.1 2.3.1_3.5.1 1.10.4_1.15.9 3.2.4 3.4.1 2.5.1 1.13.2 1.15.6_1.1.1 3.4.2 3.2.3 2.6.2!", ex);
        
        io.close();
    }
    
    public static String encodeMessage(String text, String message) {
        
        String str = "";
        
        // second approach, store everything in advance


        HashMap<Character, ArrayList<info>> index = new HashMap<>();

        for(char c = 'a'; c <= 'z'; c++){
            index.put(c, new ArrayList<info>());
        }
        for(char c = 'A'; c <= 'Z'; c++){
            index.put(c, new ArrayList<info>());
        }
        for(char c = '0'; c <= '9'; c++){
            index.put(c, new ArrayList<info>());
        }

        int s = 1;
        int w = 1;
        int c = 0;

        for(int i = 0; i < text.length()-1; i++){
            char x = text.charAt(i);
            if(index.keySet().contains(x)){
                c++;
                index.get(x).add(new info(s, w, c));
            } 
            if(x == '.' || x == '!' || x == '.'){ // new sentence
                s++;
                w = 0;
                c = 0;
            } 
            if(x == ' ' && text.charAt(i+1) != ' '){ // new word
                w++;
                c = 0;
            }
        }

        // assume all the data has been stored from the text, now we traverse over the message
        int nonchar = 0;
        for(int i = 0; i < message.length()-1; i++){
            char x = message.charAt(i);
            if(x == ' '){ // space
                str += "_";
                nonchar++;
            }
            else if(!index.keySet().contains(x)){ // means this is some niche character
                str += String.valueOf(x);
                nonchar++;
            } else { // these letters are what we are looking for
                ArrayList<info> it = index.get(x);
                int occur = i+1 - nonchar;
                while(occur > it.size()){
                    occur /= 2;
                }
                info curr = it.get(occur-1);
                str += curr.toString();
            }

            if(index.keySet().contains(message.charAt(i+1)) && index.keySet().contains(x)) str += " ";
        }
        str += String.valueOf(message.charAt(message.length()-1));


        return str;
    }
}

class info {
    private int s;
    private int w;
    private int c;

    public info(int s, int w, int c){
        this.s = s;
        this.w = w;
        this. c = c;
    }

    public String toString(){
        return s + "." + w + "." + c;
    }
}