import java.util.*;
import java.io.*;
public class BessieInterviewFinal {

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

        recurse(K, time);

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

    private static void recurse(int index, int time){

        //base case
        if(index == N){
            while(time < farmersAvailable.peek().time) time++;
            for(Farmer f : farmersAvailable){
                if(f.time == time) avail[f.index] = true;
            }
            return;
        }

        //recursive step
        while(index < N){
            while(time < farmersAvailable.peek().time) time++; 
            ArrayList<Farmer> arr = new ArrayList<>(); // track how many farmers finish at the same time
            arr.add(farmersAvailable.remove());
            while(arr.get(0).equals(farmersAvailable.peek())){
                arr.add(farmersAvailable.remove());
            }
            if(arr.size() == 1){
                int ind = arr.get(0).index;
                farmersAvailable.add(new Farmer(ind, times[index] + time));
                index++;
            } else {
                for(int i = 0; i < arr.size(); i++){
                    recurse(index, time);
                }
            }
        }

    }

}