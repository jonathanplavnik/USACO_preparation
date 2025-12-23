import java.util.*;
import java.io.*;

public class promote {
    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(new File("promote.in"));
		PrintWriter pw = new PrintWriter("promote.out");

        io.nextInt();
        io.nextInt();
        int s1 = io.nextInt();
        int s2 = io.nextInt();
        int g1 = io.nextInt();
        int g2 = io.nextInt();
        int p1 = io.nextInt();
        int p2 = io.nextInt();

        int ans1;
        int ans2;
        int ans3;

        ans3 = p2-p1;
        ans2 = g2- g1 + ans3;
        ans1 = s2- s1 + ans2;
        pw.println(ans1);
        pw.println(ans2);
        pw.println(ans3);








        io.close();
        pw.close();
    }
}