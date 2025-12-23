import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        PrintWriter out=new PrintWriter(System.out);

        for(int index=0; index<T;index++){
            int N=Integer.parseInt(br.readLine());
            long[] a=new long[N+1];
            String[] sp=br.readLine().split(" ");
            for(int i=1;i<=N;i++){
                a[i]=Long.parseLong(sp[i-1]);
            }
            long[] prefix=new long[N+1];
            for(int i=1;i<=N;i++){
                prefix[i]=prefix[i-1]+a[i];
            }

            // dpB[i]: max(B-E) if next turn is B's after considering first i cakes
            // dpE[i]: max(B-E) if next turn is E's after considering first i cakes
            long[] dpB = new long[N+1]; 
            long[] dpE = new long[N+1]; 

            // Base cases
            dpB[0]=0;
            dpE[0]=Long.MIN_VALUE/2; // impossible state initially

            // We track running values to achieve O(N):
            long maxValFor0 = Long.MIN_VALUE/2; // max over j of (dpE[j]-prefix[j])
            long minValFor1 = dpB[0]+prefix[0]; // min over j of (dpB[j]+prefix[j]) initially = 0

            for(int i=1;i<=N;i++){
                // dpB[i] = prefix[i] + max_{j<i}(dpE[j]-prefix[j])
                dpB[i] = prefix[i] + maxValFor0;
                // dpE[i] = -prefix[i] + min_{j<i}(dpB[j]+prefix[j])
                dpE[i] = -prefix[i] + minValFor1;

                // Update tracking values:
                if (dpE[i]-prefix[i] > maxValFor0) {
                    maxValFor0 = dpE[i]-prefix[i];
                }
                if (dpB[i]+prefix[i] < minValFor1) {
                    minValFor1 = dpB[i]+prefix[i];
                }
            }

            // After N steps, the final is dpB[N] since we end on Bessie's turn:
            long diff = dpB[N]; 
            long sum=prefix[N];
            long bessie=(sum+diff)/2;
            long elsie=sum-bessie;
            out.println(bessie+" "+elsie);
        }

        out.flush();
    }
}
