import java.util.*;
import java.io.*;

class Target {
    private int x1;
    private int x2;
    private int y1;
    private int y3;
    
    public Target(int x1, int x2, int y1, int y3){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y3 = y3;
    }

    int loc(int m, int x, int y){
        if(m > 0) return y - m * x;
        else return y + m * x;
    }
}
public class TargetPractice { 
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken()); // num targets
            int x1 = Integer.parseInt(st.nextToken()); // bottom left coord
            Target[] targets = new Target[N];
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                targets[j] = new Target(x1, c, b, a);
            }
            int[] slopes = new int[4 * N];
            st = new StringTokenizer(r.readLine());
            for(int j = 0; j < 4 * N; j++){
                slopes[j] = Integer.parseInt(st.nextToken());
            }            
            System.out.println(solve(targets, slopes));
        }
        pw.close();
    }
    static int solve(Target[] targets, int[] slopes){
        return -1;
    }
}
