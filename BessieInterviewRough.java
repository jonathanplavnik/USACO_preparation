import java.util.*;
import java.io.*;
public class BessieInterviewRough {

    static class Farmer implements Comparable<Farmer> {
        int index; // The farmer's index
        int time; // The time at which this farmer will be available
        
        Farmer(int index, int time) {
            this.index = index;
            this.time = time;
        }
        
        public int compareTo(Farmer other) {
            return this.time - other.time;
        }
    }

    static PriorityQueue<Farmer> farmersAvailable = new PriorityQueue<>();
    static int times[];
    static boolean[] avail;
    static int N;

    public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken()); // num cows before Bessie
        int K = Integer.parseInt(st.nextToken()); // num farmers that are hiring

        st = new StringTokenizer(r.readLine());
        times = new int[N];
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++){
            farmersAvailable.add(new Farmer(i, times[i]));
        }
        avail = new boolean[K];
        int time = 0;

        int index = K;


        while(index < N){
            while(time < farmersAvailable.peek().time) time++; 
            ArrayList<Farmer> arr = new ArrayList<>(); // track how many farmers finish at the same time
            arr.add(farmersAvailable.remove());
            while(arr.get(0).time == farmersAvailable.peek().time){
                arr.add(farmersAvailable.remove());
            }
            if(arr.size() > 1){
                for(int i = 0; i < arr.size(); i++){
                    avail[arr.get(i).index] = true;
                }
            } 
            for(int i = 0; i < arr.size(); i++){
                int ind = arr.get(i).index;
                farmersAvailable.add(new Farmer(ind, times[index] + time));
                index++;
            }
                
        }

        while(time < farmersAvailable.peek().time) time++;


        for(Farmer f : farmersAvailable){
            if(f.time == time) avail[f.index] = true;
        }

        // Now we determine which farmers could potentially interview Bessie
        StringBuilder potentialFarmers = new StringBuilder();
        for (int i = 0; i < avail.length; i++) {
            if (avail[i]) {
                potentialFarmers.append("1");
            } else {
                potentialFarmers.append("0");
            }
        }
        pw.println(time);
        pw.println(potentialFarmers);
		pw.close();
    }
}