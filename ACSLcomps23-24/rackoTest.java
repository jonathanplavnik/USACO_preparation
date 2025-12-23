import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'playRackO' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING info
     *  2. STRING rack
     *  3. STRING pile
     */


    static int[] rack;
    public static String playRackO(String info, String racks, String piles) {
        String[] inf = info.split(" ");
        int s = Integer.parseInt(inf[0]);
        int n = Integer.parseInt(inf[1]);
    
        String[] rackString = racks.split(" ");
        String[] pileString = piles.split(" ");
        
        rack = new int[rackString.length];
        int[] pile = new int[pileString.length];
        for(int i = 0; i < rackString.length; i++){
            rack[i] = Integer.parseInt(rackString[i]);
        }
        for(int i = 0; i < pileString.length; i++){
            pile[i] = Integer.parseInt(pileString[i]);
        }


        // set up is completed. rack size is s, pile size is n. rack contains current rack, pile contains all cards in pile


        int stepDown = 0; 

        //calculate num stepDowns
        for(int i = 0; i < rack.length-1; i++){
            if(rack[i] > rack[i+1]) stepDown++;
        }

        // lets calculate ideal slot denominator (n-1)/intervalSize (Strategy A)
        int intervalSize = 0;
        if(n % s == 0) intervalSize = n/s;
        else intervalSize = n/s + 1;

        // game logic, will use helper methods
        int it = 0;
        while(stepDown > 0){
            int tile = pile[it];
            int a = stratA(tile, intervalSize);
            int b = stratB(tile);

            if(b == a && a == stepDown) continue;
            else if (b < a){
                rack[slotB] = tile;
                stepDown = b;
            } else {
                rack[slotA] = tile;
                stepDown = a;
            }
            it++;
        }
        
        // convert rack to string
        String str = "";
        for(int i = 0; i < rack.length; i++){
            str += Integer.toString(rack[i]);
            str += " ";
        }
        return str.substring(0, str.length()-1);
    }
    static int slotA;
    private static int stratA(int tile, int intervalSize){
        int[] tempHand = rack.clone(); // copy of the hand we have

        int interval = (tile-1)/intervalSize; // which slot from rack

        tempHand[interval] = tile;

        //calculate number step downs after change, this can be optimized- no need to read through the entire array to find the stepDowns
        int stepDown = 0; 
        for(int i = 0; i < tempHand.length-1; i++){
            if(tempHand[i] > tempHand[i+1]) stepDown++;
        }
        slotA = interval; // which tile is being switched
        return stepDown;
    }
    
    static int slotB;
    private static int stratB(int tile){
        int[] tempHand = rack.clone(); 
        for(int i = 0; i < tempHand.length-2; i++){
            if(!ascending(tempHand[i], tempHand[i+1], tempHand[i+2])){ // they are not ascending
                if(ascending(tile, tempHand[i+1], tempHand[i+2])) { tempHand[i] = tile; break; }
                else if(ascending(tempHand[i], tile, tempHand[i+2])) { tempHand[i+1] = tile; break; }
                else if(ascending(tempHand[i], tempHand[i+1], tile)) { tempHand[i+2] = tile; break; }
            }
        }

        int stepDown = 0;  // could be optimized just like in stratB
        for(int i = 0; i < tempHand.length-1; i++){
            if(tempHand[i] > tempHand[i+1]) stepDown++;
        }
        return stepDown;
    }
    private static boolean ascending(int a, int b, int c){
        if(a < b && b < c) return true;
        return false;
    } 

}

public class rackoTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String info = "9 70";

        String rack = "40 35 30 56 32 58 44 17 45";

        String pile = "31 37 10 28 21 62 7 64 16 12";

        String result = Result.playRackO(info, rack, pile);

        pw.write(result);
        pw.println();

        bufferedReader.close();
        pw.close();
    }
}
