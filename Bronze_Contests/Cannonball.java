package Bronze_Contests;
import java.util.*;
import java.io.*;
public class Cannonball {
    static int targetsBroken = 0;
    static int direction = 1;
    static List<Integer> jumpPad = new ArrayList<>();
    static List<Integer> target = new ArrayList<>();
    static int power = 1;

    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int start = (Integer.parseInt(st.nextToken()) - 1); // starting location

        int curr;
        int val;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(r.readLine());
            curr = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());
            if(curr == 0){
                jumpPad.add(val);
                target.add(-1);
            } else {
                jumpPad.add(-1);
                target.add(val);
            }
        }


        
        fire(start, direction);
        pw.println(targetsBroken);


		pw.close();
    }
    
    public static void fire(int start, int direction){
        if(start < 0 || start >= jumpPad.size()) return;
        int tar = target.get(start);
        int jump = jumpPad.get(start);

        if(tar > -1){
            if(power >= tar){
                targetsBroken++;
                target.set(start, -1);
            }
        }
        if(jump > -1){
            power += jump;
            direction *= -1;
        }
        fire(start + power * direction, direction);
    }
}