// import java.util.*;
// import java.io.*;

import java.util.Arrays;

public class racoTesting {
    public static void main(String[] args) {
        String info = "8 100";

        String rack = "6 13 47 62 32 70 76 12";

        String pile = "3 67 80 10 39 44 2 43 90 85 21 63 4 52";
        
        String result = playRackO(info, rack, pile);

        System.out.println(result);
    }

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
            if(it >= pile.length) break;
            int tile = pile[it];
            it++;
            int a = stratA(tile, intervalSize);
            int b = stratB(tile);

            if(a > stepDown && slotB < 0) continue;
            else if (b < a){
                if(slotB > 0){
                    rack[slotB] = tile;
                    stepDown = b;
                }
            } else {
                rack[slotA] = tile;
                stepDown = a;
            }
            
            System.out.println(Arrays.toString(rack));
            
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

        if((tempHand[interval] -1)/ intervalSize == interval) return Integer.MAX_VALUE; // check to see if card at this slot already fits critera

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
        slotB = -1; 
        for(int i = 0; i < tempHand.length-2; i++){
            if(!ascending(tempHand[i], tempHand[i+1], tempHand[i+2])){ // they are not ascending
                if(ascending(tile, tempHand[i+1], tempHand[i+2])) { tempHand[i] = tile; slotB = i; break; }
                else if(ascending(tempHand[i], tile, tempHand[i+2])) { tempHand[i+1] = tile; slotB = i+1; break; }
                else if(ascending(tempHand[i], tempHand[i+1], tile)) { tempHand[i+2] = tile; slotB = i+2; break; }
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
