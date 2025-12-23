import java.io.*;
import java.util.*;
public class problems2 {
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
        int problems = r.nextInt();
        int q = r.nextInt();
        ArrayList<Integer> problemList = new ArrayList<Integer>();
        for(int i = 0; i < problems; i++){
            problemList.add(r.nextInt());
        }
        for(int i = 0; i < q; i++) {
            int type = r.nextInt();
            int diff = r.nextInt();
            if(type == 1) {
                for(int j = problemList.size()-1; j >= 0; j++) {
                    if(problemList.contains(diff) == false) pw.println(-1);
                   if(problemList.get(i) > diff) {
                       pw.print(problemList.get(i) + " ");
                       problemList.remove(i);
                   }
                }
            } else {
                for(int j = problemList.size() - 1; j >= 0; j++) {
                    if(problemList.get(j) <= diff) {
                        pw.println(problemList.get(j));
                        problemList.remove(j);
                        break;
                    } else {
                        pw.println(-1);
                    }
                }
            }
        }
        pw.close();
    }
}