package Bronze_Contests;
import java.util.*;
import java.io.*;


public class BalancingBacteria {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());

        int patchesCount = Integer.parseInt(st.nextToken()); 
        long[] patchesAlpha = new long[patchesCount];

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < patchesAlpha.length; ++i) {
            patchesAlpha[i] = Long.parseLong(st.nextToken());
        }

        int result = solution(patchesAlpha);

        pw.println(result);
        pw.close();
    }

    private static int solution(long[] patchesAlpha) {
        int result = 0;
        long sum = 0;
        long prev = 0;
        for (int i = 0; i < patchesAlpha.length; ++i) {
            long delta = (patchesAlpha[i] - prev) - sum;
            result += Math.abs(delta);
            sum += delta;
            prev = patchesAlpha[i];
        }
        return result;
    }


}
