import java.io.*;
import java.util.Scanner;

public class fencePainting {
	public static void main(String[] args) throws IOException {
		Scanner r = new Scanner(new File("paint.in"));
		PrintWriter pw = new PrintWriter("paint.out");

		int a = r.nextInt();
		int b = r.nextInt();
		int c = r.nextInt();
		int d = r.nextInt();

		int[] cover = new int[100];
		for (int i = a; i < b; i++) { cover[i] = 1; }
		for (int i = c; i < d; i++) { cover[i] = 1; }

		int ans = 0;
		for (int i = 0; i < cover.length; i++) { ans += cover[i]; }
		pw.println(ans);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}