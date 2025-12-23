package Bronze_Contests;
import java.util.*;
import java.io.*;

public class CandyCaneActual {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] cows = new long[N];
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < cows.length; i++){
            cows[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < M; i++){
            long candy = Long.parseLong(st.nextToken());
            long eaten = 0;
            for(int j = 0; j < N; j++){
                if(eaten == candy) break;
                long inc = Math.min(candy, cows[j]) - eaten;
                if(inc > 0){
                    cows[j] += inc;
                    eaten += inc;
                }
            }
        }

        for(int i= 0; i < N; i++){
            pw.println(cows[i]);
        }
		pw.close();
    }
}
