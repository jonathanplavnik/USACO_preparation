package Bronze_Contests;
import java.util.*;
import java.io.*;

public class CowntactTracing2New {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        String s = r.readLine();
        boolean[] finalState = new boolean[N];

        for (int i = 0; i < N; i++) {
            finalState[i] = s.charAt(i) == '1';
        }

        int minInfected = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            boolean[] infected = new boolean[N];
            infected[i] = true;

            for (int day = 0; day < N; day++) {
                boolean[] newInfected = infected.clone();
                for (int j = 0; j < N; j++) {
                    if (infected[j]) {
                        if (j > 0) newInfected[j - 1] = true;
                        if (j < N - 1) newInfected[j + 1] = true;
                    }
                }
                infected = newInfected;
            }

            if (Arrays.equals(infected, finalState)) {

                minInfected = Math.min(minInfected, countInfected(infected));
            }
        }

        pw.println(minInfected == Integer.MAX_VALUE ? 0 : minInfected);
        pw.close();
    }

  
    private static int countInfected(boolean[] infected) {
        int count = 0;
        for (boolean b : infected) {
            if (b) count++;
        }
        return count;
    }
}