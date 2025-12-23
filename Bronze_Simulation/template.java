import java.io.*;
import java.util.*;
//template for CodeForces, CSES
public class template {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { //reads in the next string
            while(tokenizer == null || tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        //code here
        //r.next() reads the next token up to a whitespace and returns a String
        //r.nextInt reads up to the next token up to a whitespace and returns as an int
        //r.nextLong reads up to the next token up to a whitespace and returns as a long
        //r.nextDouble reads up to the next token up to a whitespace and returns as a double
        //pw.println() prints the argument to designated output stream and adds new line
        //pw.print() prints teha rgument to designated output stream



        //part under this is not in template
        int a = r.nextInt();
        int b = r.nextInt();
        int c = r.nextInt();
        pw.println(a + b + c);

        pw.close(); //flushes the output once printing is done
    }
}