package Bronze_Contests;
import java.util.*;
import java.io.*;

public class FarmerJohnActuallyFarms {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] h = readArray(r, N);
            int[] a = readArray(r, N);
            int[] t = readArray(r, N);
            pw.print(solve(h, a, t));
            
        }


		pw.close();
    }
    private static int[] readArray(BufferedReader r, int N) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int[] curr = new int[N];
        for(int j = 0; j < N; j++){
            curr[j] = Integer.parseInt(st.nextToken());
        }
        return curr;
    }
    private static int solve(int[] h, int[] a, int[] t){
        return -1;
    }
}
