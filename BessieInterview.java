import java.util.*;
import java.io.*;
public class BessieInterview {

    static PriorityQueue<Integer> farmersAvailable = new PriorityQueue<>();
    static int time = 0;
    static int times[];

    public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken()); // num cows before Bessie
        int K = Integer.parseInt(st.nextToken()); // num famers that are hiring

        st = new StringTokenizer(r.readLine());
        times = new int[N];
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++){
            farmersAvailable.add(times[i]);
        }
        

        int index = K;
        while(index < N){
            while(time < farmersAvailable.peek()) time++; 
            while(farmersAvailable.peek() == time){
                farmersAvailable.remove();
                farmersAvailable.add(times[index] + time);
                index++;
            }
        }

        while(time < farmersAvailable.peek()) time++;

        // Now we determine which farmers could potentially interview Bessie
        StringBuilder potentialFarmers = new StringBuilder();
        for (int i : farmersAvailable) {
            if (i == time) {
                potentialFarmers.append("1");
            } else {
                potentialFarmers.append("0");
            }
        }
        pw.println(time);
        pw.println(potentialFarmers);
		pw.close();
    }

    private void recurse(){



    }

}