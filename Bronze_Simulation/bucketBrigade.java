import java.io.*;
import java.util.*;

public class bucketBrigade {
    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(new File("buckets.in"));
		PrintWriter pw = new PrintWriter("buckets.out");

        int bX = 0;
        int bY = 0;
        int rX = 0;
        int rY = 0;
        int lX = 0;
        int lY = 0;
        String input;

        for(int i = 0; i < 10; i++){
            input = io.next();
            for(int j = 0; j < 10; j++){
                if(input.charAt(j) == 'B') {
                    bX = j;
                    bY = i;
                }
                if(input.charAt(j) == 'R') {
                    rX = j;
                    rY = i;
                }
                if(input.charAt(j) == 'L') {
                    lX = j;
                    lY = i;
                }
            }
        }

        if(bX == rX && rX == lX ) {
            if(Math.abs(rY- bY) + Math.abs(lY - rY) == Math.abs(lY- bY)) {
                pw.println(Math.abs(lX- bX) + Math.abs(lY-bY) + 1);
            } else {
                pw.println(Math.abs(lX- bX) + Math.abs(lY-bY) - 1);
            }
        } else if (bY == rY && rY == lY) {
            if(Math.abs(rX- bX) + Math.abs(lX - rX) == Math.abs(lX- bX)) {
                pw.println(Math.abs(lX- bX) + Math.abs(lY-bY) + 1);
            } else {
                pw.println(Math.abs(lX- bX) + Math.abs(lY-bY) - 1);
            }
        } else {
            pw.println(Math.abs(lX- bX) + Math.abs(lY-bY) - 1);
        }



        io.close();
        pw.close();
    }
}