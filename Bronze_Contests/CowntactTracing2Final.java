package Bronze_Contests;
import java.util.*;
import java.io.*;
public class CowntactTracing2Final {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        String s = st.nextToken();
        int[] sick = new int[N];
        List<Integer> zero = new ArrayList<>();
        for(int i = 0; i < sick.length; i++){
            int it = Integer.parseInt(Character.toString(s.charAt(i)));
            sick[i] = it;
            if(it == 0){
                zero.add(i);
            }
        } 

        // all 1's
        
        if(zero.size() > 1){
            int dist = zero.get(0); // start to first 0]
            if(dist == 0) dist = Integer.MAX_VALUE; // if dist is 0 it messes stuff up
            for(int i = 0; i < zero.size()- 1; i++){
                dist = Math.min(dist, zero.get(i+1) - zero.get(i) - 1);
            }
            int x = N - zero.get(zero.size()-1) - 1; // last 0 to the end
            if(x > 0) dist = Math.min(dist, x); // dont want dist to be 0

            
            // calculate min days
            int days;
            if(dist == 1){
                days = 0;
            } else {
                days = (dist + 1)/2;
            }

            // Now we know amount of days- we look at each range of 1s to find how many cows must be infected in each range
            // formula is num 1s - 2 * days
            int cows = zero.get(0) - 2 * days;
            int range;
            for(int i = 0; i < zero.size() - 1; i++){
                range = zero.get(i+1) - zero.get(i) - 1;
                cows += (range - 2 * days);

            }
            range = N - zero.get(zero.size()-1) - 1;
            cows += (range - 2 * days);
            pw.println(cows);
            pw.println(dist);
        } else if (zero.size() == 1){
            // note that you cant just say '2' 

            int dist = Math.min(zero.get(0), N - zero.get(zero.size()-1) - 1);
            int days;
            if(dist == 1){
                days = 0;
            } else {
                days = (dist + 1)/2;
            }
            if (dist == 0){ // checking to see if either beg or end is 0, albeit in a different way
                pw.println(1); 
            } else {
                int cows = zero.get(0) - 2 * days;
                cows += ((N - zero.get(zero.size()-1) - 1) - 2 * days);
                pw.println(cows);
                pw.println(dist);
            }   
        } else {
            pw.println(1);
        }
        
        
        pw.close();
    }
}