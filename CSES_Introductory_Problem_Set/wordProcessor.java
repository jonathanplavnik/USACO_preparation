import java.io.*;
import java.util.*;

public class wordProcessor {
    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(new File("word.in"));
		PrintWriter pw = new PrintWriter("word.out");

        int n = io.nextInt(); // N words where 1 <= N <= 100
        int k = io.nextInt(); // K where K is the max num of charcters in each line
        String[] essay = new String[n];
        for(int i = 0; i < n; i++) {
            essay[i] = io.next();
        }
        int line = k; // num chars on the line

        /*pw.print(essay[0]);
        line -= essay[0].length();
        for(int i = 1; i < n; i++) {
            if(line >= essay[i].length()) {
                pw.print(" " + essay[i]);
                line -= essay[i].length();
            } else {
                line = k;
                pw.println();
                pw.print(essay[i]);
                line -= essay[i].length();
            }
        }
        */
        line = -1;
        for(int i = 0; i < n; i++) {
            if(line >= essay[i].length()) {
                pw.print(" " + essay[i]);
                line -= essay[i].length();
            } else {
                if(line != -1) pw.println();
                line = k;
                pw.print(essay[i]);
                line -= essay[i].length();
            }
        }




        io.close();
        pw.close();

    }
}