package Bronze_Contests;

import java.util.*;
import java.io.*;
public class CandyCaneNew {
    static final class cane{
        public int eaten;
        public int height;

        public cane(int height){
            this.height = height;
            this.eaten = 0;
        }

        public int leftover() {
            return height - eaten;
        }
    }
    static cane candy;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken()); // num cows
        int M = Integer.parseInt(st.nextToken()); // num candy canes

        long[] cows = new long[N];
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < cows.length; i++){
            cows[i] = Long.parseLong(st.nextToken());
        }
        cane[] canes = new cane[M];
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < canes.length; i++){
            canes[i] = new cane(Integer.parseInt(st.nextToken()));
        }

        for(int j = 0; j < canes.length; j++){
            candy = canes[j];
            for(int i = 0; i < cows.length; i++){
                int leftover = candy.leftover();
                if(leftover <= 0){
                    break;
                }
                if(cows[i] > candy.eaten){
                    long eaten = Math.min(leftover, cows[i] - candy.eaten);
                    cows[i] += eaten;
                    candy.eaten += eaten;
                }
            }
        }

        for(long i : cows){
            pw.println(i);
        }

        pw.close();
    }
}