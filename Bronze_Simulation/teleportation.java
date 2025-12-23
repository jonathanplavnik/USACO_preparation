import java.io.*;
import java.util.*;

public class teleportation {
    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(new File("teleport.in"));
		PrintWriter pw = new PrintWriter("teleport.out");

        int a = io.nextInt(); //start
        int b = io.nextInt(); //end
        int x = io.nextInt(); //tp pos 1
        int y = io.nextInt(); //tp pos 2

        int dis1;
        int dis2;
        int dis3;
        int ans;

        dis1 = Math.abs(a-b);
        dis2 = Math.abs(a-x) + Math.abs(y-b);
        dis3 = Math.abs(a-y) + Math.abs(x-b);

        ans = Math.min(dis1, dis2);
        ans = Math.min(ans, dis3);

        pw.print(ans);

        io.close();
        pw.close();

    }
}